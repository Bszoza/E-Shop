package pl.figurant.myshopcomplete.domain.product;

import pl.figurant.myshopcomplete.config.DataSourceProvider;
import pl.figurant.myshopcomplete.domain.category.Category;
import pl.figurant.myshopcomplete.domain.common.BaseDao;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao extends BaseDao {


    //Wczytuje pordukty z bazy danych
    public List<Product> getAll() {
        final String query = """
                SELECT
                    id, name, description, product_image, category_id, price, discount, in_stock
                    FROM product
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Product> allProducts = new ArrayList<>();
            while (resultSet.next()) {
                Product prodcut = transferDataToProduct(resultSet);
                allProducts.add(prodcut);
            }
            return allProducts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getByCategoryId(int categoryId) {
        final String query = """
                SELECT id, name, description, product_image, category_id, price, discount, in_stock
                FROM product
                WHERE category_id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(transferDataToProduct(resultSet));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Optional<Product> getById(int id) {
        final String query = """
                SELECT id, name, description, product_image, category_id, price, discount, in_stock
                FROM product
                WHERE id = ?
                """;
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Product product = transferDataToProduct(resultSet);
                return Optional.of(product);
            } else return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Tworzy obiekt produkt z danych wczytanych przez baze
    private Product transferDataToProduct(ResultSet resultSet) throws SQLException {
        int productID = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        Integer category_id = resultSet.getInt("category_id");
        Double price = resultSet.getDouble("price");
        Double discount = resultSet.getDouble("discount");
        Integer in_stock = resultSet.getInt("in_stock");
        String image = resultSet.getString("product_image");
        return new Product(productID, name, description, price, in_stock, image, category_id, discount);
    }
}
