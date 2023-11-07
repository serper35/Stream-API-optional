package pro.sky.Employes.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employes.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.Employes.Exceptions.EmployeeNotFoundException;
import pro.sky.Employes.Exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int workerSize = 10;

    List<Employees> workers = new ArrayList<>(List.of(
            new Employees("Vlad", "Volkov"),
            new Employees("Egor", "Golovanov"),
            new Employees("Frank", "Lampard"),
            new Employees("John", "Terry"),
            new Employees("Petr", "Chech"),
            new Employees("Didier", "Drogba")
    ));

    @Override
    public String addEmployee(String name, String lastName) {
        Employees employees = new Employees(name, lastName);

        for (int i = 0; i < workers.size(); i++) {
            if (employees.equals(workers.get(i))) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных.");
            }
        }

        if (workers.size() < workerSize) {
            workers.add(employees);
            return "Сотрудник " + workers.get(workers.size() - 1) + " добавлен.";
        } else {
            throw new EmployeeStorageIsFullException("База данных переполнена.");
        }
    }

    @Override
    public String removeEmployee(String name, String lastName) {
        Employees test = new Employees(name, lastName);

        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).equals(test)) {
                workers.remove(i);
                return "Сотрудник " + test + " удален.";
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    @Override
    public String findEmployee(String name, String lastName) {
        Employees test = new Employees(name, lastName);
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).equals(test)) {
                return "Сотрудник " + workers.get(i) + " найден.";
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    public List<Employees> getInfo() {
        return new ArrayList<>(workers);
    }
}
