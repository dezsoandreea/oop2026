package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private int length;
    private double[] elements;

    public MyArray(int lenght){
        this.length = length;
        this.elements = new double[length];
    }

    public MyArray(MyArray other){
        this.length = other.length;
        this.elements = new double[length];
        System.arraycopy(other.elements, 0, this.elements, 0, length);
    }

    public MyArray(double [] array){
        this.length = array.length;
        this.elements = new double[length];
        System.arraycopy(array, 0, this.elements, 0, length);
    }

    public MyArray(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            if (scanner.hasNextInt()) {
                this.length = scanner.nextInt();
                this.elements = new double[length];
                for (int i = 0; i < length && scanner.hasNextDouble(); i++) {
                    this.elements[i] = scanner.nextDouble();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba: A fájl nem található: " + filename);
            this.length = 0;
            this.elements = new double[0];
        }
    }

    public void fillRandom(double a, double b){
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            this.elements[i] = a + (b - a) * rand.nextDouble();
        }
    }

    public double mean(){
        if (length == 0){
            return 0;
        }
        double sum = 0;
        for (double val : elements) {
            sum += val;
        }
        return sum / length;
    }

    public double stddev(){
        if (length == 0) {
            return 0;
        }
        double avg = mean();
        double sumSqDiff = 0;
        for (double val : elements) {
            sumSqDiff += Math.pow(val - avg, 2);
        }
        return Math.sqrt(sumSqDiff / length);
    }

    public void sort(){
        Arrays.sort(this.elements);
    }

    public void print(String d){
        System.out.println(d);
        for (double val : elements) {
            System.out.printf("%.2f ", val);
        }
        System.out.println();
    }
}
