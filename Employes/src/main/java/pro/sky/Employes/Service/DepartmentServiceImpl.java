package pro.sky.Employes.Service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employees minSalary(int dep) {
        return employeeService.getInfo().values().stream()
                .filter(e -> e.getDepartment() == dep)
                .min(Comparator.comparingDouble(emp -> emp.getSalary()))
                .orElse(null);

    }

    @Override
    public Employees maxSalary(int dep) {
        return employeeService.workers.values().stream()
        .filter(e -> e.getDepartment() == dep)
        .max(Comparator.comparingDouble(emp -> emp.getSalary()))
        .orElse(null);
    }

    @Override
    public Map<Integer,List<Employees>> allEmployees() {
        return employeeService.workers.values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }

    @Override
    public List<Employees> employeesByDep(int dep) {
        return employeeService.workers.values().stream()
        .filter(e -> e.getDepartment() == dep)
                .collect(Collectors.toList());
    }
}
