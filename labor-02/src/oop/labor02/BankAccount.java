package oop.labor02;

public class BankAccount
{
    private String accountNumber;
    private double balance;

    public BankAccount(String aNumber)
    {
        accountNumber = aNumber;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
    public boolean withdraw(double amount)
    {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}