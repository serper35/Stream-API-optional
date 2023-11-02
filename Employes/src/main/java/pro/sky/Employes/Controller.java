package pro.sky.Employes;

import org.springframework.web.bind.annotation.*;
import pro.sky.Employes.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.Employes.Exceptions.EmployeeNotFoundException;
import pro.sky.Employes.Exceptions.EmployeeStorageIsFullException;
import pro.sky.Employes.Service.EmployeeService;
import pro.sky.Employes.Service.Employees;

import java.util.List;

@RequestMapping("employee")
@RestController
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
        try {
            return employeeService.addEmployee(name, lastname);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException exception) {
            exception.printStackTrace();
        }
        return "Ошибка добавления.";
    }

    @GetMapping("/getInfo")
    public List<Employees> getInfo() {
        return employeeService.getInfo();
    }

    @GetMapping("remove")
    public String remove(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
        try {
            return employeeService.removeEmployee(name, lastname);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return "Сотрудник не найден.";
    }

    @GetMapping("find")
    public String find(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
        try {
            return employeeService.findEmployee(name, lastname);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return "Сотрудник не найден.";
    }
}
