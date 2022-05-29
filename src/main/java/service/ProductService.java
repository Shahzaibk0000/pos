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
}
