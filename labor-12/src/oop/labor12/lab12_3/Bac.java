package oop.labor12.lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bac {
    private Map<Integer, Student> students = new HashMap<>();

    public Bac(String filename){
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String elements[] = line.split(" ");
                int id = Integer.parseInt(elements[0].trim());
                String firstName = elements[1].trim();
                String lastName = elements[2].trim();
                Student student = new Student(id, firstName, lastName);
                students.put(id, student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readSubject(String subject){
        try (Scanner scanner = new Scanner(new File(subject + ".txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.isEmpty()){
                    continue;
                }
                String elements[] = line.split(" ");
                int id = Integer.parseInt(elements[0].trim());
                double grade = Double.parseDouble(elements[1].trim());
                Student student = students.get(id);
                if (student == null) {
                    System.out.println("ID DOES NOT EXIST: " + id);
                    continue;
                }
                student.addGrade(subject, grade);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void computeAverage(){
        for (Student student : students.values()) {
            student.computeAverage();
        }
    }

    public int numFailedStudent(){
        int count = 0;
        for (Student student : students.values()) {
            if (student.getAverage() == 0) {
                count++;
            }
        }
        return count;
    }

    public int passedStudents() {
        int failed = numFailedStudent();
        return students.values().size() - failed;
    }

    public int numberOfStudents() {
        return students.size();
    }

    public ArrayList<Student> studentsFailed() {
        ArrayList<Student> failedStudents = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAverage() == 0) {
                failedStudents.add(student);
            }
        }
        return failedStudents;
    }

    public void sortByAlphabeticalFailedStudents(Comparator<Student> comparator) {
        studentsFailed().sort(comparator);
    }
}
