package view;

import entity.Product;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSaveView {
    private JTextField supplierFeild, nameFeild, categoryFeild, rspFeild, netRspFeild, storageLocationFeild, statusFeils;
    private JFrame saveProductFrame;
    private ProductService productService;
    private ProductView productView;
    private JComboBox addCategoryByComboBox , statusComboBox;
    private String categoryDropDown[] = {"fruits","Soft Drinks","Dairy"} , statusDropDown[] = {"active" , "in-active"};

    public ProductSaveView(ProductView productView) {
        this.productView = productView;
        productService = new ProductService();
    }

    public JFrame getFrame() {
        saveProductFrame = new JFrame("save product");
        saveProductFrame.getContentPane().setBackground(Color.BLACK);
        saveProductFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saveProductFrame.setLocation(dim.width / 2 - saveProductFrame.getSize().width / 2, dim.height / 2 - saveProductFrame.getSize().height / 2);
        saveProductFrame.setResizable(false);
        saveProductFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        saveProductFrame.add(mainPanel);

        JLabel nameLable = new JLabel("name: ");
        nameLable.setForeground(new Color(0X00FF00));
        nameLable.setBackground(Color.BLACK);
        nameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLable.setOpaque(true);
        nameLable.setBounds(20, 40, 50, 25);
        mainPanel.add(nameLable);

        JLabel categoryLable = new JLabel("category: ");
        categoryLable.setForeground(new Color(0X00FF00));
        categoryLable.setBackground(Color.BLACK);
        categoryLable.setFont(new Font("Serif", Font.ITALIC, 18));
        categoryLable.setOpaque(true);
        categoryLable.setBounds(20, 90, 80, 25);
        mainPanel.add(categoryLable);

        JLabel supplierLable = new JLabel("Supplier: ");
        supplierLable.setForeground(new Color(0X00FF00));
        supplierLable.setBackground(Color.BLACK);
        supplierLable.setFont(new Font("Serif", Font.ITALIC, 18));
        supplierLable.setOpaque(true);
        supplierLable.setBounds(20, 140, 80, 25);
        mainPanel.add(supplierLable);

        JLabel rspLable = new JLabel("RSP: ");
        rspLable.setForeground(new Color(0X00FF00));
        rspLable.setBackground(Color.BLACK);
        rspLable.setFont(new Font("Serif", Font.ITALIC, 18));
        rspLable.setOpaque(true);
        rspLable.setBounds(20, 190, 50, 25);
        mainPanel.add(rspLable);

        JLabel netRspLable = new JLabel("Net Rsp: ");
        netRspLable.setForeground(new Color(0X00FF00));
        netRspLable.setBackground(Color.BLACK);
        netRspLable.setFont(new Font("Serif", Font.ITALIC, 18));
        netRspLable.setOpaque(true);
        netRspLable.setBounds(20, 240, 70, 25);
        mainPanel.add(netRspLable);

        JLabel storageLocationLable = new JLabel("Storage Location: ");
        storageLocationLable.setForeground(new Color(0X00FF00));
        storageLocationLable.setBackground(Color.BLACK);
        storageLocationLable.setFont(new Font("Serif", Font.ITALIC, 18));
        storageLocationLable.setOpaque(true);
        storageLocationLable.setBounds(20, 290, 140, 25);
        mainPanel.add(storageLocationLable);

        JLabel statusLable = new JLabel("Status: ");
        statusLable.setForeground(new Color(0X00FF00));
        statusLable.setBackground(Color.BLACK);
        statusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        statusLable.setOpaque(true);
        statusLable.setBounds(20, 340, 60, 25);
        mainPanel.add(statusLable);

        nameFeild = new JTextField();
        nameFeild.setBounds(80, 40, 200, 25);
        mainPanel.add(nameFeild);

        addCategoryByComboBox = new JComboBox(categoryDropDown);
        addCategoryByComboBox.setBackground(Color.GRAY);
        addCategoryByComboBox.setEditable(false);
        addCategoryByComboBox.setBounds(110, 90, 200, 25);
        mainPanel.add(addCategoryByComboBox);

        supplierFeild = new JTextField();
        supplierFeild.setBounds(110, 140, 200, 25);
        mainPanel.add(supplierFeild);

        rspFeild = new JTextField();
        rspFeild.setBounds(80, 190, 200, 25);
        mainPanel.add(rspFeild);

        netRspFeild = new JTextField();
        netRspFeild.setBounds(100, 240, 200, 25);
        mainPanel.add(netRspFeild);

        storageLocationFeild = new JTextField();
        storageLocationFeild.setBounds(170, 290, 150, 25);
        mainPanel.add(storageLocationFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(90, 340, 200, 25);
        mainPanel.add(statusComboBox);

        JButton saveButton = new JButton("save");
        saveButton.setBackground(Color.LIGHT_GRAY);
        saveButton.setBounds(260, 400, 90, 30);
        saveButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(saveButton);
        saveButton.addActionListener(saveOnClickEvent());

        saveProductFrame.setVisible(true);
        return saveProductFrame;
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                String category = (String) addCategoryByComboBox.getSelectedItem();
                String status = (String) statusComboBox.getSelectedItem();
                product.setName(nameFeild.getText());
                product.setCategory(category);
                product.setSupplier(supplierFeild.getText());
                product.setRsp(Double.parseDouble(rspFeild.getText()));
                product.setNetRsp(Double.parseDouble(netRspFeild.getText()));
                product.setStorageLocation(storageLocationFeild.getText());
                product.setStatus(status);
                productService.saveProduct(product);
                saveProductFrame.dispose();
                productView.showAll();
            }
        };
    }
}
