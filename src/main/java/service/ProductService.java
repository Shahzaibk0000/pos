package service;
import dao.ProductDao;
import entity.Product;
import java.util.ArrayList;
import java.util.Map;

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

    public Map<String,Integer> getAllProductMap() {
        return productDao.getAllProductMap();
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}