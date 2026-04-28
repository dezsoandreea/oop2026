package oop.labor10.lab10_1;

public class Main {
    public static void main(String[] args) {
        SortingDemo sortingDemo = new SortingDemo("fruits.txt");
        sortingDemo.sortAlphabetically();
        sortingDemo.printFruits();
        System.out.println("***************************");
        sortingDemo.sortReverseAlphabetically();
        sortingDemo.printFruits();

        System.out.println("***************************");
        SortingDemo words = new SortingDemo("word.txt");
        words.sortMyWay();
        words.printFruits();
    }
}
