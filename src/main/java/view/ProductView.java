package view;

import entity.Product;
import service.ProductService;
import tableModel.ProductTableModel;
import util.AppConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProductView {
    private JFrame jFrame;
    private JTextField searchFeild;
    private ProductService productService;
    private ArrayList<Product> productList;
    private JTable table;
    private JComboBox searchByComboBox;
    private String searchDropDown[] = {"Id", "Name"};
    private ProductSaveView productSaveView;

    public ProductView() {
        this.productService = new ProductService();
        productList = productService.getAllProduct();
        productSaveView = new ProductSaveView(this);
    }

    public JFrame getFrame() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        jFrame = new JFrame("Products");
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setSize(900, 650);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2, dim.height / 2 - jFrame.getSize().height / 2);
        jFrame.setResizable(false);
        jFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 860, 585);
        mainPanel.setBackground(Color.BLACK);
        jFrame.add(mainPanel);

        JLabel dateTimeLable = new JLabel(formatDateTime.toString());
        dateTimeLable.setForeground(new Color(0X00FF00));
        dateTimeLable.setBackground(Color.BLACK);
        dateTimeLable.setFont(new Font("Serif", Font.ITALIC, 16));
        dateTimeLable.setOpaque(true);
        dateTimeLable.setBounds(2, 0, 230, 50);
        mainPanel.add(dateTimeLable);

        JLabel companyNameLable = new JLabel(AppConstant.COMPANY_NAME);
        companyNameLable.setForeground(new Color(0X00FF00));
        companyNameLable.setBackground(Color.BLACK);
        companyNameLable.setFont(new Font("Serif", Font.ITALIC, 32));
        companyNameLable.setOpaque(true);
        companyNameLable.setBounds(320, 20, 230, 50);
        mainPanel.add(companyNameLable);

        table = new JTable(new ProductTableModel(productList));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(2, 150, 857, 425); // x, y, width, height

        mainPanel.add(scroll);
        JButton createProductButton = new JButton("Create");
        createProductButton.setBackground(Color.LIGHT_GRAY);
        createProductButton.setBounds(5, 96, 100, 40);
        createProductButton.setFont(new Font("Serif", Font.ITALIC, 16));
        createProductButton.addActionListener(createOnClickEvent());
        mainPanel.add(createProductButton);

        JLabel searchLable = new JLabel("Search Record by ");
        searchLable.setForeground(new Color(0X00FF00));
        searchLable.setBackground(Color.BLACK);
        searchLable.setFont(new Font("Serif", Font.ITALIC, 18));
        searchLable.setOpaque(true);
        searchLable.setBounds(205, 107, 120, 25);
        mainPanel.add(searchLable);

        searchByComboBox = new JComboBox(searchDropDown);
        searchByComboBox.setBackground(Color.GRAY);
        searchByComboBox.setEditable(true);
        searchByComboBox.setBounds(330, 107, 70, 25);
        mainPanel.add(searchByComboBox);

        searchFeild = new JTextField();
        searchFeild.setBounds(410, 105, 230, 30);
        mainPanel.add(searchFeild);

        JButton searchProductButton = new JButton("Search");
        searchProductButton.setBackground(Color.LIGHT_GRAY);
        searchProductButton.setBounds(651, 105, 90, 30);
        searchProductButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(searchProductButton);
        searchProductButton.addActionListener(searchOnClickEvent());

        JButton showAllRecordButton = new JButton("Show All");
        showAllRecordButton.setBackground(Color.LIGHT_GRAY);
        showAllRecordButton.setBounds(754, 105, 90, 30);
        showAllRecordButton.setFont(new Font("Serif", Font.ITALIC, 14));
        showAllRecordButton.addActionListener(ShowAllOnClickEvent());
        mainPanel.add(showAllRecordButton);

        return jFrame;
    }

    private ActionListener searchOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dropDown = (String) searchByComboBox.getSelectedItem();
                if (dropDown.equals("Id")) {
                    int id = Integer.parseInt(searchFeild.getText());
                    productList = productService.searchProductById(id);
                    table.setModel(new ProductTableModel(productList));
                    table.notifyAll();
                } else if (dropDown.equals("Name")) {
                    String name = searchFeild.getText().toString();
                    productList = productService.searchProductByName(name);
                    table.setModel(new ProductTableModel(productList));
                    table.notifyAll();
                } else {
                    String name = searchFeild.getText().toString();
                    productList = productService.searchProductByName(name);
                    table.setModel(new ProductTableModel(productList));
                    table.notifyAll();
                }
            }
        };
    }


    private ActionListener ShowAllOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAll();
            }
        };
    }

    public void showAll(){
        productList = productService.getAllProduct();
        table.setModel(new ProductTableModel(productList));
        table.notifyAll();
    }

    private ActionListener createOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = productSaveView.getFrame();
                jFrame.setVisible(true);
            }
        };
    }

}
