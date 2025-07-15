package util;

import model.Student;

import java.io.*;
import java.util.HashMap;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(HashMap<String, Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students.values()) {
                writer.write(s.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public HashMap<String, Student> loadFromFile() {
        HashMap<String, Student> loaded = new HashMap<>();
        File file = new File(fileName);
        if (!file.exists()) return loaded;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student s = Student.fromFileString(line);
                if (s != null) {
                    loaded.put(s.getName(), s);
                }
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
        return loaded;
    }
}