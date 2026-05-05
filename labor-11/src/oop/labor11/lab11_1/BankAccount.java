package oop.labor11.lab11_1;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) throws InsufficientFundsExeption {
        if(amount>balance){
            throw new InsufficientFundsExeption("Nincs elege penzed");
        }
        balance -= amount;
    }
}
