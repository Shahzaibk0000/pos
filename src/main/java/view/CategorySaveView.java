package view;

import entity.Category;
import entity.Product;
import service.CategoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategorySaveView {
    private JTextField nameFeild, categoryFeild;
    private JFrame saveCategoryFrame;
    private CategoryService categoryService;
    private CategoryView categoryView;

    public CategorySaveView(CategoryView categoryView) {
        this.categoryView = categoryView;
        categoryService = new CategoryService();
    }

    public JFrame getFrame() {
        saveCategoryFrame = new JFrame("save category");
        saveCategoryFrame.getContentPane().setBackground(Color.BLACK);
        saveCategoryFrame.setSize(400, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        saveCategoryFrame.setLocation(dim.width / 2 - saveCategoryFrame.getSize().width / 2, dim.height / 2 - saveCategoryFrame.getSize().height / 2);
        saveCategoryFrame.setResizable(false);
        saveCategoryFrame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, 360, 440);
        mainPanel.setBackground(Color.BLACK);
        saveCategoryFrame.add(mainPanel);

        JLabel nameLable = new JLabel("name: ");
        nameLable.setForeground(new Color(0X00FF00));
        nameLable.setBackground(Color.BLACK);
        nameLable.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLable.setOpaque(true);
        nameLable.setBounds(20, 40, 50, 25);
        mainPanel.add(nameLable);

        JLabel categoryLable = new JLabel("Barcode: ");
        categoryLable.setForeground(new Color(0X00FF00));
        categoryLable.setBackground(Color.BLACK);
        categoryLable.setFont(new Font("Serif", Font.ITALIC, 18));
        categoryLable.setOpaque(true);
        categoryLable.setBounds(20, 90, 80, 25);
        mainPanel.add(categoryLable);

        nameFeild = new JTextField();
        nameFeild.setBounds(80, 40, 200, 25);
        mainPanel.add(nameFeild);

        categoryFeild = new JTextField();
        categoryFeild.setBounds(110, 90, 200, 25);
        mainPanel.add(categoryFeild);

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

        saveCategoryFrame.setVisible(true);
        return saveCategoryFrame;
    }

    private ActionListener cancelOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCategoryFrame.dispose();
            }
        };
    }

    private ActionListener saveOnClickEvent() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Category category = new Category();
                category.setName(nameFeild.getText());
                category.setBarcode(Integer.parseInt(categoryFeild.getText()));
                categoryService.saveCategory(category);
                saveCategoryFrame.dispose();
                categoryView.showAll();
            }
        };
    }
}
