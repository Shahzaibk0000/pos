package entity;

public class Category {
    private int Id;
    private String Name;
    private int Barcode;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getBarcode() {
        return Barcode;
    }

    public void setBarcode(int barcode) {
        Barcode = barcode;
    }
}
