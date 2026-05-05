package oop.labor11.lab11_2;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args){
        String[] inputs = {"data/data10.txt", "data/data100.txt", "data/data1000.txt", "data/data10000.txt", "data/data100000.txt", "data/data1000000.txt"};
        String[] outputs = {"data/update10.txt", "data/update1000.txt", "data/update10000.txt", "data/update100000.txt", "data/update1000000.txt", "data/update10000000.txt"};
        PrintStream ps=null;
        try {
            ps = new PrintStream("measures.txt");
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        for (int i = 0; i < inputs.length; i++) {
            long start = System.currentTimeMillis();
            ps.print(inputs[i] + "\t" + outputs[i] + "\t");
            Storage storage = new Storage(inputs[i]);
            long end = System.currentTimeMillis();
            ps.print( "\t" + storage.update(outputs[i]));
            ps.println("\t" + (end - start));
        }
        ps.close();
    }
}
