package util;

import entity.User;

public class AppConstant {
    public static final String COMPANY_NAME = "{ Point of Sale }";
    public static final String DB_URL = "jdbc:mysql://localhost/pos";
    public static final String USER = "root";
    public static final String PASS = "Shahzaib0000";
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AppConstant.user = user;
    }
}
