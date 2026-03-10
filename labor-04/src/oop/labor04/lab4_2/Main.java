package oop.labor04.lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("lab4_2_input.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String firstName;
                String lastName;
                String[] items = line.split(",");
                String tip = items[0].trim();
                if (tip.equals("Customer")) {
                    firstName = items[1].trim();
                    lastName = items[2].trim();
                    customers.add(new Customer(firstName, lastName));
                }
                if (tip.equals("Account")) {
                    String accountNumber = items[1].trim();
                    double balance = Double.parseDouble(items[2].trim());
                    customers.getLast().addAccount(new BankAccount(accountNumber));
                    customers.getLast().getAccount(accountNumber).deposit(balance);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Customer customer : customers) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " accounts:");
            for (BankAccount account : customer.getAccount()) {
                System.out.println(account.toString());
            }
        }
    }
}
