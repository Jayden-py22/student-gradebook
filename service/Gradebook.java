package service;

import model.Student;

import java.util.HashMap;
import java.util.Scanner;

public class Gradebook {
    private HashMap<String, Student> students = new HashMap<>();

    public void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        if (students.containsKey(name)) {
            System.out.println("Student already exists.");
        } else {
            students.put(name, new Student(name));
            System.out.println("Student added.");
        }
    }

    public void addGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter grade (0-100): ");
        try {
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade range.");
                return;
            }
            student.addGrade(grade);
            System.out.println("Grade added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    public void viewAverage(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = students.get(name);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.printf("%s's average grade: %.2f\n", name, student.getAverage());
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students in the gradebook.");
            return;
        }
        for (Student s : students.values()) {
            System.out.printf("%s: %s (Avg: %.2f)\n", s.getName(), s.getGrades(), s.getAverage());
        }
    }

    public HashMap<String, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<String, Student> students) {
        this.students = students;
    }
}