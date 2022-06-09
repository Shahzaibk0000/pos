package view;

import entity.Inventory;
import service.CategoryService;
import service.InventoryService;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class InventorySaveView {
    private JTextField storageLocationFeild,purchasePriceFeild,quantityFeild;
    private JFrame saveInventoryFrame;
    private InventoryService inventoryService;
    private CategoryService categoryService;
    private ProductService productService;
    private InventoryView inventoryView;
    private JComboBox addCategoryByComboBox, statusComboBox , addProductByComboBox;
    private String statusDropDown[] = {"active", "in-active"};
    private Map<String, Integer> categoryMap;
    private Map<String, Integer> productMap;

    public InventorySaveView(InventoryView inventoryView) {
        this.inventoryView = inventoryView;
        inventoryService = new InventoryService();
        categoryService = new CategoryService();
        categoryMap = categoryService.getAllCategoryMap();
        productService = new ProductService();
        productMap = productService.getAllProductMap();
    }

    public JFrame getFrame() {
        saveInventoryFrame = new JFrame("save product");
        saveInventoryFrame.getContentPane().setBackground(Color.BLACK);
        saveInventoryFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saveInventoryFrame.setLocation(dim.width / 2 - saveInventoryFrame.getSize().width / 2, dim.height / 2 - saveInventoryFrame.getSize().height / 2);
        saveInventoryFrame.setResizable(false);
        saveInventoryFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        saveInventoryFrame.add(mainPanel);


        JLabel categoryLable = new JLabel("Category: ");
        categoryLable.setForeground(new Color(0X00FF00));
        categoryLable.setBackground(Color.BLACK);
        categoryLable.setFont(new Font("Serif", Font.ITALIC, 18));
        categoryLable.setOpaque(true);
        categoryLable.setBounds(20, 40, 80, 25);
        mainPanel.add(categoryLable);

        JLabel productLable = new JLabel("Product: ");
        productLable.setForeground(new Color(0X00FF00));
        productLable.setBackground(Color.BLACK);
        productLable.setFont(new Font("Serif", Font.ITALIC, 18));
        productLable.setOpaque(true);
        productLable.setBounds(20, 80, 80, 25);
        mainPanel.add(productLable);

        JLabel purchasePriceLable = new JLabel("Purchase Price: ");
        purchasePriceLable.setForeground(new Color(0X00FF00));
        purchasePriceLable.setBackground(Color.BLACK);
        purchasePriceLable.setFont(new Font("Serif", Font.ITALIC, 18));
        purchasePriceLable.setOpaque(true);
        purchasePriceLable.setBounds(20, 120, 130, 25);
        mainPanel.add(purchasePriceLable);

        JLabel quantityLable = new JLabel("Quantity: ");
        quantityLable.setForeground(new Color(0X00FF00));
        quantityLable.setBackground(Color.BLACK);
        quantityLable.setFont(new Font("Serif", Font.ITALIC, 18));
        quantityLable.setOpaque(true);
        quantityLable.setBounds(20, 160, 80, 25);
        mainPanel.add(quantityLable);

        JLabel storageLocationLable = new JLabel("Storage Location: ");
        storageLocationLable.setForeground(new Color(0X00FF00));
        storageLocationLable.setBackground(Color.BLACK);
        storageLocationLable.setFont(new Font("Serif", Font.ITALIC, 18));
        storageLocationLable.setOpaque(true);
        storageLocationLable.setBounds(20, 200, 150, 25);
        mainPanel.add(storageLocationLable);

        JLabel StatusLable = new JLabel("Inventory Status: ");
        StatusLable.setForeground(new Color(0X00FF00));
        StatusLable.setBackground(Color.BLACK);
        StatusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        StatusLable.setOpaque(true);
        StatusLable.setBounds(20, 240, 150, 25);
        mainPanel.add(StatusLable);


        addCategoryByComboBox = new JComboBox(categoryMap.keySet().toArray(new String[0]));
        addCategoryByComboBox.setBackground(Color.GRAY);
        addCategoryByComboBox.setEditable(false);
        addCategoryByComboBox.setBounds(110, 40, 200, 25);
        mainPanel.add(addCategoryByComboBox);

        addProductByComboBox = new JComboBox(productMap.keySet().toArray(new String[0]));
        addProductByComboBox.setBackground(Color.GRAY);
        addProductByComboBox.setEditable(false);
        addProductByComboBox.setBounds(110, 80, 200, 25);
        mainPanel.add(addProductByComboBox);

        purchasePriceFeild = new JTextField();
        purchasePriceFeild.setBounds(160, 120, 190, 25);
        mainPanel.add(purchasePriceFeild);

        quantityFeild = new JTextField();
        quantityFeild.setBounds(110, 160, 200, 25);
        mainPanel.add(quantityFeild);

        storageLocationFeild = new JTextField();
        storageLocationFeild.setBounds(180, 200, 150, 25);
        mainPanel.add(storageLocationFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(180, 240, 150, 25);
        mainPanel.add(statusComboBox);

        JButton saveButton = new JButton("save");
        saveButton.setBackground(Color.LIGHT_GRAY);
        saveButton.setBounds(260, 400, 90, 30);
        saveButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(saveButton);
        saveButton.addActionListener(saveOnClickEvent());

        saveInventoryFrame.setVisible(true);
        return saveInventoryFrame;
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
                inventoryService.saveInventory(inventory);
                saveInventoryFrame.dispose();
                inventoryView.showAll();
            }
        };
    }
}
