package view;

public class Course {
    private int id;
    private String name;

    public Course(int id , String name){
        if(name.equals("OOP")){
            this.id = 1;
        } else if(name.equals("PF")){
            this.id = 2;
        } else if(name.equals("ITC")){
            this.id = 3;
        } else if(name.equals("DSA")){
            this.id = 4;
        } else {
            this.id = id;
        }
        this.name = name;
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
}