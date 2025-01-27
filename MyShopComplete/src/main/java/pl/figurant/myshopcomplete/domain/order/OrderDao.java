package pl.figurant.myshopcomplete.domain.order;

import pl.figurant.myshopcomplete.domain.common.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao extends BaseDao {

    public void savePrivateOrder(OrderPrivate order) {
        final String query = """
                INSERT INTO
                    order_private (country, name, last_name, email, address, postal_code, phone_number, product_names, price, shipping_price, date)
                VALUES
                     (?,?,?,?,?,?,?,?,?,?,?)
                """;
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getCountry());
            preparedStatement.setString(2, order.getName());
            preparedStatement.setString(3, order.getLastName());
            preparedStatement.setString(4, order.getEmail());
            preparedStatement.setString(5, order.getAddress());
            preparedStatement.setString(6, order.getPostalCode());
            preparedStatement.setString(7, order.getPhone());
            preparedStatement.setString(8, order.getProductNames());
            preparedStatement.setBigDecimal(9, order.getPrice());
            preparedStatement.setDouble(10, order.getShippingPrice());
            preparedStatement.setObject(11, order.getOrderDate());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while saving private order", e);
        }
    }

    public void saveCompanyOrder(OrderCompany order) {
        final String query = """
                INSERT INTO
                    order_company (country, NIP, company_name, email, address, postal_code, phone_number, product_names, price, shipping_price, date)
                VALUES
                     (?,?,?,?,?,?,?,?,?,?,?)
                """;
        try (Connection connection = this.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, order.getCountry());
            preparedStatement.setString(2, order.getNIP());
            preparedStatement.setString(3, order.getCompanyName());
            preparedStatement.setString(4, order.getEmail());
            preparedStatement.setString(5, order.getAddress());
            preparedStatement.setString(6, order.getPostalCode());
            preparedStatement.setString(7, order.getPhone());
            preparedStatement.setString(8, order.getProductNames());
            preparedStatement.setBigDecimal(9, order.getPrice());
            preparedStatement.setDouble(10, order.getShippingPrice());
            preparedStatement.setObject(11, order.getOrderDate());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while saving company order", e);
        }
    }
}
