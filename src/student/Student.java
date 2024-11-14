package student;

import model.StudentDetails;

public class Student {
    private StudentDetails studentDetails;

    public Student(StudentDetails _studentDetails) {
        studentDetails = _studentDetails;
    }

    public Long getStudentId() {
        return this.studentDetails.studentID;
    }

    // Getters
    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public String getName() {
        return this.studentDetails.firstName + " " + this.studentDetails.lastName;
    }

    // Method to report grade
    public void reportGrade() {
        System.out.println("There is no grade here.");
    }

    public boolean Equals(Long _studentID) {
        return studentDetails.studentID.equals(_studentID);
    }
}
