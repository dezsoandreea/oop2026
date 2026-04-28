package oop.labor10.lab10_3;

import oop.labor10.lab10_2.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(String csvFile){
        try (Scanner sc = new Scanner(new File(csvFile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");
                String firstName = data[0].trim();
                String lastName = data[1].trim();
                double salary = Double.parseDouble(data[2].trim());
                int year = Integer.parseInt(data[3].trim());
                int month = Integer.parseInt(data[4].trim());
                int day = Integer.parseInt(data[5].trim());
                MyDate birthDate = new MyDate(year, month, day);
                if (data.length == 6) {
                    Employee employee = new Employee(firstName, lastName, salary, birthDate);
                    hire(employee);
                } else {
                    String department = data[6].trim();
                    Manager manager = new Manager(firstName, lastName, salary, birthDate, department);
                    hire(manager);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fire(int ID){
        employees.remove(ID);
    }

    public void printAll(PrintStream out){
        for(Employee e : employees){
            out.println(e);
        }
    }

    public void printAllManagers(PrintStream out){
        for(Employee m : employees){
            if(m instanceof Manager){
                out.println(m);
            }
        }
    }

    public void sortByComparator(Comparator<Employee> comp){
        employees.sort(comp);
    }
}
