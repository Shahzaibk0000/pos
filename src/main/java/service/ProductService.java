package service;

import dao.ProductDao;
import entity.Product;

import java.util.ArrayList;

public class ProductService {
    private ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDao();
    }

    public ArrayList<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    public ArrayList<Product> searchProductByName(String name) {
        return productDao.searchProductByName(name);
    }

    public ArrayList<Product> searchProductById(int id) {
        return productDao.searchProductById(id);
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}