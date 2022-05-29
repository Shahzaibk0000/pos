package service;

import dao.LoginDao;
import entity.User;
import util.AppConstant;

public class LoginService {
    private LoginDao loginDao;

    public LoginService() {
        loginDao = new LoginDao();
    }

    public boolean auth(String email, String pass) {
        User user = loginDao.auth(email, pass);
        if (user.getName() != null) {
            System.out.println(user);
            AppConstant.setUser(user);
            return true;
        } else {
            return false;
        }
    }
}
