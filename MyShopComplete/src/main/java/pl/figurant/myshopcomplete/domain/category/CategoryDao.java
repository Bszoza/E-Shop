package pl.figurant.myshopcomplete.domain.category;

import pl.figurant.myshopcomplete.config.DataSourceProvider;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao {
    private final DataSource dataSource;

    public CategoryDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getAll() {
        final String query = """
                SELECT
                id, name, description
                FROM category""";
        try (Connection connection = this.dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                Category category = transferDataToCategory(resultSet);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
            throw new RuntimeException();
        }

    }

    public Optional<Category> getById(int id) {
        final String query = """
                SELECT
                    id, name, description
                FROM
                    category
                WHERE
                    id = ?
                """;
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Category category = transferDataToCategory(resultSet);
                return Optional.of(category);
            } else return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category transferDataToCategory(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new Category(id, name, description);
    }
}
