package service;
import dao.CategoryDao;
import entity.Category;
import java.util.ArrayList;
import java.util.Map;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService() {
        this.categoryDao = new CategoryDao();
    }

    public ArrayList<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    public Map<String,Integer> getAllCategoryMap() {
        return categoryDao.getAllCategoryMap();
    }

    public ArrayList<Category> searchCategoryByName(String name) {
        return categoryDao.searchCategoryByName(name);
    }

    public ArrayList<Category> searchCategoryById(int id) {
        return categoryDao.searchCategoryById(id);
    }

    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);
    }

    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }
}
