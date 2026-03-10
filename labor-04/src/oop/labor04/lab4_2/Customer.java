package oop.labor04.lab4_2;

import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        String result = this.firstName + " " + this.lastName + " accounts: \n";
        for(int i=0; i<accounts.size(); i++){
            result += "\t" + accounts.get(i) + "\n";
        }
        return result;
    }
}
