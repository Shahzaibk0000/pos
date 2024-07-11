package view;
import entity.Inventory;
import service.CategoryService;
import service.InventoryService;
import service.ProductService;
import util.AppUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class InventoryEditView {
    private JTextField storageLocationFeild,purchasePriceFeild,quantityFeild , idFeild , countFeild;
    private JFrame editInventoryFrame;
    private InventoryService inventoryService;
    private CategoryService categoryService;
    private ProductService productService;
    private InventoryView inventoryView;
    private JComboBox addCategoryByComboBox, statusComboBox , addProductByComboBox;
    private String statusDropDown[] = {"active", "in-active"};
    private Map<String, Integer> categoryMap;
    private Map<String, Integer> productMap;
    private Inventory inventory;

    public InventoryEditView(Inventory inventory,InventoryView inventoryView) {
        this.inventory = inventory;
        this.inventoryView = inventoryView;
        inventoryService = new InventoryService();
        categoryService = new CategoryService();
        categoryMap = categoryService.getAllCategoryMap();
        productService = new ProductService();
        productMap = productService.getAllProductMap();
    }

    public JFrame getFrame() {
        editInventoryFrame = new JFrame("Edit Inventory");
        editInventoryFrame.getContentPane().setBackground(Color.BLACK);
        editInventoryFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        editInventoryFrame.setLocation(dim.width / 2 - editInventoryFrame.getSize().width / 2, dim.height / 2 - editInventoryFrame.getSize().height / 2);
        editInventoryFrame.setResizable(false);
        editInventoryFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        editInventoryFrame.add(mainPanel);


        JLabel idLable = new JLabel("ID: ");
        idLable.setForeground(new Color(0X00FF00));
        idLable.setBackground(Color.BLACK);
        idLable.setFont(new Font("Serif", Font.ITALIC, 18));
        idLable.setOpaque(true);
        idLable.setBounds(20, 20, 40, 25);
        mainPanel.add(idLable);

        JLabel categoryLable = new JLabel("Category: ");
        categoryLable.setForeground(new Color(0X00FF00));
        categoryLable.setBackground(Color.BLACK);
        categoryLable.setFont(new Font("Serif", Font.ITALIC, 18));
        categoryLable.setOpaque(true);
        categoryLable.setBounds(20, 60, 80, 25);
        mainPanel.add(categoryLable);

        JLabel productLable = new JLabel("Product: ");
        productLable.setForeground(new Color(0X00FF00));
        productLable.setBackground(Color.BLACK);
        productLable.setFont(new Font("Serif", Font.ITALIC, 18));
        productLable.setOpaque(true);
        productLable.setBounds(20, 100, 80, 25);
        mainPanel.add(productLable);

        JLabel purchasePriceLable = new JLabel("Purchase Price: ");
        purchasePriceLable.setForeground(new Color(0X00FF00));
        purchasePriceLable.setBackground(Color.BLACK);
        purchasePriceLable.setFont(new Font("Serif", Font.ITALIC, 18));
        purchasePriceLable.setOpaque(true);
        purchasePriceLable.setBounds(20, 140, 130, 25);
        mainPanel.add(purchasePriceLable);

        JLabel quantityLable = new JLabel("Quantity: ");
        quantityLable.setForeground(new Color(0X00FF00));
        quantityLable.setBackground(Color.BLACK);
        quantityLable.setFont(new Font("Serif", Font.ITALIC, 18));
        quantityLable.setOpaque(true);
        quantityLable.setBounds(20, 180, 80, 25);
        mainPanel.add(quantityLable);

        JLabel storageLocationLable = new JLabel("Storage Location: ");
        storageLocationLable.setForeground(new Color(0X00FF00));
        storageLocationLable.setBackground(Color.BLACK);
        storageLocationLable.setFont(new Font("Serif", Font.ITALIC, 18));
        storageLocationLable.setOpaque(true);
        storageLocationLable.setBounds(20, 220, 150, 25);
        mainPanel.add(storageLocationLable);

        JLabel StatusLable = new JLabel("Inventory Status: ");
        StatusLable.setForeground(new Color(0X00FF00));
        StatusLable.setBackground(Color.BLACK);
        StatusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        StatusLable.setOpaque(true);
        StatusLable.setBounds(20, 260, 150, 25);
        mainPanel.add(StatusLable);

        JLabel countLable = new JLabel("Count: ");
        countLable.setForeground(new Color(0X00FF00));
        countLable.setBackground(Color.BLACK);
        countLable.setFont(new Font("Serif", Font.ITALIC, 18));
        countLable.setOpaque(true);
        countLable.setBounds(20, 300, 60, 25);
        mainPanel.add(countLable);


        idFeild = new JTextField(String.valueOf(inventory.getInventoryId()));
        idFeild.setBounds(70, 20, 200, 25);
        idFeild.setEditable(false);
        mainPanel.add(idFeild);

        String[] categoryValues = categoryMap.keySet().toArray(new String[0]);
        addCategoryByComboBox = new JComboBox(categoryValues);
        String selectedCategory = AppUtility.getKeyFromValue(categoryMap, inventory.getCategoryId());
        addCategoryByComboBox.setSelectedIndex(AppUtility.getIndex(categoryValues, selectedCategory));
        addCategoryByComboBox.setBackground(Color.GRAY);
        addCategoryByComboBox.setEditable(false);
        addCategoryByComboBox.setBounds(110, 60, 200, 25);
        mainPanel.add(addCategoryByComboBox);

        String[] productValues = productMap.keySet().toArray(new String[0]);
        addProductByComboBox = new JComboBox(productValues);
        String selectedProduct = AppUtility.getKeyFromValue(productMap, inventory.getProductId());
        addCategoryByComboBox.setSelectedIndex(AppUtility.getIndex(productValues, selectedProduct));
        addProductByComboBox.setBackground(Color.GRAY);
        addProductByComboBox.setEditable(false);
        addProductByComboBox.setBounds(110, 100, 200, 25);
        mainPanel.add(addProductByComboBox);

        purchasePriceFeild = new JTextField(String.valueOf(inventory.getPurchasePrice()));
        purchasePriceFeild.setBounds(160, 140, 190, 25);
        mainPanel.add(purchasePriceFeild);

        quantityFeild = new JTextField(String.valueOf(inventory.getQuantity()));
        quantityFeild.setBounds(110, 180, 200, 25);
        mainPanel.add(quantityFeild);

        storageLocationFeild = new JTextField(inventory.getStorageLocation());
        storageLocationFeild.setBounds(180, 220, 150, 25);
        mainPanel.add(storageLocationFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setSelectedIndex(AppUtility.getIndex(statusDropDown,inventory.getInventoryStatus()));
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(180, 260, 150, 25);
        mainPanel.add(statusComboBox);

        countFeild = new JTextField(String.valueOf(inventory.getCount()));
        countFeild.setBounds(90, 300, 150, 25);
        mainPanel.add(countFeild);

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

        editInventoryFrame.setVisible(true);
        return editInventoryFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editInventoryFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inventory inventory = new Inventory();
                Integer categoryId = categoryMap.get(addCategoryByComboBox.getSelectedItem());
                Integer productId = productMap.get(addProductByComboBox.getSelectedItem());
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formatDateTime = now.format(format);
                String status = (String) statusComboBox.getSelectedItem();
                inventory.setInventoryId(Integer.parseInt(idFeild.getText()));
                inventory.setCategoryId(categoryId);
                inventory.setProductId(productId);
                inventory.setCategoryName(addCategoryByComboBox.getSelectedItem().toString());
                inventory.setProductName(addProductByComboBox.getSelectedItem().toString());
                inventory.setPurchasePrice(Double.parseDouble(purchasePriceFeild.getText()));
                inventory.setQuantity(Integer.parseInt(quantityFeild.getText()));
                inventory.setTotalPrice(inventory.getPurchasePrice()*inventory.getQuantity());
                inventory.setStorageLocation(storageLocationFeild.getText());
                inventory.setInventoryStatus(status);
                inventory.setDate(formatDateTime);
                inventory.setCount(Integer.parseInt(countFeild.getText()));
                inventoryService.updateInventory(inventory);
                editInventoryFrame.dispose();
                inventoryView.showAll();
            }
        };
    }
}
