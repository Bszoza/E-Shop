package pl.figurant.myshopcomplete.domain.user;

import pl.figurant.myshopcomplete.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


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
}
