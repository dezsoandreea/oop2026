package oop.labor09.lab9_2;

public class DictioanryProvider {
    public static IDictionary createDictionary(DictionaryType dtype){
        IDictionary dictionary = null;
        switch( dtype ){
            case ARRAY_LIST:
                dictionary = ArrayListDictionary.newInstance();
                break;
            case HASH_SET :
                dictionary = ArrayListDictionary.newInstance();
                break;
            case TREE_SET :
                dictionary = ArrayListDictionary.newInstance();
                break;
        }
        return dictionary;
    }
}
