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
                if(line.startsWith("Customer: ")) {
                    System.out.println("This is a Customer");
                }else{
                    System.out.println("This is a BankAccount");
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
