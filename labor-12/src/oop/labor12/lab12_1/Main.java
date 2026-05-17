package oop.labor12.lab12_1;

public class Main {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);
        service.findWordsFile("bible.txt");
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: "+ timeElapsed /1000000);

        long startTime1 = System.nanoTime();
        DictionaryService service1 = new DictionaryService(DictionaryType.HASH_SET);
        service.findWordsFile("bible.txt");
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime - startTime;
        System.out.println("Execution time in milliseconds: "+ timeElapsed1 /1000000);

        long startTime2 = System.nanoTime();
        DictionaryService service2 = new DictionaryService(DictionaryType.TREE_SET);
        service.findWordsFile("bible.txt");
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime - startTime;
        System.out.println("Execution time in milliseconds: "+ timeElapsed2 /1000000);
    }
}
