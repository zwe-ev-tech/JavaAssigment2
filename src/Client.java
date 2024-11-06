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
    private static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Client.loadStudentDetails("C:\\Users\\Asus\\OneDrive\\Desktop\\MURDOCH\\ICT167 - PRINCIPLES OF COMP SCIENCE\\Assignments\\JavaA2\\JavaAssigment2\\src\\csv\\students.csv");
        Client.displayMenu();
    }

    // Load student information from CSV file
    private static void loadStudentDetails(String filePath) {
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
    public static void displayMenu() {
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
                    System.out.println("Please enter student Id");
                    var studentID = scanner.next();
                    System.out.println("ID: " + studentID);
                    removeStudentByID(Long.parseLong(studentID));
                    break;
                case 3 :
                    System.out.println("All Student Information: ");
                    displayAllStudent();
                    break;
                case 4 :
                    analyzeCourseWorkStudentMarks();
                    break;
                case 5 :
                    System.out.println("Report Grade by student ID");
                    break;
                case 6 :
                    System.out.println("Sorting by Student Id");
                    sortByID();
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
    private static void analyzeCourseWorkStudentMarks() {

    }
    // Case 2 remove student by ID
    private static void removeStudentByID(Long studentID) {
        students.removeIf(student -> student.getStudentId().equals(studentID));
    }
    // Case 3 Display All student
    private static void displayAllStudent() {
        students.forEach(student -> {
           String enrollmentType;
           if (student instanceof Student_Course) {
               enrollmentType = "C";
           } else {
               enrollmentType = "R";
           }
           System.out.println("Enrollment: " + enrollmentType);
           System.out.println("Student Name: " + student.getName());
        });
    }
    // Case 6 Sort Student by ID
    private static void sortByID() {
        students.sort((a, b) -> a.getStudentId().compareTo(b.getStudentId()));
    }
}