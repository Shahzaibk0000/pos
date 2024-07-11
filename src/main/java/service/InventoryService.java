package service;
import dao.InventoryDao;
import entity.Inventory;
import java.util.ArrayList;

public class InventoryService {
    private InventoryDao inventoryDao;

    public InventoryService() {
        this.inventoryDao = new InventoryDao();
    }

    public ArrayList<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }

    public ArrayList<Inventory> searchInventoryById(int id) {
        return inventoryDao.searchInventoryById(id);
    }

    public void saveInventory(Inventory inventory) {
        inventoryDao.saveInventory(inventory);
    }

    public void updateInventory(Inventory inventory) {
        inventoryDao.updateInventory(inventory);
    }
}
