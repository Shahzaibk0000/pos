package view;

import service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LoginView {
    private JTextField emailField;
    private JPasswordField passField;
    private LoginService loginService;
    private JLabel loginMesasgeLabel;
    private JFrame loginFrame;

    public LoginView() {
        loginService = new LoginService();
    }

    public JFrame getFrame() {
        loginFrame = new JFrame("Login");
        loginFrame.getContentPane().setBackground(Color.BLACK);
        loginFrame.setSize(700, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        loginFrame.setLocation(dim.width / 2 - loginFrame.getSize().width / 2, dim.height / 2 - loginFrame.getSize().height / 2);
        loginFrame.setResizable(false);
        loginFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 50, 660, 400);
        mainPanel.setBackground(Color.BLACK);

        JLabel companyLable;
        companyLable = new JLabel("'Point of Sales'");
        companyLable.setForeground(new Color(0X00FF00));
        companyLable.setBackground(Color.BLACK);
        companyLable.setFont(new Font("Serif", Font.ITALIC, 28));
        companyLable.setOpaque(true);
        companyLable.setBounds(230, 10, 250, 25);
        mainPanel.add(companyLable);

        JLabel loginLable;
        loginLable = new JLabel("... LOGIN ...");
        loginLable.setForeground(new Color(0X00FF00));
        loginLable.setBackground(Color.BLACK);
        loginLable.setFont(new Font("Serif", Font.PLAIN, 18));
        loginLable.setOpaque(true);
        loginLable.setBounds(260, 130, 100, 25);
        mainPanel.add(loginLable);

        emailField = new JTextField();
        JLabel emailLable = new JLabel("Email: ");
        emailLable.setForeground(new Color(0X00FF00));
        emailLable.setBounds(170, 170, 50, 25);
        emailField.setBounds(220, 170, 200, 25);
        mainPanel.add(emailLable);
        mainPanel.add(emailField);

        passField = new JPasswordField();
        JLabel passLabel = new JLabel("Password: ");
        passLabel.setForeground(new Color(0X00FF00));
        passLabel.setBounds(150, 200, 70, 25);
        passField.setBounds(220, 200, 200, 25);
        mainPanel.add(passLabel);
        mainPanel.add(passField);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(270, 240, 70, 25);
        loginBtn.addActionListener(loginOnClickEvent());
        mainPanel.add(loginBtn);

        loginMesasgeLabel = new JLabel("Invalid Input");
        loginMesasgeLabel.setBounds(270, 270, 80, 25);
        loginMesasgeLabel.setVisible(false);
        mainPanel.add(loginMesasgeLabel);

        loginFrame.add(mainPanel);
        loginFrame.setVisible(true);

        emailField.setText("hasnain");
        passField.setText("123");

        return loginFrame;
    }

    public ActionListener loginOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println();
                String email = emailField.getText();
                String pass = passField.getText();
                if (loginService.auth(email, pass)) {
                    loginFrame.dispatchEvent(new WindowEvent(loginFrame, WindowEvent.WINDOW_CLOSING));
                    MenuView menuView = new MenuView();
                    JFrame menuFrame = menuView.getFrame();
                    menuFrame.setVisible(true);
                } else {
                    loginMesasgeLabel.setVisible(true);
                }
            }
        };
    }
}
