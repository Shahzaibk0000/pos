package dao;
import entity.Supplier;
import util.AppConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SupplierDao {
    public ArrayList<Supplier> getAllSupplier() {
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        Supplier supplierObj = null;
        String query = "SELECT * from supplier";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                supplierObj = new Supplier();
                supplierObj.setId(rs.getInt("supplier_id"));
                supplierObj.setSupplier(rs.getString("supplier"));
                supplierObj.setContactPerson(rs.getString("contact_person"));
                supplierObj.setCity(rs.getString("city"));
                supplierObj.setContactNumber(rs.getString("contact_number"));
                supplierObj.setLicenseDetail(rs.getString("license_detail"));
                supplierObj.setStatus(rs.getString("status"));
                supplierObj.setStatusDate(rs.getString("status_date"));
                supplierObj.setStatus(rs.getString("status"));
                supplierList.add(supplierObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    public ArrayList<Supplier> searchSupplierByName(String name) {
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        Supplier supplierObj = null;
        String query = "SELECT * from supplier where supplier like(%" + name +"%);";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                supplierObj = new Supplier();
                supplierObj.setId(rs.getInt("supplier_id"));
                supplierObj.setSupplier(rs.getString("supplier"));
                supplierObj.setContactPerson(rs.getString("contact_person"));
                supplierObj.setCity(rs.getString("city"));
                supplierObj.setContactNumber(rs.getString("contact_number"));
                supplierObj.setLicenseDetail(rs.getString("license_detail"));
                supplierObj.setStatus(rs.getString("status"));
                supplierObj.setStatusDate(rs.getString("status_date"));
                supplierObj.setStatus(rs.getString("status"));
                supplierList.add(supplierObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    public Map<String,Integer> getAllSupplierMap() {
        Map<String,Integer> map = new HashMap<>();
        String query = "SELECT * from supplier";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                map.put(rs.getString("supplier"),rs.getInt("supplier_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public ArrayList<Supplier> searchSupplierById(int id) {
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        Supplier supplierObj = null;
        String query = "SELECT * from supplier where supplier_id = " + id +";";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                supplierObj = new Supplier();
                supplierObj.setId(rs.getInt("supplier_id"));
                supplierObj.setSupplier(rs.getString("supplier"));
                supplierObj.setContactPerson(rs.getString("contact_person"));
                supplierObj.setCity(rs.getString("city"));
                supplierObj.setContactNumber(rs.getString("contact_number"));
                supplierObj.setLicenseDetail(rs.getString("license_detail"));
                supplierObj.setStatus(rs.getString("status"));
                supplierObj.setStatusDate(rs.getString("status_date"));
                supplierObj.setStatus(rs.getString("status"));
                supplierList.add(supplierObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    public void saveEmployee(Supplier supplier) {
        Supplier supplierObj = supplier;
        String query = "insert into supplier(supplier , contact_person , city , contact_number , license_detail , stauts , status_date) values('"+
                supplierObj.getSupplier() + "','" + supplierObj.getContactPerson() + "','" + supplierObj.getCity() + "','" + supplierObj.getContactNumber()
                + "','" + supplierObj.getLicenseDetail() + "','" + supplierObj.getStatus() + "','" + supplierObj.getStatusDate() +"');";

        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplier(Supplier supplier) {
        Supplier supplierobj = supplier;
        String query = "update supplier SET supplier = '" + supplierobj.getSupplier() +
                "',"+"contact_person = '" +supplierobj.getContactPerson() + "',"+"city = '" +supplierobj.getCity() +
                "',"+"contact_number = '" +supplierobj.getContactNumber() + "',"+"license_detail = '" +supplierobj.getLicenseDetail() +
                "',"+"status = '" +supplierobj.getStatus() + "',"+"status_date = '" +supplierobj.getStatusDate() +
                "' WHERE id = " + supplierobj.getId() + ";";

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
