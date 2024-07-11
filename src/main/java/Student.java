import view.Course;

import java.util.ArrayList;

public class Student {
    private String name;
    final private int id;
    private double cgpa;
    private String address;
    private ArrayList<Course> courses;
    private static int idInitializer = 1;

    public Student() {
        System.out.println("Default constructor Called;");
        name = null;
        id = idInitializer++;
        cgpa = 0.0;
        address = null;
    }

    public Student(String name, double cgpa , String address) {
        System.out.println("Parameterized constructor Called;");
        this.name = name;
        this.id = idInitializer++;
        this.cgpa = cgpa;
        this.address = address;
    }

    public void addCourse(int id , String name)
    {
        courses.add(new Course(id,name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayStudentInfo() {
        System.out.println("NAME: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("CGPA: " + this.cgpa);
        System.out.println("ADDRESS: " + this.address);
    }
}
