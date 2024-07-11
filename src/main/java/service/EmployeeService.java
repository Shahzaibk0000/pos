package service;
import dao.EmployeeDao;
import entity.Employee;
import java.util.ArrayList;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }

    public ArrayList<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    public ArrayList<Employee> searchEmployeeByName(String name) {
        return employeeDao.searchEmployeeByName(name);
    }

    public ArrayList<Employee> searchEmployeeById(int id) {
        return employeeDao.searchEmployeeById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
