package tableModel;
import entity.Inventory;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InventoryTableModel extends AbstractTableModel{

    private String[] columnNames = {"Id", "Category", "Product","Purchase Price","Quantity","Total Price" , "Storage Location" , "Status" , "Date" , "count"};
    private ArrayList<Inventory> dataList;

    public InventoryTableModel(ArrayList<Inventory> dataList) {
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
            return dataList.get(rowIndex).getInventoryId();
        } else if (columnIndex == 1) {
            return dataList.get(rowIndex).getCategoryName();
        } else if (columnIndex == 2) {
            return dataList.get(rowIndex).getProductName();
        } else if (columnIndex == 3) {
            return dataList.get(rowIndex).getPurchasePrice();
        } else if (columnIndex == 4) {
            return dataList.get(rowIndex).getQuantity();
        } else if (columnIndex == 5) {
            return dataList.get(rowIndex).getTotalPrice();
        } else if (columnIndex == 6) {
            return dataList.get(rowIndex).getStorageLocation();
        } else if (columnIndex == 7) {
            return dataList.get(rowIndex).getInventoryStatus();
        } else if (columnIndex == 8) {
            return dataList.get(rowIndex).getDate();
        } else if (columnIndex == 9) {
            return dataList.get(rowIndex).getCount();
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
            return Double.class;
        } else if (columnIndex == 4) {
            return Integer.class;
        } else if (columnIndex == 5) {
            return Double.class;
        } else if (columnIndex == 6) {
            return String.class;
        } else if (columnIndex == 7) {
            return String.class;
        } else if (columnIndex == 8) {
            return String.class;
        } else if (columnIndex == 9) {
            return Integer.class;
        }   else {
            return String.class;
        }
    }
}
