package service;
import dao.SaleDao;
import entity.Sale;

import java.util.ArrayList;

public class SaleService {
    private SaleDao saleDao;

    public SaleService() {
        this.saleDao = new SaleDao();
    }

    public ArrayList<Sale> searchSaleById(int id) {
        return saleDao.searchSaleById(id);
    }
    public ArrayList<Sale> searchSaleByName(String name) {
        return saleDao.searchSaleByName(name);
    }
    public void updateCount(int id , int count){saleDao.updateCount(id,count);}

}
