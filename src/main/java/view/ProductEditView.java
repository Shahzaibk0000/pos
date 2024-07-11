package view;

import entity.Product;
import service.CategoryService;
import service.ProductService;
import service.SupplierService;
import util.AppUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProductEditView {
    private JFrame editProductFrame;
    private ProductService productService;
    private SupplierService supplierService;
    private CategoryService categoryService;
    private ProductView productView;
    private Product product;
    private String searchDropDown[] = {"Id", "Name"};
    private JTextField nameFeild, rspFeild, netRspFeild, storageLocationFeild, idFeild;
    private JComboBox addCategoryByComboBox, statusComboBox, addSupplierByComboBox;
    private String statusDropDown[] = {"active", "in-active"};
    private Map<String, Integer> categoryMap;
    private Map<String, Integer> supplierMap;

    public ProductEditView(Product product, ProductView productView) {
        this.product = product;
        productService = new ProductService();
        categoryService = new CategoryService();
        supplierService = new SupplierService();
        categoryMap = categoryService.getAllCategoryMap();
        supplierMap = supplierService.getAllSupplierMap();
        this.productView = productView;
    }

    public JFrame getFrame() {
        editProductFrame = new JFrame("Edit product");
        editProductFrame.getContentPane().setBackground(Color.BLACK);
        editProductFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        editProductFrame.setLocation(dim.width / 2 - editProductFrame.getSize().width / 2, dim.height / 2 - editProductFrame.getSize().height / 2);
        editProductFrame.setResizable(false);
        editProductFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        editProductFrame.add(mainPanel);

        JLabel idLable = new JLabel("ID: ");
        idLable.setForeground(new Color(0X00FF00));
        idLable.setBackground(Color.BLACK);
        idLable.setFont(new Font("Serif", Font.ITALIC, 18));
        idLable.setOpaque(true);
        idLable.setBounds(20, 40, 50, 25);
        mainPanel.add(idLable);

        JLabel nameLable = new JLabel("name: ");
        nameLable.setForeground(new Color(0X00FF00));
        nameLable.setBackground(Color.BLACK);
        nameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLable.setOpaque(true);
        nameLable.setBounds(20, 80, 50, 25);
        mainPanel.add(nameLable);

        JLabel categoryLable = new JLabel("category: ");
        categoryLable.setForeground(new Color(0X00FF00));
        categoryLable.setBackground(Color.BLACK);
        categoryLable.setFont(new Font("Serif", Font.ITALIC, 18));
        categoryLable.setOpaque(true);
        categoryLable.setBounds(20, 120, 80, 25);
        mainPanel.add(categoryLable);

        JLabel supplierLable = new JLabel("Supplier: ");
        supplierLable.setForeground(new Color(0X00FF00));
        supplierLable.setBackground(Color.BLACK);
        supplierLable.setFont(new Font("Serif", Font.ITALIC, 18));
        supplierLable.setOpaque(true);
        supplierLable.setBounds(20, 160, 80, 25);
        mainPanel.add(supplierLable);

        JLabel rspLable = new JLabel("RSP: ");
        rspLable.setForeground(new Color(0X00FF00));
        rspLable.setBackground(Color.BLACK);
        rspLable.setFont(new Font("Serif", Font.ITALIC, 18));
        rspLable.setOpaque(true);
        rspLable.setBounds(20, 200, 50, 25);
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
        storageLocationLable.setBounds(20, 280, 140, 25);
        mainPanel.add(storageLocationLable);

        JLabel statusLable = new JLabel("Status: ");
        statusLable.setForeground(new Color(0X00FF00));
        statusLable.setBackground(Color.BLACK);
        statusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        statusLable.setOpaque(true);
        statusLable.setBounds(20, 320, 60, 25);
        mainPanel.add(statusLable);

        idFeild = new JTextField(String.valueOf(product.getId()));
        idFeild.setBounds(80, 40, 200, 25);
        idFeild.setEditable(false);
        mainPanel.add(idFeild);

        nameFeild = new JTextField(product.getName());
        nameFeild.setBounds(80, 80, 200, 25);
        mainPanel.add(nameFeild);

        String[] categoryValues = categoryMap.keySet().toArray(new String[0]);
        addCategoryByComboBox = new JComboBox(categoryValues);
        String selectedCategory = AppUtility.getKeyFromValue(categoryMap, product.getCategoryId());
        addCategoryByComboBox.setSelectedIndex(AppUtility.getIndex(categoryValues, selectedCategory));
        addCategoryByComboBox.setBackground(Color.GRAY);
        addCategoryByComboBox.setEditable(false);
        addCategoryByComboBox.setBounds(110, 120, 200, 25);
        mainPanel.add(addCategoryByComboBox);

        String[] supplierValues = supplierMap.keySet().toArray(new String[0]);
        addSupplierByComboBox = new JComboBox(supplierValues);
        String selectedSupplier = AppUtility.getKeyFromValue(supplierMap,product.getSupplierId());
        addSupplierByComboBox.setSelectedIndex(AppUtility.getIndex(supplierValues,selectedSupplier));
        addSupplierByComboBox.setBackground(Color.GRAY);
        addSupplierByComboBox.setEditable(false);
        addSupplierByComboBox.setBounds(110, 160, 200, 25);
        mainPanel.add(addSupplierByComboBox);

        rspFeild = new JTextField(String.valueOf(product.getRsp()));
        rspFeild.setBounds(80, 200, 200, 25);
        mainPanel.add(rspFeild);

        netRspFeild = new JTextField(String.valueOf(product.getNetRsp()));
        netRspFeild.setBounds(100, 240, 200, 25);
        mainPanel.add(netRspFeild);

        storageLocationFeild = new JTextField(product.getStorageLocation());
        storageLocationFeild.setBounds(170, 280, 150, 25);
        mainPanel.add(storageLocationFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setSelectedIndex(AppUtility.getIndex(statusDropDown,product.getStatus()));
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(90, 320, 200, 25);
        mainPanel.add(statusComboBox);

        JButton saveButton = new JButton("save");
        saveButton.setBackground(Color.LIGHT_GRAY);
        saveButton.setBounds(260, 400, 90, 30);
        saveButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(saveButton);
        saveButton.addActionListener(saveOnClickEvent());

        JButton cancelButton = new JButton("cancel");
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setBounds(20, 400, 90, 30);
        cancelButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(cancelButton);
        cancelButton.addActionListener(cancelOnClickEvent());

        editProductFrame.setVisible(true);
        return editProductFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editProductFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                Integer categoryId = categoryMap.get(addCategoryByComboBox.getSelectedItem());
                Integer supplierId = supplierMap.get(addSupplierByComboBox.getSelectedItem());
                String status = (String) statusComboBox.getSelectedItem();
                product.setId(Integer.parseInt(idFeild.getText()));
                product.setName(nameFeild.getText());
                product.setCategoryId(categoryId);
                product.setSupplierId(supplierId);
                product.setCategory(addCategoryByComboBox.getSelectedItem().toString());
                product.setSupplier(addSupplierByComboBox.getSelectedItem().toString());
                product.setRsp(Double.parseDouble(rspFeild.getText()));
                product.setNetRsp(Double.parseDouble(netRspFeild.getText()));
                product.setStorageLocation(storageLocationFeild.getText());
                product.setStatus(status);
                productService.updateProduct(product);
                editProductFrame.dispose();
                productView.showAll();
            }
        };
    }
}
