package view;

import entity.Employee;
import entity.Supplier;
import service.EmployeeService;
import service.SupplierService;
import tableModel.EmployeeTableModel;
import tableModel.SupplierTableModel;
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

public class SupplierView {
    private JFrame jFrame;
    private JTextField searchFeild;
    private SupplierService supplierService;
    private ArrayList<Supplier> suppliersList;
    private JTable table;
    private JComboBox searchByComboBox;
    private String searchDropDown[] = {"Id", "Name"};
    private EmployeeSaveView employeeSaveView;
    private EmployeeEditView employeeEditView;

    public SupplierView() {
        this.supplierService = new SupplierService();
        suppliersList = supplierService.getAllSupplier();
        //employeeSaveView = new EmployeeSaveView(this);
    }

    public JFrame getFrame() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        jFrame = new JFrame("Employee");
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

        table = new JTable(new SupplierTableModel(suppliersList));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(2, 150, 857, 425); // x, y, width, height
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getColumnCount();
                    System.out.println(suppliersList.get(row).toString());
                    //employeeEditView = new EmployeeEditView(suppliersList.get(row));
                    //JFrame editProductFrame = employeeEditView.getFrame();
                }
            }
        });

        mainPanel.add(scroll);
        JButton createEmployeeButton = new JButton("Create");
        createEmployeeButton.setBackground(Color.LIGHT_GRAY);
        createEmployeeButton.setBounds(5, 96, 100, 40);
        createEmployeeButton.setFont(new Font("Serif", Font.ITALIC, 16));
        createEmployeeButton.addActionListener(createOnClickEvent());
        mainPanel.add(createEmployeeButton);

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

        JButton searchEmployeeButton = new JButton("Search");
        searchEmployeeButton.setBackground(Color.LIGHT_GRAY);
        searchEmployeeButton.setBounds(651, 105, 90, 30);
        searchEmployeeButton.setFont(new Font("Serif", Font.ITALIC, 16));
        mainPanel.add(searchEmployeeButton);
        searchEmployeeButton.addActionListener(searchOnClickEvent());

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
                    suppliersList = supplierService.searchSupplierById(id);
                    table.setModel(new SupplierTableModel(suppliersList));
                    table.notifyAll();
                } else if (dropDown.equals("Name")) {
                    String name = searchFeild.getText().toString();
                    suppliersList = supplierService.searchSupplierByName(name);
                    table.setModel(new SupplierTableModel(suppliersList));
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
        suppliersList = supplierService.getAllSupplier();
        table.setModel(new SupplierTableModel(suppliersList));
        table.notifyAll();
    }

    private ActionListener createOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = employeeSaveView.getFrame();
                jFrame.setVisible(true);
            }
        };
    }
}
