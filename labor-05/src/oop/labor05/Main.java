package oop.labor05;

import oop.labor02.MyDate;
import oop.labor05.model.Course;
import oop.labor05.model.Student;
import oop.labor05.model.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = readCourses("courses.csv");

        for (Course c : courses) {
            System.out.println(c);
        }
        System.out.println();

        ArrayList<Student> students = readStudents("students.csv");

        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        Random random = new Random();
        ArrayList<Training> trainings = new ArrayList<>();

        for (Course course : courses) {
            double randomPrice = 1000 + (2000 - 1000) * random.nextDouble();
            MyDate start = new MyDate(2023, 3, 21);
            MyDate end = new MyDate(2023, 3, 25);

            Training training = new Training(course, start, end, randomPrice);

            while (training.numEnrolled() < 10) {
                int randomIndex = random.nextInt(students.size());
                training.enroll(students.get(randomIndex));
            }

            trainings.add(training);
        }
        for (Training t : trainings) {
            System.out.println(t.toString());
            t.printToFile();
        }
    }

    private static ArrayList<Course> readCourses(String filename) {
        ArrayList<Course> courses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    int numHours = Integer.parseInt(parts[2].trim());
                    courses.add(new Course(name, description, numHours));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return courses;
    }

    private static ArrayList<Student> readStudents(String filename) {
        ArrayList<Student> students = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String ID = parts[0].trim();
                    String lastName = parts[1].trim();
                    String firstName = parts[2].trim();
                    students.add(new Student(ID, firstName, lastName));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }
}
