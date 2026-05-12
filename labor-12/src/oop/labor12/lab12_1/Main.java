package oop.labor12.lab12_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int dictionaryType = scanner.nextInt();
        switch (dictionaryType) {
            case 1: {
                long startTime = System.nanoTime();
                DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);
                service.findWordsFile("bible.txt");
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in milliseconds: "+ timeElapsed /1000000);
                break;
            }
            case 2: {
                long startTime = System.nanoTime();
                DictionaryService service = new DictionaryService(DictionaryType.HASH_SET);
                service.findWordsFile("bible.txt");
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in milliseconds: "+ timeElapsed /1000000);
                break;
            }
            case 3: {
                long startTime = System.nanoTime();
                DictionaryService service = new DictionaryService(DictionaryType.TREE_SET);
                service.findWordsFile("bible.txt");
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in milliseconds: "+ timeElapsed /1000000);
                break;
            }
        }
    }
}
