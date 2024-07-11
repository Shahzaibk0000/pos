package dao;
import entity.Employee;
import util.AppConstant;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {
    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee employeeObj = null;
        String query = "SELECT * from employee";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                employeeObj = new Employee();
                employeeObj.setId(rs.getInt("id"));
                employeeObj.setName(rs.getString("name"));
                employeeObj.setFatherName(rs.getString("fatherName"));
                employeeObj.setDesignation(rs.getString("designation"));
                employeeObj.setCnic(rs.getString("cnic"));
                employeeObj.setPhoneNumber(rs.getString("phone_number"));
                employeeObj.setStartDate(rs.getString("start_date"));
                employeeObj.setEndDate(rs.getString("end_date"));
                employeeObj.setStatus(rs.getString("status"));
                employeeList.add(employeeObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public ArrayList<Employee> searchEmployeeByName(String name) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee employeeObj = null;
        String query = "SELECT * from employee WHERE name like ('%"+name+"%');";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                employeeObj = new Employee();
                employeeObj.setId(rs.getInt("id"));
                employeeObj.setName(rs.getString("name"));
                employeeObj.setFatherName(rs.getString("fatherName"));
                employeeObj.setDesignation(rs.getString("designation"));
                employeeObj.setCnic(rs.getString("cnic"));
                employeeObj.setPhoneNumber(rs.getString("phone_number"));
                employeeObj.setStartDate(rs.getString("start_date"));
                employeeObj.setEndDate(rs.getString("end_date"));
                employeeObj.setStatus(rs.getString("status"));
                employeeList.add(employeeObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public ArrayList<Employee> searchEmployeeById(int id) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee employeeObj = null;
        String query = "SELECT * from employee where id = " + id + ";";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                employeeObj = new Employee();
                employeeObj.setId(rs.getInt("id"));
                employeeObj.setName(rs.getString("name"));
                employeeObj.setFatherName(rs.getString("fatherName"));
                employeeObj.setDesignation(rs.getString("designation"));
                employeeObj.setCnic(rs.getString("cnic"));
                employeeObj.setPhoneNumber(rs.getString("phone_number"));
                employeeObj.setStartDate(rs.getString("start_date"));
                employeeObj.setEndDate(rs.getString("end_date"));
                employeeObj.setStatus(rs.getString("status"));
                employeeList.add(employeeObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void saveEmployee(Employee employee) {
        Employee employeeobj = employee;
        String query = "insert into employee(name , fatherName , designation , cnic , phone_number , start_date , end_date , status) values('"+
                employeeobj.getName() + "','" + employeeobj.getFatherName() + "','" + employeeobj.getDesignation() + "','" + employeeobj.getCnic()
                + "','" + employeeobj.getPhoneNumber() + "','" + employeeobj.getStartDate() + "','" + employeeobj.getEndDate() + "','" + employeeobj.getStatus() +"');";

        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        Employee employeeobj = employee;
        String query = "update employee SET name = '" + employee.getName() +
                "',"+"fatherName = '" +employee.getFatherName() + "',"+"designation = '" +employee.getDesignation() +
                "',"+"cnic = '" +employee.getCnic() + "',"+"phone_number = '" +employee.getPhoneNumber() +
                "',"+"start_date = '" +employee.getStartDate() + "',"+"end_date = '" +employee.getEndDate() +
                "',"+"status = '" +employee.getStatus() +
                "' WHERE id = " + employee.getId() + ";";

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
