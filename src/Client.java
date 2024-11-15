import helper.Helper;
import helper.PrintTypes;
import model.CourseDetails;
import model.ResearchDetails;
import model.StudentDetails;
import student.Student;
import student.Student_Course;
import student.Student_Research;
import unit.Unit_Course;
import unit.Unit_Research;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private ArrayList<Student> students = new ArrayList<>();
    private boolean isSorted = false;

    // Load student information from CSV file
    public void loadStudentDetails(URL filePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(filePath.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                StudentDetails studentDetails = new StudentDetails(data[1], data[2], Long.parseLong(data[3]));
                if (data[0].equalsIgnoreCase("c")) {
                    int[] assignments = new int[4];
                    assignments[0] = Integer.parseInt(data[6]);
                    assignments[1] = Integer.parseInt(data[7]);
                    assignments[2] = Integer.parseInt(data[8]);
                    assignments[3] = Integer.parseInt(data[9]);
                    CourseDetails courseDetails = new CourseDetails(data[4],Integer.parseInt(data[5]), assignments, Integer.parseInt(data[10]));
                    Unit_Course unitCourse = new Unit_Course(courseDetails);
                    Student_Course studentCourse = new Student_Course(studentDetails, unitCourse);
                    // Add course based student into Array List
                    students.add(studentCourse);
                } else if (data[0].equalsIgnoreCase("r")) {
                    Unit_Research unitResearch = new Unit_Research(new ResearchDetails(Integer.parseInt(data[4]), Integer.parseInt(data[5])));
                    Student_Research studentResearch = new Student_Research(studentDetails, unitResearch);
                    // Add research based student into Array List
                    students.add(studentResearch);
                }
            }
        } catch (IOException e) {
            Helper.print("Error reading file: " + e.getMessage(), PrintTypes.REMOVE);
        }
    }

    // Display menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            Helper.print("\n1. Quit", PrintTypes.DISPLAY);
            Helper.print("2. Remove student by ID", PrintTypes.DISPLAY);
            Helper.print("3. Display all students", PrintTypes.DISPLAY);
            Helper.print("4. Analyze coursework student marks", PrintTypes.DISPLAY);
            Helper.print("5. Report grade by student ID", PrintTypes.DISPLAY);
            Helper.print("6. Sort students by ID", PrintTypes.DISPLAY);
            Helper.print("7. Save sorted list to CSV", PrintTypes.DISPLAY);

            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 :
                    Helper.print("Exiting program.", PrintTypes.TITLE);
                    break;
                case 2 :
                    Helper.print("Please enter student Id", PrintTypes.TITLE);
                    String studentId = scanner.next();
                    removeStudentByID(Long.parseLong(studentId));
                    break;
                case 3 :
                    Helper.print("All Student Information: ", PrintTypes.TITLE);
                    displayAllStudent();
                    break;
                case 4 :
                    analyzeCourseWorkStudentMarks();
                    break;
                case 5 :
                    Helper.print("Please enter student Id", PrintTypes.TITLE);
                    String studentIdForReport = scanner.next();
                    getReportGradeByStudentId(Long.parseLong(studentIdForReport));
                    break;
                case 6 :
                    Helper.print("Sorting by Student Id", PrintTypes.TITLE);
                    sortByID();
                    break;
                case 7 :
                    Helper.print("Save sorted list to CSV", PrintTypes.TITLE);
                    savedSortedArray();
                    break;
                default :
                    Helper.print("Invalid choice. Please try again.", PrintTypes.TITLE);
                    break;
            }
        } while (choice != 1);
    }

    // Analyze coursework students marks
    private void analyzeCourseWorkStudentMarks() {
        double total = 0;
        int count = 0;
        int aboveAverage = 0;
        int belowAverage = 0;

        for (Student student : students) {
            if (student instanceof Student_Course) {
                Student_Course courseStudent = (Student_Course) student;
                double overallMark = courseStudent.calculateOverallMark();
                total += overallMark;
                count++;

                double average = total / count;
                if (overallMark >= average) {
                    aboveAverage++;
                } else {
                    belowAverage++;
                }
            }
        }

        Helper.print("Coursework students above average: " + aboveAverage, PrintTypes.INFO);
        Helper.print("Coursework students below average: " + belowAverage, PrintTypes.INFO);
    }
    // Case 2 remove student by ID
    private void removeStudentByID(Long studentID) {
        for (int i =0; i < students.size(); i ++) {
            Student studentToRemove = students.get(i);
            if (studentToRemove.Equals(studentID)) {
                students.remove(studentToRemove);
                Helper.print("Student ID " + studentToRemove.getStudentId() + " has been removed.", PrintTypes.REMOVE);
                break;
            }
        }
        isSorted = false;
    }
    // Case 3 Display All student
    private void displayAllStudent() {
        students.forEach(student -> {
            String enrollmentType;
            if (student instanceof Student_Course) {
                enrollmentType = "C";
            } else {
                enrollmentType = "R";
            }
            Helper.print("Enrollment: " + enrollmentType, PrintTypes.INFO);
            Helper.print("Student Id: " + student.getStudentId(), PrintTypes.INFO);
            Helper.print("Student Name: " + student.getName(), PrintTypes.INFO);
            Helper.print("---- xx ---- xx ----", PrintTypes.INFO);
        });
    }


    //Case 5: get Report Grade by Student ID
    private void getReportGradeByStudentId(Long studentId) {
        for (int i =0; i < students.size(); i ++) {
            Student studentDetail = students.get(i);
            if (studentDetail.getStudentId().equals(studentId)) {
                studentDetail.reportGrade();
                break;
            }
        }
    }
    // Case 6 Sort Student by ID
    private void sortByID() {
        students.sort((a, b) -> a.getStudentId().compareTo(b.getStudentId()));
        isSorted = true;
        this.displayAllStudent();
    }

    // Case 7 Saed sorted array to CSV
    private void savedSortedArray() {
        if (!isSorted) {
            this.sortByID();
        }
        // Get URL of the csv file
        URL path = Thread.currentThread().getContextClassLoader().getResource("csv");
        String filePath = path.getPath() + "/sorted_student.csv";
        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            students.forEach(student -> {
                StudentDetails studentDetail = student.getStudentDetails();
                if (student instanceof  Student_Course) {
                    writer.println("C," + studentDetail.firstName + "," + studentDetail.lastName + "," + studentDetail.studentID);
                } else if (student instanceof Student_Research) {
                    writer.println("R," + studentDetail.firstName + "," + studentDetail.lastName + "," + studentDetail.studentID);
                }
            });
            Helper.print("Sorted data saved into file: " + filePath, PrintTypes.TITLE);
        } catch (IOException e) {
            Helper.print("Error while writing to file: " + e.getMessage(), PrintTypes.REMOVE);
        }

    }
}