import model.StudentDetails;
import student.Student;
import student.Student_Course;
import student.Student_Research;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    // Load student information from CSV file
    public void loadStudentDetails(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                StudentDetails studentDetails = new StudentDetails(data[1], data[2], Long.parseLong(data[3]));
                if (data[0].toLowerCase().equals("c")) {
                    Student_Course studentCourse = new Student_Course(studentDetails);
                    // Add course based student into Array List
                    students.add(studentCourse);
                } else if (data[0].toLowerCase().equals("r")) {
                    Student_Research studentResearch = new Student_Research(studentDetails);
                    // Add research based student into Array List
                    students.add(studentResearch);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Display menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Quit");
            System.out.println("2. Remove student by ID");
            System.out.println("3. Display all students");
            System.out.println("4. Analyze coursework student marks");
            System.out.println("5. Report grade by student ID");
            System.out.println("6. Sort students by ID");
            System.out.println("7. Save sorted list to CSV");

            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Exiting program.");
                    break;
                case 2 :
                    System.out.println("Remove Student");
                    break;
                case 3 :
                    System.out.println("Display All Student");
                    break;
                case 4 :
                    analyzeCourseWorkStudentMarks();
                    break;
                case 5 :
                    System.out.println("Report Grade by student ID");
                    break;
                case 6 :
                    System.out.println("Sort Students by ID");
                    break;
                case 7 :
                    System.out.println("Save sorted list to CSV");
                    break;
                default :
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 1);
    }

    // Analyze coursework students marks
    private void analyzeCourseWorkStudentMarks() {

    }
}