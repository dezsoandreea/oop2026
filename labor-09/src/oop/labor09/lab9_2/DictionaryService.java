package oop.labor09.lab9_2;

import java.util.ArrayList;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType dt) {
        this.dictionary = DictioanryProvider.createDictionary(dt);
    }

    public boolean findWord(String word){
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String wordFile){
        return new ArrayList<String>();
    }
}
