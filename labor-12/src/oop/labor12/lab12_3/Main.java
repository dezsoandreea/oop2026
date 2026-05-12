package oop.labor12.lab12_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //proba
//        Student s1 = new Student(25661, "Kamilla", "Kis");
//        Student s2 = new Student(34547, "Amanda", "Simo");
//        Student s3 = new Student(12648, "Peter", "Szoke");
//        Student s4 = new Student(65314, "Roland", "Tamas");
//
//        s1.addGrade("roman", 6);
//        s1.addGrade("matek", 7);
//        s1.addGrade("magyar", 8);
//
//        s1.computeAverage();
//        System.out.println(s1.getID() + " atlaga: " + s1.getAverage());
//
//        s2.addGrade("roman", 6);
//        s2.addGrade("matek", 5);
//        s2.addGrade("magyar", 7);
//
//        s2.computeAverage();
//        System.out.println(s2.getID() + " atlaga: " + s2.getAverage());
//
//        s3.addGrade("roman", 5);
//        s3.addGrade("matek", 5);
//        s3.addGrade("magyar", 6);
//
//        s3.computeAverage();
//        System.out.println(s3.getID() + " atlaga: " + s3.getAverage());
//
//        s4.addGrade("roman", 4);
//        s4.addGrade("matek", 9);
//        s4.addGrade("magyar", 10);
//
//        s4.computeAverage();
//        System.out.println(s4.getID() + " atlaga: " + s4.getAverage());

        Bac bac = new Bac("nevek1.txt");
        bac.readSubject("magyar");
        bac.readSubject("matek");
        bac.readSubject("roman");
        bac.computeAverage();
        System.out.println(bac.numFailedStudent() + " students have failed the exam.");
        System.out.println(bac.passedStudents() + " students out of " + bac.numberOfStudents() + " have passed the exam.");

        System.out.println("**********************");
        bac.sortByAlphabeticalFailedStudents(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getFirstName().equals(o2.getFirstName())) {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        System.out.println("Students failed sorted alphabetically: ");
        System.out.println(bac.studentsFailed());
    }
}
