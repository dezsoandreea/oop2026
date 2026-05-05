package oop.labor11.lab11_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Storage {
    private ArrayList<Product> products = new ArrayList<>();

    public Storage(String datafilename){
        try(Scanner sc = new Scanner(new File(datafilename))) {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(" ");
                int id = Integer.parseInt(elements[0].trim());
                String name = elements[1].trim();
                int amount = Integer.parseInt(elements[2].trim());
                int price = Integer.parseInt(elements[3].trim());
                products.add(new Product(id, name, amount, price));
            }
            Collections.sort(products);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public int update(String updatefilename){
        int cnt = 0;
        try (Scanner sc = new Scanner(new File(updatefilename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elements = line.split(" ");
                int id = Integer.parseInt(elements[0].trim());
                int amount = Integer.parseInt(elements[1].trim());
                int result = Collections.binarySearch(products, new Product(id, "", 0, 0));
                if(result < 0) {
                    continue;
                }
                cnt++;
                products.get(result).increaseAmount(amount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cnt;
    }
}
