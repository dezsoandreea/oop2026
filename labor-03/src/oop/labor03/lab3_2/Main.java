package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Customer costumer1 = new Customer("Andreea", "Dezso");
//        costumer1.addAccount(new BankAccount(("BT1"), 1000));
//        costumer1.addAccount(new BankAccount(("BT2"), 200000));
//        System.out.println(costumer1);

        Customer customer1 = new Customer("Shepherd", "Harrelson");
        customer1.addAccount(new BankAccount(("BT1")));
        customer1.addAccount(new BankAccount(("BT2")));
        customer1.addAccount(new BankAccount(("BT3")));
        customer1.addAccount(new BankAccount(("BT4")));
        customer1.addAccount(new BankAccount(("BT5")));

        System.out.println(customer1);

        Customer customer2 = new Customer("Shayla", "Norwood");
        customer2.addAccount(new BankAccount(("BT6")));
        customer2.addAccount(new BankAccount(("BT7")));
        customer2.addAccount(new BankAccount(("BT8")));
        customer2.addAccount(new BankAccount(("BT9")));
        customer2.addAccount(new BankAccount(("BT10")));
        customer2.addAccount(new BankAccount(("BT11")));
        customer2.addAccount(new BankAccount(("BT12")));
        customer2.addAccount(new BankAccount(("BT13")));
        customer2.addAccount(new BankAccount(("BT14")));

        System.out.println(customer2);

        Random random = new Random();

        customer1.getAccount(("BT1")).deposit(random.nextInt(100000));
        customer1.getAccount(("BT2")).deposit(random.nextInt(100000));
        customer1.getAccount(("BT3")).deposit(random.nextInt(100000));
        customer1.getAccount(("BT4")).deposit(random.nextInt(100000));
        customer1.getAccount(("BT5")).deposit(random.nextInt(100000));

        customer2.getAccount(("BT6")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT7")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT8")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT9")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT10")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT11")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT12")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT13")).deposit(random.nextInt(100000));
        customer2.getAccount(("BT14")).deposit(random.nextInt(100000));

        customer1.closeAccount(("BT1"));
        System.out.println(customer1);

        customer2.closeAccount(("BT14"));
        System.out.println(customer2);
    }
}
