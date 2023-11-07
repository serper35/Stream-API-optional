package pro.sky.Employes;

import org.springframework.web.bind.annotation.*;
import pro.sky.Employes.Service.EmployeeService;
import pro.sky.Employes.Service.Employees;

import java.util.List;
import java.util.Map;

@RequestMapping("employee")
@RestController
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
            return employeeService.addEmployee(name, lastname);
    }

    @GetMapping("/getInfo")
    public Map<String, Employees> getInfo() {
        return employeeService.getInfo();
    }

    @GetMapping("remove")
    public String remove(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
            return employeeService.removeEmployee(name, lastname);
    }

    @GetMapping("find")
    public String find(@RequestParam("firstName") String name, @RequestParam("lastName") String lastname) {
            return employeeService.findEmployee(name, lastname);
    }
}
