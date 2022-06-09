package dao;

import entity.Inventory;
import util.AppConstant;

import java.sql.*;
import java.util.ArrayList;

public class InventoryDao {

    public ArrayList<Inventory> getAllInventory() {
        ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
        Inventory inventoryObj = null;
        String query = "SELECT inventory.*, category.category_name, product.product_name FROM inventory INNER JOIN category ON inventory.category_id = category.category_id INNER JOIN product ON inventory.product_id = product.product_id";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                inventoryObj = new Inventory();
                inventoryObj.setInventoryId(rs.getInt("inventory_id"));
                inventoryObj.setCategoryId(rs.getInt("category_id"));
                inventoryObj.setProductId(rs.getInt("product_id"));
                inventoryObj.setPurchasePrice(rs.getDouble("purchase_price"));
                inventoryObj.setQuantity(rs.getInt("quantity"));
                inventoryObj.setTotalPrice(rs.getDouble("total_price"));
                inventoryObj.setStorageLocation(rs.getString("storage_location"));
                inventoryObj.setInventoryStatus(rs.getString("inventory_status"));
                inventoryObj.setDate(rs.getString("inventory_date"));
                inventoryObj.setCategoryName(rs.getString("category_name"));
                inventoryObj.setProductName(rs.getString("product_name"));
                inventoryList.add(inventoryObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    public ArrayList<Inventory> searchInventoryById(int id) {
        ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
        Inventory inventoryObj = null;
        String query = "SELECT inventory.*, category.category_name, product.product_name FROM inventory INNER JOIN category ON inventory.category_id = category.category_id INNER JOIN product ON inventory.product_id = product.product_id where inventory_id = '"+id+"'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                inventoryObj = new Inventory();
                inventoryObj.setInventoryId(rs.getInt("inventory_id"));
                inventoryObj.setCategoryId(rs.getInt("category_id"));
                inventoryObj.setProductId(rs.getInt("product_id"));
                inventoryObj.setPurchasePrice(rs.getDouble("purchase_price"));
                inventoryObj.setQuantity(rs.getInt("quantity"));
                inventoryObj.setTotalPrice(rs.getDouble("total_price"));
                inventoryObj.setStorageLocation(rs.getString("storage_location"));
                inventoryObj.setInventoryStatus(rs.getString("inventory_status"));
                inventoryObj.setDate(rs.getString("inventory_date"));
                inventoryObj.setCategoryName(rs.getString("category_name"));
                inventoryObj.setProductName(rs.getString("product_name"));
                inventoryList.add(inventoryObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }


    public void saveInventory(Inventory inventory) {
        Inventory inventoryobj = inventory;
        String query = "insert into inventory (category_id , product_id ,purchase_price , quantity , total_price , storage_location , inventory_status , inventory_date) values(" +
                inventoryobj.getCategoryId() + "," + inventoryobj.getProductId() + "," + inventoryobj.getPurchasePrice() +
                "," + inventoryobj.getQuantity() + "," + inventoryobj.getTotalPrice() + ",'" + inventoryobj.getStorageLocation() + "','" + inventoryobj.getInventoryStatus() +"','"
                + inventoryobj.getDate()+"');";

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
