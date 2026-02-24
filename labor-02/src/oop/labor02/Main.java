package oop.labor02;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        // 1. feladat
        /*BankAccount account1 = new BankAccount(("BT1"));
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        account1.deposit(1000);
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        boolean result = account1.withdraw(500);
        if (!result)
        {
            System.out.println("you do not have sufficient funds for this operation!");
        }
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        result = account1.withdraw(1000);
        if (!result)
        {
            System.out.println("you do not have sufficient funds for this operation!");
        }
        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
        BankAccount account2 = new BankAccount("OTP00002");
        System.out.println(account2.getAccountNumber() + ": " + account1.getBalance());
        account2.deposit(2000);
        System.out.println(account2.getAccountNumber() + ": " + account1.getBalance());*/

        // 2. feladat
        /*Rectangle rectangle1 = new Rectangle(-5, 0);
        System.out.println("length: " + rectangle1.getLength() + ", width: " + rectangle1.getWidth() + ", area: " + rectangle1.area() + ", perimeter: " + rectangle1.perimeter());
        Rectangle[] rectangles = new Rectangle[10];
        for (int i = 0; i < rectangles.length; i++)
        {
            System.out.println(rectangles[i]);
        }
        // use a random generator
        Random rand = new Random();
        //generate positive random numbers less than a bound
        for (int i = 0; i < rectangles.length; i++)
        {
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10);
            rectangles[i] = new Rectangle(length, width);
            System.out.println(i + 1 + ": length: " + rectangles[i].getLength() + ", width: " + rectangles[i].getWidth() + ", area: " + rectangles[i].area() + ", perimeter: " + rectangles[i].perimeter());
        }*/
        //3. feladat
        /*System.out.println(DateUtil.isValidDate(2000,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2000,2, 30) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 29) == false);
        System.out.println(DateUtil.isValidDate(1900,2, 28) == true);
        System.out.println(DateUtil.isValidDate(-1900,2, 28) == false);
        System.out.println(DateUtil.isValidDate(0,2, 28) == false);
        System.out.println(DateUtil.isValidDate(2021,2, 29) == false);
        System.out.println(DateUtil.isValidDate(2020,2, 29) == true);
        System.out.println(DateUtil.isValidDate(2020,1, 32) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,0, 0) == false);
        System.out.println(DateUtil.isValidDate(2020,4, 31) == false);
        System.out.println(DateUtil.isValidDate(2020,1, 31) == true);*/
        Random random = new Random();
        int invalidCount = 0;
        int targetCount = 1000;

        System.out.println("Érvényes dátumok listája:");

        for (int i = 0; i < targetCount; i++) {
            int y = random.nextInt(2100) + 1;
            int m = random.nextInt(15) + 1;
            int d = random.nextInt(35) + 1;

            try {
                MyDate date = new MyDate(y, m, d);
                System.out.println(date);
            } catch (IllegalArgumentException e) {
                invalidCount++;
            }
        }
        System.out.println("Generált érvénytelen dátumok száma: " + invalidCount);
    }
}
