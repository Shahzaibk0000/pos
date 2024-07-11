package view;

import entity.Employee;
import entity.Product;
import service.CategoryService;
import service.EmployeeService;
import service.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class EmployeeSaveView {
    private JTextField nameFeild, fatherNameFeild, designationFeild, cnicFeild , phoneNumberFeild , startDateFeild , endDateFeild , status;
    private JFrame saveEmployeeFrame;
    private EmployeeService employeeService;
    private EmployeeView employeeView;
    private JComboBox statusComboBox;
    private String statusDropDown[] = {"joined", "not joined"};

    public EmployeeSaveView(EmployeeView employeeView) {
        this.employeeView = employeeView;
        employeeService = new EmployeeService();
    }

    public JFrame getFrame() {
        saveEmployeeFrame = new JFrame("save Employee");
        saveEmployeeFrame.getContentPane().setBackground(Color.BLACK);
        saveEmployeeFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saveEmployeeFrame.setLocation(dim.width / 2 - saveEmployeeFrame.getSize().width / 2, dim.height / 2 - saveEmployeeFrame.getSize().height / 2);
        saveEmployeeFrame.setResizable(false);
        saveEmployeeFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        saveEmployeeFrame.add(mainPanel);

        JLabel nameLable = new JLabel("name: ");
        nameLable.setForeground(new Color(0X00FF00));
        nameLable.setBackground(Color.BLACK);
        nameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLable.setOpaque(true);
        nameLable.setBounds(20, 30, 40, 25);
        mainPanel.add(nameLable);

        JLabel fatherNameLable = new JLabel("Father Name: ");
        fatherNameLable.setForeground(new Color(0X00FF00));
        fatherNameLable.setBackground(Color.BLACK);
        fatherNameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        fatherNameLable.setOpaque(true);
        fatherNameLable.setBounds(20, 70, 110, 25);
        mainPanel.add(fatherNameLable);

        JLabel designationLable = new JLabel("Designation: ");
        designationLable.setForeground(new Color(0X00FF00));
        designationLable.setBackground(Color.BLACK);
        designationLable.setFont(new Font("Serif", Font.ITALIC, 18));
        designationLable.setOpaque(true);
        designationLable.setBounds(20, 120, 110, 25);
        mainPanel.add(designationLable);

        JLabel cnicLable = new JLabel("cnic: ");
        cnicLable.setForeground(new Color(0X00FF00));
        cnicLable.setBackground(Color.BLACK);
        cnicLable.setFont(new Font("Serif", Font.ITALIC, 18));
        cnicLable.setOpaque(true);
        cnicLable.setBounds(20, 170, 50, 25);
        mainPanel.add(cnicLable);

        JLabel phoneNumberLable = new JLabel("phone Number: ");
        phoneNumberLable.setForeground(new Color(0X00FF00));
        phoneNumberLable.setBackground(Color.BLACK);
        phoneNumberLable.setFont(new Font("Serif", Font.ITALIC, 18));
        phoneNumberLable.setOpaque(true);
        phoneNumberLable.setBounds(20, 220, 120, 25);
        mainPanel.add(phoneNumberLable);

        JLabel startDateLable = new JLabel("Start Date: ");
        startDateLable.setForeground(new Color(0X00FF00));
        startDateLable.setBackground(Color.BLACK);
        startDateLable.setFont(new Font("Serif", Font.ITALIC, 18));
        startDateLable.setOpaque(true);
        startDateLable.setBounds(20, 270, 90, 25);
        mainPanel.add(startDateLable);

        JLabel endDateLable = new JLabel("end Date: ");
        endDateLable.setForeground(new Color(0X00FF00));
        endDateLable.setBackground(Color.BLACK);
        endDateLable.setFont(new Font("Serif", Font.ITALIC, 18));
        endDateLable.setOpaque(true);
        endDateLable.setBounds(20, 320, 80, 25);
        mainPanel.add(endDateLable);

        JLabel statusLable = new JLabel("Status: ");
        statusLable.setForeground(new Color(0X00FF00));
        statusLable.setBackground(Color.BLACK);
        statusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        statusLable.setOpaque(true);
        statusLable.setBounds(20, 370, 60, 25);
        mainPanel.add(statusLable);

        nameFeild = new JTextField();
        nameFeild.setBounds(70, 30, 200, 25);
        mainPanel.add(nameFeild);

        fatherNameFeild = new JTextField();
        fatherNameFeild.setBounds(140, 70, 200, 25);
        mainPanel.add(fatherNameFeild);

        designationFeild = new JTextField();
        designationFeild.setBounds(140, 120, 150, 25);
        mainPanel.add(designationFeild);

        cnicFeild = new JTextField();
        cnicFeild.setBounds(80, 170, 200, 25);
        mainPanel.add(cnicFeild);

        phoneNumberFeild = new JTextField();
        phoneNumberFeild.setBounds(150, 220, 200, 25);
        mainPanel.add(phoneNumberFeild);

        startDateFeild = new JTextField();
        startDateFeild.setBounds(120, 270, 200, 25);
        mainPanel.add(startDateFeild);

        endDateFeild = new JTextField();
        endDateFeild.setBounds(110, 320, 150, 25);
        mainPanel.add(endDateFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(90, 370, 200, 25);
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

        saveEmployeeFrame.setVisible(true);
        return saveEmployeeFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveEmployeeFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                String status = (String) statusComboBox.getSelectedItem();
                employee.setName(nameFeild.getText());
                employee.setFatherName(fatherNameFeild.getText());
                employee.setDesignation(designationFeild.getText());
                employee.setCnic(cnicFeild.getText());
                employee.setPhoneNumber(phoneNumberFeild.getText());
                employee.setStartDate(startDateFeild.getText());
                employee.setEndDate(endDateFeild.getText());
                employee.setStatus(status);
                employeeService.saveEmployee(employee);
                saveEmployeeFrame.dispose();
                employeeView.showAll();
            }
        };
    }
}
