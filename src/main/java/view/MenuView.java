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
        menuFrame = new JFrame("Menu View");
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

        JButton orderButton = new JButton("Sale Order");
        orderButton.setBackground(Color.LIGHT_GRAY);
        orderButton.setBounds(50, 100, 170, 170);
        orderButton.setFont(new Font("Serif", Font.ITALIC, 28));
        orderButton.addActionListener(OnClickEventSaleOrder());
        mainPanel.add(orderButton);

        JButton productsButton = new JButton("Products");
        productsButton.setBackground(Color.LIGHT_GRAY);
        productsButton.setBounds(390, 100, 170, 170);
        productsButton.setFont(new Font("Serif", Font.ITALIC, 32));
        productsButton.addActionListener(OnClickEventProduct());
        mainPanel.add(productsButton);

        JButton productCategoriesButton = new JButton("Categories");
        productCategoriesButton.setBackground(Color.LIGHT_GRAY);
        productCategoriesButton.setBounds(750, 100, 170, 170);
        productCategoriesButton.setFont(new Font("Serif", Font.ITALIC, 28));
        productCategoriesButton.addActionListener(OnClickEventCategory());
        mainPanel.add(productCategoriesButton);

        JButton employeeButton = new JButton("Employee");
        employeeButton.setBackground(Color.LIGHT_GRAY);
        employeeButton.setBounds(50, 400, 170, 170);
        employeeButton.setFont(new Font("Serif", Font.ITALIC, 28));
        employeeButton.addActionListener(OnClickEventEmployee());
        mainPanel.add(employeeButton);

        JButton supplierButton = new JButton("Supplier");
        supplierButton.setBackground(Color.LIGHT_GRAY);
        supplierButton.setBounds(390, 400, 170, 170);
        supplierButton.setFont(new Font("Serif", Font.ITALIC, 28));
        supplierButton.addActionListener(OnClickEventSupplier());
        mainPanel.add(supplierButton);

        JButton inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.LIGHT_GRAY);
        inventoryButton.setBounds(750, 400, 170, 170);
        inventoryButton.setFont(new Font("Serif", Font.ITALIC, 28));
        inventoryButton.addActionListener(OnClickEventInventory());
        mainPanel.add(inventoryButton);

        return menuFrame;
    }

    private ActionListener OnClickEventProduct() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductView productsView = new ProductView();
                JFrame productsFrame = productsView.getFrame();
                productsFrame.setVisible(true);
            }
        };
    }

    private ActionListener OnClickEventCategory() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CategoryView categoryView = new CategoryView();
                JFrame categoryFrame = categoryView.getFrame();
                categoryFrame.setVisible(true);
            }
        };
    }

    private ActionListener OnClickEventInventory() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InventoryView inventoryView = new InventoryView();
                JFrame inventoryFrame = inventoryView.getFrame();
                inventoryFrame.setVisible(true);
            }
        };
    }

    private ActionListener OnClickEventEmployee() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeView employeeView = new EmployeeView();
                JFrame employeeFrame = employeeView.getFrame();
                employeeFrame.setVisible(true);
            }
        };
    }

    private ActionListener OnClickEventSupplier() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SupplierView supplierView = new SupplierView();
                JFrame supplierViewFrame = supplierView.getFrame();
                supplierViewFrame.setVisible(true);
            }
        };
    }

    private ActionListener OnClickEventSaleOrder() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaleView saleView = new SaleView();
                JFrame productsFrame = saleView.getFrame();
                productsFrame.setVisible(true);
            }
        };
    }

}
