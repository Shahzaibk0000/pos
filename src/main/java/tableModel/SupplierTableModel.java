package tableModel;
import entity.Supplier;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SupplierTableModel extends AbstractTableModel {
    private String[] columnNames = {"Id", "supplier", "contactPerson" , "City" , "contactNumber" , "LicenseDetail" , "Status" , "Status Date"};
    private ArrayList<Supplier> dataList;

    public SupplierTableModel(ArrayList<Supplier> dataList) {
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
            return dataList.get(rowIndex).getSupplier();
        } else if (columnIndex == 2) {
            return dataList.get(rowIndex).getContactPerson();
        } else if (columnIndex == 3) {
            return dataList.get(rowIndex).getCity();
        } else if (columnIndex == 4) {
            return dataList.get(rowIndex).getContactNumber();
        } else if (columnIndex == 5) {
            return dataList.get(rowIndex).getLicenseDetail();
        } else if (columnIndex == 6) {
            return dataList.get(rowIndex).getStatus();
        } else if (columnIndex == 7) {
            return dataList.get(rowIndex).getStatusDate();
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
            return Integer.class;
        } else if (columnIndex == 3) {
            return String.class;
        } else if (columnIndex == 4) {
            return Integer.class;
        }else if (columnIndex == 5) {
            return String.class;
        } else if (columnIndex == 6) {
            return Integer.class;
        } else if (columnIndex == 7) {
            return Integer.class;
        } else {
            return String.class;
        }
    }
}
