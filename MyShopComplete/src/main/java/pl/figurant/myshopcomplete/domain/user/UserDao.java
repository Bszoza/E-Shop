package pl.figurant.myshopcomplete.domain.user;

import pl.figurant.myshopcomplete.domain.api.UserInfo;
import pl.figurant.myshopcomplete.domain.api.UserOrderHistoryInfo;
import pl.figurant.myshopcomplete.domain.common.BaseDao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
    public void save(User user) {
        saveUser(user);
        saveUserRole(user);
    }

    private void saveUser(User user) {
        final String query = """
                INSERT INTO
                    user (username, password, email, name, last_name, registration_date)
                VALUES
                     (?,?,?,?,?,?)
                """;
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setObject(6, user.getRegistrationDate());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUserRole(User user) {
        final String query = """
                INSERT INTO
                    user_role (username, role_name)
                VALUES
                    (?,?)
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, "USER");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getEmails() {
        final String query = """
                SELECT
                    email
                    FROM user
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<String> emails = new ArrayList<>();
            while (resultSet.next()) {
                String mail = resultSet.getString("email");
                emails.add(mail);
            }
            return emails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getUsernames() {
        final String query = """
                SELECT
                    username
                    FROM user
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<String> usernames = new ArrayList<>();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                usernames.add(username);
            }
            return usernames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserInfo getUserInfo(String usernameQuery) {
        final String query = """
                SELECT
                    username, email, name, last_name, registration_date
                    FROM user WHERE username = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usernameQuery);
            ResultSet resultSet = statement.executeQuery();
            UserInfo user = null;
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                Date registrationDate = resultSet.getDate(("registration_date"));
                user = new UserInfo(name, lastName, email, username, registrationDate);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserOrderHistoryInfo> getUserOrderHistory(String email) {
        final String query = """
                SELECT product_names, price, date, shipping_price, phone_number, address 
                FROM order_private WHERE email = ?
                UNION ALL
                SELECT product_names, price, date, shipping_price, phone_number, address 
                FROM order_company WHERE email = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, email);  // drugi raz dla drugiej tabeli zeby miec unie spełniona
            ResultSet resultSet = statement.executeQuery();
            List<UserOrderHistoryInfo> history = new ArrayList<>();
            while (resultSet.next()) {
                String productNames = resultSet.getString("product_names");
                Date dateOrder = resultSet.getDate("date");
                String phone = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal shippingPrice = resultSet.getBigDecimal("shipping_price");
                price = price.add(shippingPrice).setScale(2, RoundingMode.HALF_UP);
                UserOrderHistoryInfo record = new UserOrderHistoryInfo(productNames, dateOrder, price, address, phone);
                history.add(record);
            }
            return history;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
