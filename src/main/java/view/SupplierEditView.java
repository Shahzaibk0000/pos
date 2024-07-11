package view;
import entity.Supplier;
import service.SupplierService;
import util.AppUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupplierEditView {
    private JTextField idFeild , supplierFeild, contactPersonFeild, cityFeild, contactNumberFeild, licenseDetailFeild, statusFeild, statusDateFeild;
    private JFrame editSupplierFrame;
    private SupplierService supplierService;
    private SupplierView supplierView;
    private JComboBox statusComboBox;
    private Supplier supplier;
    private String statusDropDown[] = {"joined", "not joined"};

    public SupplierEditView(Supplier supplier,SupplierView supplierView) {
        this.supplier = supplier;
        supplierService = new SupplierService();
        this.supplierView = supplierView;
    }

    public JFrame getFrame() {
        editSupplierFrame = new JFrame("Edit Supplier");
        editSupplierFrame.getContentPane().setBackground(Color.BLACK);
        editSupplierFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        editSupplierFrame.setLocation(dim.width / 2 - editSupplierFrame.getSize().width / 2, dim.height / 2 - editSupplierFrame.getSize().height / 2);
        editSupplierFrame.setResizable(false);
        editSupplierFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        editSupplierFrame.add(mainPanel);

        JLabel idLable = new JLabel("ID");
        idLable.setForeground(new Color(0X00FF00));
        idLable.setBackground(Color.BLACK);
        idLable.setFont(new Font("Serif", Font.ITALIC, 18));
        idLable.setOpaque(true);
        idLable.setBounds(20, 20, 40, 25);
        mainPanel.add(idLable);


        JLabel supplierLable = new JLabel("Supplier: ");
        supplierLable.setForeground(new Color(0X00FF00));
        supplierLable.setBackground(Color.BLACK);
        supplierLable.setFont(new Font("Serif", Font.ITALIC, 18));
        supplierLable.setOpaque(true);
        supplierLable.setBounds(20, 60, 80, 25);
        mainPanel.add(supplierLable);

        JLabel contactPersonLable = new JLabel("Contact Person: ");
        contactPersonLable.setForeground(new Color(0X00FF00));
        contactPersonLable.setBackground(Color.BLACK);
        contactPersonLable.setFont(new Font("Serif", Font.ITALIC, 18));
        contactPersonLable.setOpaque(true);
        contactPersonLable.setBounds(20, 100, 130, 25);
        mainPanel.add(contactPersonLable);

        JLabel cityLable = new JLabel("City: ");
        cityLable.setForeground(new Color(0X00FF00));
        cityLable.setBackground(Color.BLACK);
        cityLable.setFont(new Font("Serif", Font.ITALIC, 18));
        cityLable.setOpaque(true);
        cityLable.setBounds(20, 140, 50, 25);
        mainPanel.add(cityLable);

        JLabel contactNumberLable = new JLabel("Contact Number: ");
        contactNumberLable.setForeground(new Color(0X00FF00));
        contactNumberLable.setBackground(Color.BLACK);
        contactNumberLable.setFont(new Font("Serif", Font.ITALIC, 18));
        contactNumberLable.setOpaque(true);
        contactNumberLable.setBounds(20, 180, 140, 25);
        mainPanel.add(contactNumberLable);

        JLabel licenseDetailLable = new JLabel("License Detail: ");
        licenseDetailLable.setForeground(new Color(0X00FF00));
        licenseDetailLable.setBackground(Color.BLACK);
        licenseDetailLable.setFont(new Font("Serif", Font.ITALIC, 18));
        licenseDetailLable.setOpaque(true);
        licenseDetailLable.setBounds(20, 220, 120, 25);
        mainPanel.add(licenseDetailLable);

        JLabel statusLable = new JLabel("Status: ");
        statusLable.setForeground(new Color(0X00FF00));
        statusLable.setBackground(Color.BLACK);
        statusLable.setFont(new Font("Serif", Font.ITALIC, 18));
        statusLable.setOpaque(true);
        statusLable.setBounds(20, 260, 60, 25);
        mainPanel.add(statusLable);

        JLabel statusDateLable = new JLabel("Status Date: ");
        statusDateLable.setForeground(new Color(0X00FF00));
        statusDateLable.setBackground(Color.BLACK);
        statusDateLable.setFont(new Font("Serif", Font.ITALIC, 18));
        statusDateLable.setOpaque(true);
        statusDateLable.setBounds(20, 300, 100, 25);
        mainPanel.add(statusDateLable);

        idFeild = new JTextField(String.valueOf(supplier.getId()));
        idFeild.setBounds(70, 20, 200, 25);
        idFeild.setEditable(false);
        mainPanel.add(idFeild);

        supplierFeild = new JTextField(supplier.getSupplier());
        supplierFeild.setBounds(110, 60, 200, 25);
        mainPanel.add(supplierFeild);

        contactPersonFeild = new JTextField(supplier.getContactPerson());
        contactPersonFeild.setBounds(160, 100, 200, 25);
        mainPanel.add(contactPersonFeild);

        cityFeild = new JTextField(supplier.getCity());
        cityFeild.setBounds(80, 140, 150, 25);
        mainPanel.add(cityFeild);

        contactNumberFeild = new JTextField(supplier.getContactNumber());
        contactNumberFeild.setBounds(170, 180, 150, 25);
        mainPanel.add(contactNumberFeild);

        licenseDetailFeild = new JTextField(supplier.getLicenseDetail());
        licenseDetailFeild.setBounds(150, 220, 200, 25);
        mainPanel.add(licenseDetailFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setSelectedIndex(AppUtility.getIndex(statusDropDown,supplier.getStatus()));
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(90, 260, 200, 25);
        mainPanel.add(statusComboBox);

        statusDateFeild = new JTextField(supplier.getStatusDate());
        statusDateFeild.setBounds(130, 300, 150, 25);
        statusDateFeild.setEditable(false);
        mainPanel.add(statusDateFeild);


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

        editSupplierFrame.setVisible(true);
        return editSupplierFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editSupplierFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Supplier supplier = new Supplier();
                String status = (String) statusComboBox.getSelectedItem();
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formatDateTime = now.format(format);
                supplier.setId(Integer.parseInt(idFeild.getText()));
                supplier.setSupplier(supplierFeild.getText());
                supplier.setContactPerson(contactPersonFeild.getText());
                supplier.setCity(cityFeild.getText());
                supplier.setContactNumber(contactNumberFeild.getText());
                supplier.setLicenseDetail(licenseDetailFeild.getText());
                supplier.setStatus(status);
                supplier.setStatusDate(formatDateTime);
                supplierService.updateSupplier(supplier);
                editSupplierFrame.dispose();
                supplierView.showAll();
            }
        };
    }
}
