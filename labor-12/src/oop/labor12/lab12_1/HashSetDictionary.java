package oop.labor12.lab12_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HashSetDictionary implements IDictionary{
    private HashSet<String> words = new HashSet<>();
    private static HashSetDictionary instance;

    private HashSetDictionary() {
        try (Scanner scanner = new Scanner(new File(DICTIONARY_FILE))) {
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

    public static IDictionary newInstance() {
        if (instance == null) {
            instance = new HashSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String word) {
        if (words.contains(word)) {
            return false;
        }
        words.add(word);
        return true;
    }

    @Override
    public boolean find(String word) {
        return words.contains(word);
    }

    @Override
    public int size() {
        return words.size();
    }
}
