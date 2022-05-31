package service;

import dao.CategoryDao;
import dao.ProductDao;
import entity.Category;
import entity.Product;

import java.util.ArrayList;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService() {
        this.categoryDao = new CategoryDao();
    }

    public ArrayList<Category> getAllCategory() {
        return categoryDao.getAllCategory();
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
}
