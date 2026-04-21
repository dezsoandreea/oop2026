package oop.labor09.lab9_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary{
    private ArrayList<String> words;
    private static ArrayListDictionary instance;

    public ArrayListDictionary() {
        this.words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(IDictionary.DICTIONARY_FILE))) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().trim());
            }
            //Collections.sort(words);
        } catch (Exception e) {
            System.out.println("Hiba a fajl beolvasasakor: " + e.getMessage());
        }
    }

    public static IDictionary newInstance(){
        if (instance == null) {
            instance = new ArrayListDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String word) {
        if (!find(word)) {
            words.add(word);
            Collections.sort(words);
            return true;
        }
        return false;
    }

    @Override
    public boolean find(String word) {
        return Collections.binarySearch(words, word) >= 0;
    }

    @Override
    public int size() {
        return words.size();
    }
}
