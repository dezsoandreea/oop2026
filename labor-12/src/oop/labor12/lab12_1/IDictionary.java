package oop.labor12.lab12_1;

public interface IDictionary {
    public final static String DICTIONARY_FILE = "dict.txt";

    boolean add(String word);
    boolean find(String word);
    int size();
}
