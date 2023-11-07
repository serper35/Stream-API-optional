package pro.sky.Employes.Service;


import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public String addEmployee(String name, String lastName);
    public String removeEmployee(String name, String lastName);
    public String findEmployee(String name, String lastName);

    public Map<String, Employees> getInfo();
}
