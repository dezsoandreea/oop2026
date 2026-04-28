package oop.labor10.lab10_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Company company = new Company("DreamOpera");
        company.hireAll("employees.csv");
        company.printAll(System.out);
        System.out.println("*************************");

        System.out.println("Alphabetically: ");
        company.sortByComparator(new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getFirstName().equals(e2.getFirstName())) {
                    return e1.getLastName().compareTo(e2.getLastName());
                }
                return e1.getFirstName().compareTo(e2.getFirstName());
            }
        });
        company.printAll(System.out);
        System.out.println("*********************");

        System.out.println("Decreasing salary order: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });
        company.printAll(System.out);
        System.out.println("*********************");

        System.out.println("Managers followed by employees ALPHABETICALLY: ");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1 instanceof Manager && e2 instanceof Manager) {
                    if (e1.getFirstName().equals(e2.getFirstName())) {
                        return e1.getLastName().compareTo(e2.getLastName());
                    }
                    return e1.getFirstName().compareTo(e2.getFirstName());
                }
                if (e1 instanceof Manager) {
                    return -1;
                }
                if (e2 instanceof Manager) {
                    return 1;
                }
                if (e1.getFirstName().equals(e2.getFirstName())) {
                    return e1.getLastName().compareTo(e2.getLastName());
                }
                return e1.getFirstName().compareTo(e2.getFirstName());
            }
        });
        company.printAll(System.out);
    }
}
