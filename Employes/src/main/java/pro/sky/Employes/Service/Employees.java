package pro.sky.Employes.Service;

import java.util.Objects;

public class Employees {

    private String firstName;
    private String lastName;


    public Employees(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

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
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

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
}
