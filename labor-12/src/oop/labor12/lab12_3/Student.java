package oop.labor12.lab12_3;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private Map<String, Double> grades = new HashMap<>();
    private double average;

    public Student(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverage() {
        return average;
    }

    public void addGrade(String subject, double grade){
        grades.put(subject, grade);
    }

    public void computeAverage(){
        double sum = 0;
        boolean hasFailedGrade = false;
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            double grade = entry.getValue();
            if (grade < 5.0) {
                hasFailedGrade = true;
            }
            sum += grade;
        }
        double avg = sum / grades.size();
        if (!hasFailedGrade && avg >= 6.0) {
            this.average = avg;
        } else {
            this.average = 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grades=" + grades +
                ", average=" + average +
                '}';
    }
}
