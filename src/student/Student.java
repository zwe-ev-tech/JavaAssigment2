package student;

import helper.Helper;
import helper.PrintTypes;
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
        Helper.print("There is no grade here.", PrintTypes.INFO);
    }

    public boolean Equals(Long _studentID) {
        return studentDetails.studentID.equals(_studentID);
    }
}
