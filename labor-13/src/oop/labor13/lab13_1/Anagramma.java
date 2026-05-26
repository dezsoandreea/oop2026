package oop.labor13.lab13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Anagramma {
    private Map<String, Set<String>> groups = new HashMap<>();

    public Anagramma(String filename){
        try(Scanner sc = new Scanner(new File(filename))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.isEmpty()) {
                    continue;
                }
                String word = line.trim();
                String key = alphabetize(word);
                Set<String> group = groups.get(key);
                if (group == null) {
                    Set<String> newGroup = new HashSet<String>();
                    newGroup.add(word);
                    groups.put(key, newGroup);
                } else{
                    group.add(word);
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public int countGroupsOfSize(int size) {
        int count = 0;
        for (Set<String> group : groups.values()){
            if (group.size() == size) {
                count++;
            }
        }
        return count;
    }

    private String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public void writeResult(String outputFilename, int result) {
        try (PrintWriter pw = new PrintWriter(new File(outputFilename))) {
            pw.println(result);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
}
