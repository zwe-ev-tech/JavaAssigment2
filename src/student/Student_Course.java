package student;

import helper.Helper;
import helper.PrintTypes;
import model.StudentDetails;
import unit.EnrolmentType;
import unit.Unit_Course;

public class Student_Course extends Student {
    // Enrolment Type
    private EnrolmentType enrolmentType = EnrolmentType.C;
    private Unit_Course unitCourse;

    public Student_Course(StudentDetails _studentDetails, Unit_Course _unitCourse) {
        super(_studentDetails);
        this.unitCourse = _unitCourse;
    }

    public double calculateOverallMark() {
        return unitCourse.calculateOverallMark();
    }

    @Override
    public void reportGrade() {
        StudentDetails studentDetails = getStudentDetails();
        Helper.print("Enrolment Type: " + enrolmentType.name(), PrintTypes.INFO);
        Helper.print("Student Id: " + studentDetails.studentID, PrintTypes.INFO);
        Helper.print("Name: " + this.getName(), PrintTypes.INFO);
        unitCourse.reportFinalGrade();
    }
}
