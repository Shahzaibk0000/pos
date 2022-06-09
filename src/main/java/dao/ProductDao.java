package dao;

import entity.Category;
import entity.Product;
import entity.User;
import util.AppConstant;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductDao {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product productObj = null;
        String query = "SELECT product.*, category.category_name , supplier.supplier FROM product INNER JOIN category ON product.category_id =category.category_id INNER JOIN supplier ON product.supplier_id = supplier.supplier_id;";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategoryId(rs.getInt("category_id"));
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productObj.setCategory(rs.getString("category_name"));
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
        String query = "SELECT product.*, category.category_name , supplier.supplier FROM product INNER JOIN category ON product.category_id =category.category_id INNER JOIN supplier ON product.supplier_id = supplier.supplier_id WHERE product_name like ('%"+name+"%');";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategoryId(rs.getInt("category_id"));
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productObj.setCategory(rs.getString("category_name"));
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
        String query = "SELECT product.*, category.category_name , supplier.supplier FROM product INNER JOIN category ON product.category_id =category.category_id INNER JOIN supplier ON product.supplier_id = supplier.supplier_id" +
                "WHERE product_id = "+id+";";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                productObj = new Product();
                productObj.setId(rs.getInt("product_id"));
                productObj.setName(rs.getString("product_name"));
                productObj.setCategoryId(rs.getInt("category_id"));
                productObj.setSupplier(rs.getString("supplier"));
                productObj.setRsp(rs.getDouble("rsp"));
                productObj.setNetRsp(rs.getDouble("net_rsp"));
                productObj.setStorageLocation(rs.getString("storage_location"));
                productObj.setStatus(rs.getString("status"));
                productObj.setCategory(rs.getString("category_name"));
                productList.add(productObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Map<String,Integer> getAllProductMap() {
        Map<String,Integer> map = new HashMap<>();
        String query = "SELECT * from product";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                map.put(rs.getString("product_name"),rs.getInt("product_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


    public void saveProduct(Product product) {
        Product productObj = product;
        String query = "insert into product (product_name , category_id , supplier_id , rsp , net_rsp , storage_location , status) values('" +
                productObj.getName() + "','" + productObj.getCategoryId() + "','" + productObj.getSupplierId() + "'," + productObj.getRsp() +
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

    public void updateProduct(Product product) {
        Product productObj = product;
        String query = "update product SET product_name = '" + productObj.getName() +
                "',"+"category_id = '" +productObj.getCategoryId() +"'," + "supplier_id = '"+productObj.getSupplierId()+"',"
                + "rsp = "+productObj.getRsp()+"," + "net_rsp = "+ productObj.getNetRsp() + "," +
                "storage_location = '" + productObj.getStorageLocation() + "'," + "status = '"+ productObj.getStatus() + "'"
        + "WHERE product_id = " + productObj.getId() + ";";

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