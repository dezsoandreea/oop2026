package oop.labor03.lab3_1;

public class Main {
    public static void main(String[] args) {
//        BankAccount account1 = new BankAccount(("BT1"));
//        BankAccount account2 = new BankAccount(("BT1"), 10000);
//
//        System.out.println("account1: " + account1);
//        System.out.println("account2: " + account2);

//        proba:
//        Customer customer1 = new Customer("Andreea", "Dezso");
//        System.out.println(customer1);
//        customer1.setAccount(new BankAccount(("BT1"), 1000));
//        System.out.println(customer1);
//
//        customer1.getAccount().deposit(2000);
//        System.out.println(customer1);

        Customer customer1 = new Customer("John", "BLACK");
        System.out.println(customer1);
        customer1.setAccount(new BankAccount(("OTP00001")));
        System.out.println(customer1);

        customer1.getAccount().deposit(1000);
        System.out.println(customer1);

        System.out.println(" ");

        Customer customer2 = new Customer("Mary", "WHITE");
        System.out.println(customer2);
        customer2.setAccount(new BankAccount(("OTP00002")));
        System.out.println(customer2);

        customer2.closeAccount();
        System.out.println(customer2);

        customer2.setLastName(customer1.getLastName());
        customer2.setAccount(customer1.getAccount());

        System.out.println("Közös számla után:");
        System.out.println("John: " + customer1);
        System.out.println("Mary: " + customer2);
    }
}
