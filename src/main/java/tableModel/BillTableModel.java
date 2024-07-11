package tableModel;

import entity.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BillTableModel {
    public class SaleTableModel extends AbstractTableModel {


        private String[] columnNames = {"Id" , "Product" , "Quantity" , "count" , " "};
        private ArrayList<Sale> dataList;
        private Button button;

        public SaleTableModel() {
        }

        public SaleTableModel(ArrayList<Sale> dataList) {
            this.dataList = dataList;
            button = new Button();
        }

        @Override
        public int getRowCount() {
            return dataList != null ? dataList.size() : 0;
        }

        @Override
        public int getColumnCount() { return columnNames.length; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return dataList.get(rowIndex).getInventoryId();
            } else if (columnIndex == 1) {
                return dataList.get(rowIndex).getProductName();
            } else if (columnIndex == 2) {
                return dataList.get(rowIndex).getQuantity();
            } else if (columnIndex == 3) {
                return dataList.get(rowIndex).getCount();
            } else if (columnIndex == 4) {
                return button.getJButton().getUI();
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
                return Integer.class;
            } else if (columnIndex == 4){
                return Button.class;
            } else {
                return String.class;
            }
        }
    }
}
