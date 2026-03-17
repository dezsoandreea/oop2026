package oop.labor05.model;

import oop.labor02.MyDate;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private final ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerStudent = pricePerStudent;
    }

    public Course getCourse() {
        return course;
    }

    public Student findStudentById(String id) {
        for (Student s : enrolledStudents) {
            if (s.getID().equals(id)){
                return s;
            }
        }
        return null;
    }

    public boolean enroll(Student student){
        if (findStudentById(student.getID()) == null) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public int numEnrolled() {
        return enrolledStudents.size();
    }

    public void unEnroll(String id) {
        Student studentToRemove = findStudentById(id);
        if (studentToRemove != null) {
            enrolledStudents.remove(studentToRemove);
        }
    }

    public void printToFile() {
        String filename = String.format("courseName_startdate_enddate.csv",
                course.getName(), startDate.getYear(), startDate.getMonth(), startDate.getDay(),
                endDate.getYear(), endDate.getMonth(), endDate.getDay());

        try (PrintStream out = new PrintStream(filename)) {
            for (Student s : enrolledStudents) {
                out.println(s.getID() + "," + s.getFirstName() + "," + s.getLastName());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Training{" +
                "course=" + course +
                "\n, startDate=" + startDate +
                "\n, endDate=" + endDate +
                "\n, Students=" + enrolledStudents +
                '}';
    }
}
