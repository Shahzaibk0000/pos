package view;

import util.AppConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView {

    private JFrame menuFrame;
    private JLabel companyNameLable;

    public JFrame getFrame() {
        menuFrame = new JFrame("MenuView");
        menuFrame.getContentPane().setBackground(Color.BLACK);
        menuFrame.setSize(1000, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        menuFrame.setLocation(dim.width / 2 - menuFrame.getSize().width / 2, dim.height / 2 - menuFrame.getSize().height / 2);
        menuFrame.setResizable(false);
        menuFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 960, 640);
        mainPanel.setBackground(Color.BLACK);
        menuFrame.add(mainPanel);

        companyNameLable = new JLabel(AppConstant.COMPANY_NAME);
        companyNameLable.setForeground(new Color(0X00FF00));
        companyNameLable.setBackground(Color.BLACK);
        companyNameLable.setFont(new Font("Serif", Font.ITALIC, 32));
        companyNameLable.setOpaque(true);
        companyNameLable.setBounds(380, 0, 230, 35);
        mainPanel.add(companyNameLable);

        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.LIGHT_GRAY);
        inventoryButton.setBounds(50, 100, 170, 170);
        inventoryButton.setFont(new Font("Serif", Font.ITALIC, 28));
        mainPanel.add(inventoryButton);

        JButton productsButton = new JButton("Products");
        productsButton.setBackground(Color.LIGHT_GRAY);
        productsButton.setBounds(390, 100, 170, 170);
        productsButton.setFont(new Font("Serif", Font.ITALIC, 32));
        productsButton.addActionListener(loginOnClickEventProduct());
        mainPanel.add(productsButton);

        JButton productCategoriesButton = new JButton("Categories");
        productCategoriesButton.setBackground(Color.LIGHT_GRAY);
        productCategoriesButton.setBounds(750, 100, 170, 170);
        productCategoriesButton.setFont(new Font("Serif", Font.ITALIC, 28));
        mainPanel.add(productCategoriesButton);

        return menuFrame;
    }

    private ActionListener loginOnClickEventProduct() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductView productsView = new ProductView();
                JFrame productsFrame = productsView.getFrame();
                productsFrame.setVisible(true);
            }
        };
    }

}
