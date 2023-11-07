package pro.sky.Employes.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employes.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.Employes.Exceptions.EmployeeNotFoundException;
import pro.sky.Employes.Exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int WORKER_SIZE = 10;

    Map<String, Employees> workers = new HashMap<>(Map.of(
            "VladVolkov",
            new Employees("Vlad", "Volkov"),
            "EgorGolovanov",
            new Employees("Egor", "Golovanov"),
            "FrankLampard",
            new Employees("Frank", "Lampard"),
            "JohnTerry",
            new Employees("John", "Terry"),
            "PetrChech",
            new Employees("Petr", "Chech"),
            "DidierDrogba",
            new Employees("Didier", "Drogba")
    ));

    @Override
    public String addEmployee(String name, String lastName) {
        Employees employees = new Employees(name, lastName);

        if (workers.containsKey(name + lastName)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в базе данных.");
        }

        if (workers.size() < WORKER_SIZE) {
            workers.put(name + lastName, employees);
            return "Сотрудник " + employees + " добавлен.";
        } else {
            throw new EmployeeStorageIsFullException("База данных переполнена.");
        }
    }

    @Override
    public String removeEmployee(String name, String lastName) {
        Employees test = new Employees(name, lastName);

        if (workers.containsKey(name + lastName)) {
            workers.remove(name + lastName);
            return "Сотрудник " + test + " удален.";
        }

        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    @Override
    public String findEmployee(String name, String lastName) {
        Employees test = new Employees(name, lastName);

        if (workers.containsKey(name + lastName)) {
            return "Сотрудник " + test + " найден.";
        }

        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    public Map<String, Employees> getInfo() {
        return new HashMap<>(workers);
    }
}
