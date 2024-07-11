package view;

import entity.Inventory;
import service.InventoryService;
import tableModel.InventoryTableModel;
import util.AppConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InventoryView {
    private JFrame jFrame;
    private JTextField searchFeild;
    private InventoryService inventoryService;
    private ArrayList<Inventory> inventoryList;
    private JTable table;
    private JComboBox searchByComboBox;
    private String searchDropDown[] = {"Id"};
    private InventorySaveView inventorySaveView;
    private InventoryEditView inventoryEditView;

    public InventoryView() {
        this.inventoryService = new InventoryService();
        inventoryList = inventoryService.getAllInventory();
        inventorySaveView = new InventorySaveView(this);
    }

    public JFrame getFrame() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        jFrame = new JFrame("Inventory");
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

        table = new JTable(new InventoryTableModel(inventoryList));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(2, 150, 857, 425); // x, y, width, height
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getColumnCount();
                    System.out.println(inventoryList.get(row).toString());
                    inventoryEditView = new InventoryEditView(inventoryList.get(row),InventoryView.this);
                    JFrame editInventoryFrame = inventoryEditView.getFrame();
                }
            }
        });

        mainPanel.add(scroll);
        JButton createInventoryButton = new JButton("Create");
        createInventoryButton.setBackground(Color.LIGHT_GRAY);
        createInventoryButton.setBounds(5, 96, 100, 40);
        createInventoryButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(createInventoryButton);
        createInventoryButton.addActionListener(createOnClickEvent());

        JLabel searchLable = new JLabel("Search Record by ");
        searchLable.setForeground(new Color(0X00FF00));
        searchLable.setBackground(Color.BLACK);
        searchLable.setFont(new Font("Serif", Font.ITALIC, 18));
        searchLable.setOpaque(true);
        searchLable.setBounds(190, 107, 135, 25);
        mainPanel.add(searchLable);

        searchByComboBox = new JComboBox(searchDropDown);
        searchByComboBox.setBackground(Color.GRAY);
        searchByComboBox.setEditable(false);
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
                    int id = Integer.parseInt(searchFeild.getText());
                    inventoryList = inventoryService.searchInventoryById(id);
                    table.setModel(new InventoryTableModel(inventoryList));
                    table.notifyAll();
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
        inventoryList = inventoryService.getAllInventory();
        table.setModel(new InventoryTableModel(inventoryList));
        table.notifyAll();
    }

    private ActionListener createOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = inventorySaveView.getFrame();
                jFrame.setVisible(true);
            }
        };
    }

}
