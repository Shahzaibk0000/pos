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
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productList.add(productObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public ArrayList<Product> searchProductByName(String name) {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product productObj = null;
        String query = "SELECT * from product where product_name = '" + name + "'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategory(rs.getString("category"));
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productList.add(productObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public ArrayList<Product> searchProductById(int id) {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product productObj = null;
        String query = "SELECT * from product where product_id = '" + id + "'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategory(rs.getString("category"));
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productList.add(productObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void saveProduct(Product product) {
        Product productObj = product;
        String query = "insert into product (product_name , category , supplier , rsp , net_rsp , storage_location , status) values('" +
                productObj.getName() + "','" + productObj.getCategory() + "','" + productObj.getSupplier() + "'," + productObj.getRsp() +
                "," + productObj.getNetRsp() + ",'" + productObj.getStorageLocation() + "','" + productObj.getStatus() + "')";

        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
