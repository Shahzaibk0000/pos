package tableModel;

import entity.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private String[] columnNames = {"Id", "Name", "Category"};
    private ArrayList<Product> dataList;

    public ProductTableModel(ArrayList<Product> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getRowCount() {
        return dataList != null ? dataList.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return dataList.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return dataList.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            return dataList.get(rowIndex).getCategory();
        }
        return "N/A";
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        } else if (columnIndex == 1) {
            return String.class;
        } else if (columnIndex == 2) {
            return String.class;
        } else {
            return String.class;
        }
    }
}
