package student;

import model.StudentDetails;

public class Student {
    private StudentDetails studentDetails;

    public Student(StudentDetails _studentDetails) {
        studentDetails = _studentDetails;
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

    public boolean equals(StudentDetails _studentDetail) {
        return studentDetails.studentID.equals(_studentDetail.studentID);
    }
}
