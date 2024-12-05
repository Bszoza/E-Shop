package pl.figurant.myshopcomplete.domain.product;

import pl.figurant.myshopcomplete.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private final DataSource dataSource;

    public ProductDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
    //Wczytuje pordukty z bazy danych
    public List<Product> findAll() {
        final String query = """
                SELECT
                    id, name, url, description, product_image, category_id, price, discount, in_stock
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

    //Tworzy obiekt produkt z danych wczytanych przez baze
    private Product transferDataToProduct(ResultSet resultSet) throws SQLException {
        int productID = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String ulr = resultSet.getString("url");
        String description = resultSet.getString("description");
        Integer category_id = resultSet.getInt("category_id");
        Double price = resultSet.getDouble("price");
        Double discount = resultSet.getDouble("discount");
        Integer in_stock = resultSet.getInt("in_stock");
        String image = resultSet.getString("product_image");
        return new Product(productID, name, description, price, in_stock, image, category_id, discount, ulr);
    }
}
