package view;

import entity.Product;
import service.ProductService;
import tableModel.ProductTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ProductView {
    private JFrame jFrame;
    private JTextField searchFeild;
    private ProductService productService;
    private ArrayList<Product> productList;

    public ProductView() {
        this.productService = new ProductService();
        productList = productService.getAllProduct();
    }

    public JFrame getFrame() {
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

        JTable t = new JTable(new ProductTableModel(productList));
        JScrollPane scroll = new JScrollPane(t);
        scroll.setBounds(2, 150, 857, 425); // x, y, width, height

        mainPanel.add(scroll);
        JButton createProductButton = new JButton("Create");
        createProductButton.setBackground(Color.LIGHT_GRAY);
        createProductButton.setBounds(5, 96, 100, 40);
        createProductButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(createProductButton);

        JLabel searchLable = new JLabel("Search Record: ");
        searchLable.setForeground(new Color(0X00FF00));
        searchLable.setBackground(Color.BLACK);
        searchLable.setFont(new Font("Serif", Font.ITALIC, 18));
        searchLable.setOpaque(true);
        searchLable.setBounds(251, 107, 200, 25);
        mainPanel.add(searchLable);

        searchFeild = new JTextField();
        searchFeild.setBounds(376, 105, 270, 30);
        mainPanel.add(searchFeild);

        JButton searchProductButton = new JButton("Search");
        searchProductButton.setBackground(Color.LIGHT_GRAY);
        searchProductButton.setBounds(651, 105, 90, 30);
        searchProductButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(searchProductButton);

        JButton showAllRecordButton = new JButton("Show All");
        showAllRecordButton.setBackground(Color.LIGHT_GRAY);
        showAllRecordButton.setBounds(754, 105, 90, 30);
        showAllRecordButton.setFont(new Font("Serif", Font.ITALIC, 14));
        mainPanel.add(showAllRecordButton);

        return jFrame;
    }
}
