package oop.labor09.lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType dt) {
        this.dictionary = DictioanryProvider.createDictionary(dt);
    }

    public boolean findWord(String word){
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String wordFile){
        ArrayList<String> unknownWords = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(wordFile))){
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (!dictionary.find(word)) {
                    unknownWords.add(word);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return unknownWords;
    }
}
