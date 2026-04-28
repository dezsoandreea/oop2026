package oop.labor10.lab10_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingDemo {
    private ArrayList<String> fruits;

    public SortingDemo(String filename) {
        fruits = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fruits.add(line);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void printFruits(){
        for(String f : fruits){
            System.out.print(f + " ");
        }
        System.out.println();
    }

    public void sortAlphabetically(){
        Collections.sort(fruits);
    }

    public void sortReverseAlphabetically(){
        Collections.sort(fruits, Collections.reverseOrder());
    }

    public void sortMyWay(){
        Collections.sort(fruits, (a, b) ->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
    }
}
