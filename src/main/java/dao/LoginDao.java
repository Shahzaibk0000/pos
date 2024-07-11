package dao;

import entity.User;
import util.AppConstant;

import java.sql.*;

public class LoginDao {

    public User auth(String name, String pass) {
        User user = new User();
        String query = "SELECT * from user where name='"+name+"' and password = '"+pass+"'";
        try (
                Connection conn = DriverManager.getConnection(AppConstant.DB_URL, AppConstant.USER, AppConstant.PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
