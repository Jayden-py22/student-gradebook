import model.Student;
import service.Gradebook;
import util.FileManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        FileManager fileManager = new FileManager("gradebook.txt");

        // Load existing data
        gradebook.setStudents(fileManager.loadFromFile());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Gradebook Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Student Average");
            System.out.println("4. View All Students");
            System.out.println("5. Save and Exit");

            System.out.print("Select option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    gradebook.addStudent(scanner);
                    break;
                case "2":
                    gradebook.addGrade(scanner);
                    break;
                case "3":
                    gradebook.viewAverage(scanner);
                    break;
                case "4":
                    gradebook.viewAll();
                    break;
                case "5":
                    fileManager.saveToFile(gradebook.getStudents());
                    System.out.println("Data saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}