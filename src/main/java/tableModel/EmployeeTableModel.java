package tableModel;
import entity.Employee;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EmployeeTableModel extends AbstractTableModel {
    private String[] columnNames = {"Id", "Name", "Father Name" , "Designation" , "Cnic" , "Phone Number" , "Start Date" , "End Date" , "Status"};
    private ArrayList<Employee> dataList;

    public EmployeeTableModel(ArrayList<Employee> dataList) {
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
            return dataList.get(rowIndex).getFatherName();
        }  else if (columnIndex == 3) {
            return dataList.get(rowIndex).getDesignation();
        }  else if (columnIndex == 4) {
            return dataList.get(rowIndex).getCnic();
        }  else if (columnIndex == 5) {
            return dataList.get(rowIndex).getPhoneNumber();
        }  else if (columnIndex == 6) {
            return dataList.get(rowIndex).getStartDate();
        }  else if (columnIndex == 7) {
            return dataList.get(rowIndex).getEndDate();
        }  else if (columnIndex == 8) {
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
            return String.class;
        } else if (columnIndex == 5) {
            return String.class;
        } else if (columnIndex == 6) {
            return String.class;
        } else if (columnIndex == 7) {
            return String.class;
        } else if (columnIndex == 8) {
            return String.class;
        } else {
            return String.class;
        }
    }
}
