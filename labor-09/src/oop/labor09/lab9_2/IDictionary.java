package oop.labor09.lab9_2;

public interface IDictionary {
    public final static String DICTIONARY_FILE = "dict.txt";

    boolean add(String word);
    boolean find(String word);
    int size();
}
