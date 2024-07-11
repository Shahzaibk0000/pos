package dao;

import entity.Inventory;
import entity.Sale;
import util.AppConstant;

import java.sql.*;
import java.util.ArrayList;

public class SaleDao {
    public ArrayList<Sale> searchSaleById(int id) {
        ArrayList<Sale> saleList = new ArrayList<Sale>();
        Sale saleObj = null;
        String query = "SELECT inventory.inventory_id,inventory.product_id,inventory.quantity,inventory.count, product.product_name FROM inventory INNER JOIN product ON inventory.product_id = product.product_id where product.product_id = '"+id+"'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                saleObj = new Sale();
                saleObj.setInventoryId(rs.getInt("inventory_id"));
                saleObj.setProductId(rs.getInt("product_id"));
                saleObj.setQuantity(rs.getInt("quantity"));
                saleObj.setCount(rs.getInt("count"));
                saleObj.setProductName(rs.getString("product_name"));
                saleList.add(saleObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleList;
    }

    public void updateCount(int id , int count){
        String query = "update inventory Set count = " + count + " where product_id = " + id + ";";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Sale> searchSaleByName(String name) {
        ArrayList<Sale> saleList = new ArrayList<Sale>();
        Sale saleObj = null;
        String query = "SELECT inventory.inventory_id,inventory.product_id,inventory.quantity,inventory.count, product.product_name FROM inventory INNER JOIN product ON inventory.product_id = product.product_id where product.product_name like('"+name+"')";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                saleObj = new Sale();
                saleObj.setInventoryId(rs.getInt("inventory_id"));
                saleObj.setProductId(rs.getInt("product_id"));
                saleObj.setQuantity(rs.getInt("quantity"));
                saleObj.setCount(rs.getInt("count"));
                saleObj.setProductName(rs.getString("product_name"));
                saleList.add(saleObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleList;
    }
}
