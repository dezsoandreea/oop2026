package oop.labor06.labor_gyak.lab6_1;

public class Main {
    public static void main(String[] args) {
        Bank otp = new Bank("OTP");

        Customer c1 = new Customer("Janos", "Kiss");
        Customer c2 = new Customer("Maria", "Nagy");
        otp.addCustomer(c1);
        otp.addCustomer(c2);

        c1.addAccount(new BankAccount());
        c1.addAccount(new BankAccount());
        c2.addAccount(new BankAccount());
        c2.addAccount(new BankAccount());

        System.out.println("Customer ID 1:");
        System.out.println(otp.getCustomer(1));

        for (String accNum : c1.getAccountNumbers()) {
            otp.getCustomer(1).getAccount(accNum).deposit(1000);
        }

        System.out.println("\nCustomer ID 2:");
        System.out.println(otp.getCustomer(2));

        otp.printCustomersToFile("bank_customers.csv");
        otp.printCustomersToStdout();
    }
}
