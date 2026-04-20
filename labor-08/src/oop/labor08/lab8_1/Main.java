package oop.labor08.lab8_1;

public class Main {
    public static void main(String[] args) {
        Bank otpBank = new Bank("OTP");

        Customer customer1 = new Customer("Janos", "Kovacs");
        Customer customer2 = new Customer("Maria", "Szabo");

        otpBank.addCustomer(customer1);
        otpBank.addCustomer(customer2);

        customer1.addAccount(new SavingsAccount(0.05));
        customer1.addAccount(new CheckingAccount(500));

        customer2.addAccount(new SavingsAccount(0.03));
        customer2.addAccount(new CheckingAccount(1000));

        for (String accNum : customer1.getAccountNumbers()) {
            otpBank.getCustomer(1).getAccount(accNum).deposit(1000);
        }

        for (String accNum : customer2.getAccountNumbers()) {
            otpBank.getCustomer(2).getAccount(accNum).deposit(500);
        }

        System.out.println("--- Kezdeti állapot ---");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\n--- Kamatok jóváírása (SavingsAccount) ---");
        for(String c : customer1.getAccountNumbers()){
            BankAccount a = otpBank.getCustomer(1).getAccount(c);
            if(a instanceof SavingsAccount){
                ((SavingsAccount)a).addInterest();
            }
        }

        for(String c : customer2.getAccountNumbers()){
            BankAccount a = otpBank.getCustomer(2).getAccount(c);
            if(a instanceof SavingsAccount){
                ((SavingsAccount)a).addInterest();
            }
        }

        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\n--- Pénzfelvétel folyamatban... ---");
        for (String cw : customer1.getAccountNumbers()) {
            otpBank.getCustomer(1).getAccount(cw).withdraw(500);
        }

        for (String cw : customer2.getAccountNumbers()) {
            otpBank.getCustomer(2).getAccount(cw).deposit(100);
        }

        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\n--- Végső állapot ---");
        System.out.println(customer1);
        System.out.println(customer2);
    }
}
