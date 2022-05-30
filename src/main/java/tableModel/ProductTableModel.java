package tableModel;

import entity.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private String[] columnNames = {"Id", "Name", "Category","Supplier","RSP","Net RSP" , "Storage Location" , "Status"};
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
        } else if (columnIndex == 3) {
            return dataList.get(rowIndex).getSupplier();
        } else if (columnIndex == 4) {
            return dataList.get(rowIndex).getRsp();
        } else if (columnIndex == 5) {
            return dataList.get(rowIndex).getNetRsp();
        } else if (columnIndex == 6) {
            return dataList.get(rowIndex).getStorageLocation();
        } else if (columnIndex == 7) {
            return dataList.get(rowIndex).getStatus();
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
        } else if (columnIndex == 3) {
            return String.class;
        } else if (columnIndex == 4) {
            return Double.class;
        } else if (columnIndex == 5) {
            return Double.class;
        } else if (columnIndex == 6) {
            return String.class;
        } else if (columnIndex == 7) {
            return String.class;
        } else {
            return String.class;
        }
    }
}
