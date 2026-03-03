package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;
import java.util.Arrays;

public class Customer {
    private String firstName;
    private String lastName;

    public static final int MAX_ACCOUNTS = 10;
    private BankAccount[] account = new BankAccount[MAX_ACCOUNTS];

    private int numAccounts;
    private BankAccount accounts[] = new BankAccount[ MAX_ACCOUNTS ];

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
        for(int i=0; i<numAccounts; i++){
            if(accounts[i].getAccountNumber().equals(accountNumber)){
                return accounts[i];
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account){
        if(numAccounts < MAX_ACCOUNTS){
            accounts[numAccounts] = account;
            numAccounts++;
        }
    }

    public int getNumAccounts(){
        return numAccounts;
    }

    public void closeAccount(String accountNumber) {
        int index = -1;
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < numAccounts - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            accounts[--numAccounts] = null;
            System.out.println("Számla (" + accountNumber + ") sikeresen lezárva.");
        } else {
            System.out.println("Hiba: A megadott számlaszám nem található!");
        }
    }

    @Override
    public String toString() {
        String result = this.firstName + " " + this.lastName + " accounts: \n";
        for(int i=0; i<numAccounts; i++){
            result += "\t" + accounts[i] + "\n";
        }
        return result;
    }
}
