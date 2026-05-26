package oop.labor13.lab13_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Register {
    Map<String, Person> registry = new TreeMap<>();

    public Register(String filename){
        try (Scanner scanner = new Scanner(new File(filename))) {
            boolean readingFirstList = true;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    readingFirstList = false;
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length < 2){
                    continue;
                }
                String name = parts[0];
                if (readingFirstList) {
                    Person person = new Person(name);
                    person.birthYear = Integer.parseInt(parts[1]);
                    if (parts.length == 3) {
                        person.deathYear = Integer.parseInt(parts[2]);
                    }
                    registry.put(name, person);
                } else {
                    int deathYear = Integer.parseInt(parts[1]);
                    if (registry.containsKey(name)) {
                        registry.get(name).deathYear = deathYear;
                    }
                }
            }
            for (Person person : registry.values()) {
                if (person.hasFullData()) {
                    System.out.println(person);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("A bemeneti fájl nem található! Kérlek készítsd el az input.txt fájlt.");
        } catch (NumberFormatException e) {
            System.out.println("Hiba történt az évszámok feldolgozása során: " + e.getMessage());
        }
    }
}
