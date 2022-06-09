package view;
import entity.Category;
import service.CategoryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CategoryEditView {
    private JFrame editCategoryFrame;
    private Category category;
    private CategoryService categoryService;
    private String searchDropDown[] = {"Id", "Name"};
    private JTextField nameFeild, idFeild , barcodeFeild;
    private Map<String, Integer> categoryMap;
    private CategoryView categoryView;

    public CategoryEditView(Category category) {
        this.category = category;
        categoryService = new CategoryService();
        categoryMap = categoryService.getAllCategoryMap();
    }

    public JFrame getFrame() {
        editCategoryFrame = new JFrame("Edit Category");
        editCategoryFrame.getContentPane().setBackground(Color.BLACK);
        editCategoryFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        editCategoryFrame.setLocation(dim.width / 2 - editCategoryFrame.getSize().width / 2, dim.height / 2 - editCategoryFrame.getSize().height / 2);
        editCategoryFrame.setResizable(false);
        editCategoryFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLUE);
        editCategoryFrame.add(mainPanel);

        JLabel idLable = new JLabel("ID: ");
        idLable.setForeground(new Color(0X00FF00));
        idLable.setBackground(Color.BLACK);
        idLable.setFont(new Font("Serif", Font.ITALIC, 18));
        idLable.setOpaque(true);
        idLable.setBounds(20, 40, 50, 25);
        mainPanel.add(idLable);

        JLabel nameLable = new JLabel("name: ");
        nameLable.setForeground(new Color(0X00FF00));
        nameLable.setBackground(Color.BLACK);
        nameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLable.setOpaque(true);
        nameLable.setBounds(20, 80, 50, 25);
        mainPanel.add(nameLable);

        JLabel barcodeLable = new JLabel("Barcode: ");
        barcodeLable.setForeground(new Color(0X00FF00));
        barcodeLable.setBackground(Color.BLACK);
        barcodeLable.setFont(new Font("Serif", Font.ITALIC, 18));
        barcodeLable.setOpaque(true);
        barcodeLable.setBounds(20, 120, 80, 25);
        mainPanel.add(barcodeLable);

        idFeild = new JTextField(String.valueOf(category.getId()));
        idFeild.setBounds(80, 40, 200, 25);
        idFeild.setEditable(false);
        mainPanel.add(idFeild);

        nameFeild = new JTextField(category.getName());
        nameFeild.setBounds(80, 80, 200, 25);
        mainPanel.add(nameFeild);

        barcodeFeild = new JTextField(String.valueOf(category.getBarcode()));
        barcodeFeild.setBounds(110, 120, 200, 25);
        mainPanel.add(barcodeFeild);

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

        editCategoryFrame.setVisible(true);
        return editCategoryFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editCategoryFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Category category = new Category();
                category.setId(Integer.parseInt(idFeild.getText()));
                category.setName(nameFeild.getText());
                category.setBarcode(Integer.parseInt(barcodeFeild.getText()));
                categoryService.updateCategory(category);
                editCategoryFrame.dispose();
                categoryView.showAll();
            }
        };
    }
}
