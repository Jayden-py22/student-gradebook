package model;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return sum / (double) grades.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (int g : grades) {
            sb.append(",").append(g);
        }
        return sb.toString();
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 0) return null;
        Student student = new Student(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            try {
                student.addGrade(Integer.parseInt(parts[i]));
            } catch (NumberFormatException e) {
                // skip invalid entries
            }
        }
        return student;
    }
}