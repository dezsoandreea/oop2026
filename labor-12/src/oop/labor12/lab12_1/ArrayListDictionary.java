package oop.labor12.lab12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListDictionary implements IDictionary{
    private ArrayList<String> words;
    private static ArrayListDictionary instance;

    private ArrayListDictionary() {
        this.words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(IDictionary.DICTIONARY_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] word = line.split(" ");
                words.add(word[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        if (words.contains(word)) {
            return false;
        }
        words.add(word);
        Collections.sort(words);
        return true;
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
