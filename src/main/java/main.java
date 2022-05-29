import view.LoginView;
import view.MenuView;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        JFrame jFrame = login.getFrame();
        jFrame.setVisible(true);
        /*MenuView menuView = new MenuView();
        JFrame jFrame1 = menuView.getFrame();
        jFrame1.setVisible(true);*/
    }
}