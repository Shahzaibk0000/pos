package service;
import dao.SupplierDao;
import entity.Supplier;
import java.util.ArrayList;
import java.util.Map;

public class SupplierService {
    private SupplierDao supplierDao;

    public SupplierService() {
        this.supplierDao = new SupplierDao();
    }

    public ArrayList<Supplier> getAllSupplier() {
        return supplierDao.getAllSupplier();
    }

    public ArrayList<Supplier> searchSupplierByName(String name) {
        return supplierDao.searchSupplierByName(name);
    }

    public ArrayList<Supplier> searchSupplierById(int id) {
        return supplierDao.searchSupplierById(id);
    }

    public void saveSupplier(Supplier supplier) {
        supplierDao.saveEmployee(supplier);
    }

    public Map<String,Integer> getAllSupplierMap() {
        return supplierDao.getAllSupplierMap();
    }

    public void updateSupplier(Supplier supplier) {
        supplierDao.updateSupplier(supplier);
    }
}
