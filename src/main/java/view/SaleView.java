package view;
import entity.Sale;
import service.SaleService;
import tableModel.SaleTableModel;
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

public class SaleView {
    private JFrame saleFrame;
    private JTable table;
    private  JTextField idFeild , name , quantity , totalField;
    private ArrayList<Sale> saleList;
    private SaleService saleService;
    private JTextArea billArea;
    private double totalPrice = 0;
    private LocalDateTime now;
    private DateTimeFormatter format;
    private String formatDateTime;

    private void appendTextArea(JTextArea area,String text){
        area.append(text);
    }

    private void setNewTextArea(){
        billArea.setText(null);
        now = LocalDateTime.now();
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss");
        formatDateTime = now.format(format);
        billArea.append("\t" + AppConstant.COMPANY_NAME + "\n\n" + "Date/Time: " + formatDateTime + "\n\n");
        billArea.append("ID\tName-Quantity\tPrice\n\n");
        totalPrice = 0.0;
        totalField.setText(String.valueOf(totalPrice));
    }


    public SaleView()
    {
        this.saleService = new SaleService();
    }

    public JFrame getFrame() {
        saleFrame = new JFrame("Sale Frame");
        saleFrame.getContentPane().setBackground(Color.BLACK);
        saleFrame.setSize(1000, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saleFrame.setLocation(dim.width / 2 - saleFrame.getSize().width / 2, dim.height / 2 - saleFrame.getSize().height / 2);
        saleFrame.setResizable(false);
        saleFrame.setLayout(null);

        JPanel searchProductPanel = new JPanel();
        searchProductPanel.setLayout(null);
        searchProductPanel.setBounds(10, 10, 600, 230);
        searchProductPanel.setBackground(Color.BLACK);
        saleFrame.add(searchProductPanel);

        JLabel companyNameLable = new JLabel(AppConstant.COMPANY_NAME);
        companyNameLable.setForeground(new Color(0X00FF00));
        companyNameLable.setBackground(Color.BLACK);
        companyNameLable.setFont(new Font("Serif", Font.ITALIC, 32));
        companyNameLable.setOpaque(true);
        companyNameLable.setBounds(250, 0, 250, 35);
        searchProductPanel.add(companyNameLable);

        idFeild = new JTextField();
        idFeild.setBounds(20, 90, 80, 50);
        searchProductPanel.add(idFeild);

        name = new JTextField();
        name.setBounds(120, 90, 200, 50);
        searchProductPanel.add(name);

        quantity = new JTextField();
        quantity.setBounds(340, 90, 80, 50);
        searchProductPanel.add(quantity);

        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(440 , 90 , 100,50);
        enterButton.addActionListener(searchOnClickEvent());
        searchProductPanel.add(enterButton);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(50, 145, 80, 50);
        idLabel.setForeground(new Color(0X00FF00));
        idLabel.setBackground(Color.BLACK);
        idLabel.setFont(new Font("Serif", Font.ITALIC, 22));
        idLabel.setOpaque(true);
        searchProductPanel.add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(180, 145, 80, 50);
        nameLabel.setForeground(new Color(0X00FF00));
        nameLabel.setBackground(Color.BLACK);
        nameLabel.setFont(new Font("Serif", Font.ITALIC, 22));
        nameLabel.setOpaque(true);
        searchProductPanel.add(nameLabel);

        JLabel countLabel = new JLabel("Count");
        countLabel.setBounds(360, 145, 80, 50);
        countLabel.setForeground(new Color(0X00FF00));
        countLabel.setBackground(Color.BLACK);
        countLabel.setFont(new Font("Serif", Font.ITALIC, 22));
        countLabel.setOpaque(true);
        searchProductPanel.add(countLabel);

        JPanel productDetailPanel = new JPanel();
        productDetailPanel.setLayout(null);
        productDetailPanel.setBounds(10, 250, 600, 640);
        productDetailPanel.setBackground(Color.BLACK);
        saleFrame.add(productDetailPanel);

        table = new JTable(new SaleTableModel());
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(3, 3, 594, 634); // x, y, width, height
        productDetailPanel.add(scroll);

        JPanel billPanel = new JPanel();
        billPanel.setLayout(null);
        billPanel.setBounds(630, 10, 340, 640);
        billPanel.setBackground(Color.BLACK);
        saleFrame.add(billPanel);

        JLabel bill = new JLabel("BILL");
        bill.setBounds(140,10,150,50);
        bill.setFont(new Font("Serif", Font.ITALIC, 35));
        bill.setBackground(Color.BLUE);
        bill.setForeground(Color.YELLOW);
        billPanel.add(bill);

        billArea = new JTextArea();
        billArea.setEditable(false);
        billArea.getScrollableTracksViewportHeight();
        billArea.setBounds(1 , 70 , 334 , 450);
        billArea.setFont(new Font("Serif", Font.BOLD, 16));
        scroll = new JScrollPane(billArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        now = LocalDateTime.now();
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss");
        formatDateTime = now.format(format);
        billArea.append("\t" + AppConstant.COMPANY_NAME + "\n\n" + "Date/Time: " + formatDateTime + "\n\n");
        billArea.append("ID\tName-Quantity\tPrice\n\n");
        billPanel.add(billArea);
        billPanel.add(scroll);

        JLabel totalBill = new JLabel("Total:");
        totalBill.setBounds(30, 530, 80, 50);
        totalBill.setForeground(new Color(0X00FF00));
        totalBill.setBackground(Color.BLACK);
        totalBill.setFont(new Font("Serif", Font.ITALIC, 26));
        totalBill.setOpaque(true);
        billPanel.add(totalBill);

        totalField = new JTextField();
        totalField.setBounds(130, 530, 200, 50);
        totalField.setEditable(false);
        billPanel.add(totalField);


        JButton billPrint = new JButton("Print");
        billPrint.setBounds(250 , 590 , 70,50);
        billPrint.addActionListener(printOnClickEvent());
        billPanel.add(billPrint);


        bill.setVisible(true);

        return saleFrame;
    }

    private ActionListener searchOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                now = LocalDateTime.now();
                format = DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss");
                formatDateTime = now.format(format);
                String productName = null;
                productName = name.getText().toString();
                billArea.replaceRange("Date/Time: " + formatDateTime,20,52);
                if(productName.isEmpty())
                {
                    int id = Integer.parseInt(idFeild.getText());
                    saleList = saleService.searchSaleById(id);
                    table.setModel(new SaleTableModel(saleList));
                }
                else
                {
                    saleList = saleService.searchSaleByName(productName);
                    table.setModel(new SaleTableModel(saleList));
                }
                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            JTable target = (JTable)e.getSource();
                            int row = target.getSelectedRow();
                            int column = target.getColumnCount();
                            System.out.println(saleList.get(row).getProductName());
                            if(saleList.get(row).getProductName().length() > 9)
                            {
                                appendTextArea(billArea,saleList.get(row).getProductId() + "\t" + saleList.get(row).getProductName()+"-"+quantity.getText() + "\t" + saleList.get(row).getProductId() + "\n");
                                Integer count = Integer.parseInt(String.valueOf(saleList.get(row).getCount())) - Integer.parseInt(String.valueOf(quantity.getText()));
                                saleService.updateCount(saleList.get(row).getProductId(),count);
                                System.out.println(count);
                            }
                            else
                            {
                                appendTextArea(billArea,saleList.get(row).getProductId() + "\t" + saleList.get(row).getProductName()+"-"+quantity.getText() + "\t\t" + saleList.get(row).getProductId() + "\n");
                                Integer count = Integer.parseInt(String.valueOf(saleList.get(row).getCount())) - Integer.parseInt(String.valueOf(quantity.getText()));
                                saleService.updateCount(saleList.get(row).getProductId(),count);
                                System.out.println(count);
                            }
                            totalPrice = totalPrice + saleList.get(row).getCount();
                            totalField.setText(String.valueOf(totalPrice));
                            table.notifyAll();
                        }
                        idFeild.setText(null);
                        name.setText(null);
                        quantity.setText(null);
                    }
                });
            }
        };
    }

    private ActionListener printOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNewTextArea();
            }
        };
    }
}
