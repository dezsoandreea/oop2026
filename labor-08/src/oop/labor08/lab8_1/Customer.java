package oop.labor08.lab8_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 0;

    private final int id;

    private String firstName;
    private String lastName;

    private ArrayList<BankAccount> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++numCustomers;
        this.accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount(String accountNumber) {
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                return accounts.get(i);
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        for (BankAccount acc : accounts) {
            numbers.add(acc.getAccountNumber());
        }
        return numbers;
    }

    public void closeAccount(String accountNumber) {
        int j = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                j = i;
                break;
            }
        }
        if (j != -1) {
            accounts.remove(j);
            System.out.println("Számla (" + accountNumber + ") sikeresen lezárva.");
        } else {
            System.out.println("Hiba: A megadott számlaszám nem található!");
        }
    }

    @Override
    public String toString() {
        String result = this.firstName + " " + this.lastName + " " + this.id + " accounts: \n";
        for(int i=0; i<accounts.size(); i++){
            result += "\t" + accounts.get(i) + "\n";
        }
        return result;
    }
}
