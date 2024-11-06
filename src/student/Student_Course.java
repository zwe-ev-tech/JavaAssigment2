package student;

import model.StudentDetails;
import unit.EnrolmentType;

public class Student_Course extends Student {
    // Enrolment Type
    private EnrolmentType enrolmentType = EnrolmentType.C;

    public Student_Course(StudentDetails _studentDetails) {
        super(_studentDetails);
    }

    @Override
    public void reportGrade() {
        StudentDetails studentDetails = getStudentDetails();
        System.out.println("Enrolment Type: " + enrolmentType.name());
        System.out.println("Student Id: " + studentDetails.studentID);
        System.out.println("Name: " + this.getName());
    }
}
