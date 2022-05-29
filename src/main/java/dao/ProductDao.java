package dao;

import entity.Product;
import entity.User;
import util.AppConstant;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product productObj = null;
        String query = "SELECT * from product";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategory(rs.getString("category"));
                productList.add(productObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
