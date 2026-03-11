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
                String[] items = line.split(", ");
                if (line.startsWith("Customer")) {
                    String firstName = items[1].trim();
                    String lastName = items[2].trim();
                    customers.add(new Customer(firstName, lastName));
                }else{
                    String accountNumber = items[1].trim();
                    int balance = Integer.parseInt(items[2].trim());
                    customers.get(customers.size()-1).addAccount(new BankAccount(accountNumber, balance));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(customers);
    }
}
