package view;
import entity.Supplier;
import service.SupplierService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupplierSaveView {
    private JTextField supplierFeild, contactPersonFeild, cityFeild, contactNumberFeild, licenseDetailFeild, statusFeild, statusDateFeild;
    private JFrame saveSupplierFrame;
    private SupplierService supplierService;
    private SupplierView supplierView;
    private JComboBox statusComboBox;
    private String statusDropDown[] = {"joined", "not joined"};

    public SupplierSaveView(SupplierView supplierView) {
        this.supplierView = supplierView;
        supplierService = new SupplierService();
    }

    public JFrame getFrame() {
        saveSupplierFrame = new JFrame("save Supplier");
        saveSupplierFrame.getContentPane().setBackground(Color.BLACK);
        saveSupplierFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saveSupplierFrame.setLocation(dim.width / 2 - saveSupplierFrame.getSize().width / 2, dim.height / 2 - saveSupplierFrame.getSize().height / 2);
        saveSupplierFrame.setResizable(false);
        saveSupplierFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        saveSupplierFrame.add(mainPanel);

        JLabel supplierLable = new JLabel("Supplier: ");
        supplierLable.setForeground(new Color(0X00FF00));
        supplierLable.setBackground(Color.BLACK);
        supplierLable.setFont(new Font("Serif", Font.ITALIC, 18));
        supplierLable.setOpaque(true);
        supplierLable.setBounds(20, 30, 80, 25);
        mainPanel.add(supplierLable);

        JLabel contactPersonLable = new JLabel("Contact Person: ");
        contactPersonLable.setForeground(new Color(0X00FF00));
        contactPersonLable.setBackground(Color.BLACK);
        contactPersonLable.setFont(new Font("Serif", Font.ITALIC, 18));
        contactPersonLable.setOpaque(true);
        contactPersonLable.setBounds(20, 70, 130, 25);
        mainPanel.add(contactPersonLable);

        JLabel cityLable = new JLabel("City: ");
        cityLable.setForeground(new Color(0X00FF00));
        cityLable.setBackground(Color.BLACK);
        cityLable.setFont(new Font("Serif", Font.ITALIC, 18));
        cityLable.setOpaque(true);
        cityLable.setBounds(20, 120, 50, 25);
        mainPanel.add(cityLable);

        JLabel contactNumberLable = new JLabel("Contact Number: ");
        contactNumberLable.setForeground(new Color(0X00FF00));
        contactNumberLable.setBackground(Color.BLACK);
        contactNumberLable.setFont(new Font("Serif", Font.ITALIC, 18));
        contactNumberLable.setOpaque(true);
        contactNumberLable.setBounds(20, 170, 140, 25);
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
        statusLable.setBounds(20, 270, 60, 25);
        mainPanel.add(statusLable);

        supplierFeild = new JTextField();
        supplierFeild.setBounds(110, 30, 200, 25);
        mainPanel.add(supplierFeild);

        contactPersonFeild = new JTextField();
        contactPersonFeild.setBounds(160, 70, 200, 25);
        mainPanel.add(contactPersonFeild);

        cityFeild = new JTextField();
        cityFeild.setBounds(80, 120, 150, 25);
        mainPanel.add(cityFeild);

        contactNumberFeild = new JTextField();
        contactNumberFeild.setBounds(170, 170, 150, 25);
        mainPanel.add(contactNumberFeild);

        licenseDetailFeild = new JTextField();
        licenseDetailFeild.setBounds(150, 220, 200, 25);
        mainPanel.add(licenseDetailFeild);

        statusComboBox = new JComboBox(statusDropDown);
        statusComboBox.setBackground(Color.GRAY);
        statusComboBox.setEditable(false);
        statusComboBox.setBounds(90, 270, 200, 25);
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

        saveSupplierFrame.setVisible(true);
        return saveSupplierFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSupplierFrame.dispose();
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
                supplier.setSupplier(supplierFeild.getText());
                supplier.setContactPerson(contactPersonFeild.getText());
                supplier.setCity(cityFeild.getText());
                supplier.setContactNumber(contactNumberFeild.getText());
                supplier.setLicenseDetail(licenseDetailFeild.getText());
                supplier.setStatus(status);
                supplier.setStatusDate(formatDateTime);
                supplierService.saveSupplier(supplier);
                saveSupplierFrame.dispose();
                supplierView.showAll();
            }
        };
    }
}
