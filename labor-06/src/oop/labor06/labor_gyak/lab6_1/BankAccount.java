package oop.labor06.labor_gyak.lab6_1;

public class BankAccount {
    public static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENGTH = 10;

    private static int numAccounts = 0;

    private final String accountNumber;
    private double balance;

    public BankAccount() {
        numAccounts++;
        this.accountNumber = createAccountNumber();
        this.balance = 0;
    }

    private static String createAccountNumber()
    {
        return String.format("%s%0" + (ACCOUNT_NUMBER_LENGTH - PREFIX.length()) + "d", PREFIX, numAccounts);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
