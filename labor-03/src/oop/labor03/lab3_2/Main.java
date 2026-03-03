package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;

public class Main {
    public static void main(String[] args) {
        Customer costumer1 = new Customer("Andreea", "Dezso");
        costumer1.addAccount(new BankAccount(("BT1"), 1000));
        costumer1.addAccount(new BankAccount(("BT2"), 200000));
        System.out.println(costumer1);
    }
}
