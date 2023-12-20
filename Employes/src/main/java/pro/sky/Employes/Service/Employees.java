package pro.sky.Employes.Service;

import java.util.Objects;

public class Employees {

    private String firstName;
    private String lastName;
    private int department;
    private double salary;



    public Employees(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

//    public String toString() {
//        return "\nИмя - " + getFirstName() + "\nФамилия - " + getLastName() + "\n";
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(firstName, employees.firstName) && Objects.equals(lastName, employees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
