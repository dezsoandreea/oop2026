package oop.labor10.lab10_3;

import oop.labor10.lab10_2.MyDate;

public class Manager extends Employee{
    private String departmant;

    public Manager(String firstName, String lastName, double salary, MyDate birthDate, String departmant) {
        super(firstName, lastName, salary, birthDate);
        this.departmant = departmant;
    }

    public String getDepartmant() {
        return departmant;
    }

    public void setDepartmant(String departmant) {
        this.departmant = departmant;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                ", departmant='" + departmant + '\'' +
                '}';
    }
}
