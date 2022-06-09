package entity;

public class Product {
    private int id;
    private int categoryId;
    private int supplierId;
    private String name;
    private String category;
    private String supplier;
    private double rsp;
    private double netRsp;
    private String storageLocation;
    private String status;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getRsp() {
        return rsp;
    }

    public void setRsp(double rsp) {
        this.rsp = rsp;
    }

    public double getNetRsp() {
        return netRsp;
    }

    public void setNetRsp(double netRsp) {
        this.netRsp = netRsp;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", supplier='" + supplier + '\'' +
                ", rsp=" + rsp +
                ", netRsp=" + netRsp +
                ", storageLocation='" + storageLocation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
