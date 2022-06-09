package dao;

import entity.Category;
import entity.Product;
import util.AppConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryDao {
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Category categoryObj = null;
        String query = "SELECT * from category";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                categoryObj = new Category();
                categoryObj.setId(rs.getInt("category_id"));
                categoryObj.setName(rs.getString("category_name"));
                categoryObj.setBarcode(rs.getInt("category_barcode"));
                categoryList.add(categoryObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public Map<String,Integer> getAllCategoryMap() {
        Map<String,Integer> map = new HashMap<>();
        String query = "SELECT * from category";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                map.put(rs.getString("category_name"),rs.getInt("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public ArrayList<Category> searchCategoryByName(String name) {
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Category categoryobj = null;
        String query = "SELECT * from category WHERE category_name like ('%"+name+"%');";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                categoryobj = new Category();
                categoryobj.setId(rs.getInt("category_id"));
                categoryobj.setName(rs.getString("category_name"));
                categoryobj.setBarcode(rs.getInt("category_barcode"));
                categoryList.add(categoryobj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public ArrayList<Category> searchCategoryById(int id) {
        ArrayList<Category> categoryList = new ArrayList<Category>();
        Category productObj = null;
        String query = "SELECT * from category where category_id = '" + id + "'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                Category categoryObj = new Category();
                categoryObj.setId(rs.getInt("category_id"));
                categoryObj.setName(rs.getString("category_name"));
                categoryObj.setBarcode(rs.getInt("category_barcode"));
                categoryList.add(categoryObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public void saveCategory(Category category) {
        Category categoryObj = category;
        String query = "insert into category(category_id,category_name,category_barcode) values("
                +categoryObj.getId()+",'" + categoryObj.getName() + "'," + categoryObj.getBarcode() + ")";

        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(Category category) {
        Category categoryobj = category;
        String query = "update category SET category_name = '" + categoryobj.getName() +
                "',"+"category_barcode = " +categoryobj.getBarcode() + " WHERE category_id = " + categoryobj.getId() + ";";

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
