package oop.labor11.lab11_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
//        System.out.println(readFirstLine("path.txt"));
//        System.out.println(readFirstLine("lab4_1_input.csv"));
//        System.out.println(readFirstLine("alma.txt"));

        //2
//        int a, b;
//        a=14;
//        b=7;
//        try {
//            System.out.println(a + "/" + b + " = " + safeDivide(a, b));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        b=0;
//        try {
//            System.out.println(a + "/" + b + " = " + safeDivide(a, b));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        //3
//        demonstrateFinally();

        //4
        BankAccount b1 = new BankAccount(500);
        System.out.println("b1: " + b1.getBalance());
        try {
            b1.withdraw(200);
        } catch (InsufficientFundsExeption e) {
            System.out.println(e.getMessage());
        }
        System.out.println(b1.getBalance());

        BankAccount b2 = new BankAccount(1000);
        System.out.println("b2: " + b2.getBalance());
        try {
            b2.withdraw(1000);
        } catch (InsufficientFundsExeption e) {
            System.out.println(e.getMessage());
        }
        System.out.println(b2.getBalance());

        BankAccount b3 = new BankAccount(200);
        System.out.println("b3: " + b3.getBalance());
        try {
            b3.withdraw(400);
        } catch (InsufficientFundsExeption e) {
            System.out.println(e.getMessage());
        }
        System.out.println(b3.getBalance());

    }

    //1
    public static String readFirstLine(String path){
        try(Scanner sc = new Scanner(new File(path))){
            if(sc.hasNextLine()){
                return sc.nextLine();
            }
            return "Empty File";
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return "FILE_NOT_FOUND";
        }
    }

    //2
    public static int safeDivide(int a, int b) throws Exception {
        if(b == 0){
            throw new Exception("DIVISION_BY_ZERO");
        }
        return a/b;
    }

    //3
    public static void demonstrateFinally(){
        try{
            System.out.println("Eroforras megnyitasa");
            throw new RuntimeException("Futasideju hiba");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Ez mindig lefut");
        }
    }
}
