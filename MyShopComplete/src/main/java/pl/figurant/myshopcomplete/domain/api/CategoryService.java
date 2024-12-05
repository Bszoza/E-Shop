package pl.figurant.myshopcomplete.domain.api;

import pl.figurant.myshopcomplete.domain.category.Category;
import pl.figurant.myshopcomplete.domain.category.CategoryDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService {
    private final CategoryDao categoryDao = new CategoryDao();

    public List<CategoryInfo> findAll() {
        List<Category> categories = categoryDao.getAll();
        List<CategoryInfo> categoriesInfo = new ArrayList<CategoryInfo>();
        for (Category category : categories) {
            categoriesInfo.add(categoryInfoTransform(category));
        }
        return categoriesInfo;
    }

    public Optional <CategoryInfo> findById(int id) {
        return categoryDao.getById(id).map(CategoryInfoMapper::map);
    }

    private CategoryInfo categoryInfoTransform(Category category) {
        return new CategoryInfo(category.getId(), category.getName(), category.getDescription());
    }

    private static class CategoryInfoMapper {
        static CategoryInfo map(Category c) {
            return new CategoryInfo(
                    c.getId(),
                    c.getName(),
                    c.getDescription()
            );
        }

    }
}
