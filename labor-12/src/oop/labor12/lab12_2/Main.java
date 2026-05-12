package oop.labor12.lab12_2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args){
        String[] inputs = {"data/data10.txt", "data/data100.txt", "data/data1000.txt", "data/data10000.txt", "data/data100000.txt", "data/data1000000.txt"};
        String[] outputs = {"data/update10.txt", "data/update1000.txt", "data/update10000.txt", "data/update100000.txt", "data/update1000000.txt", "data/update10000000.txt"};
        PrintStream ps;
        try {
            ps = new PrintStream("measures1.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < inputs.length; i++) {
            long start = System.nanoTime();
            ps.print(inputs[i] + "\t" + outputs[i] + "\t");
            Storage storage = new Storage(inputs[i]);
            long end = System.nanoTime();
            ps.print( "\t" + storage.update(outputs[i]));
            ps.println("\t" + (end - start));
        }
    }
}
