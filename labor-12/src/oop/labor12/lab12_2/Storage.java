package oop.labor12.lab12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Storage {
    private Map<Integer, Product> products = new HashMap<>();

    public Storage(String datafilename){
        try(Scanner sc = new Scanner(new File(datafilename))) {
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] elements = line.split(" ");
                int id = Integer.parseInt(elements[0].trim());
                String name = elements[1].trim();
                int amount = Integer.parseInt(elements[2].trim());
                int price = Integer.parseInt(elements[3].trim());
                products.put(id, new Product(id, name, amount, price));
            }
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
                Product prod = new Product(id, "", amount, 0);
                if(!products.containsKey(prod.getID())) {
                    continue;
                }
                cnt++;
                products.get(prod.getID()).increaseAmount(amount);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cnt;
    }
}
