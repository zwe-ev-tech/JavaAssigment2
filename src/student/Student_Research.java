package student;

import model.StudentDetails;
import unit.EnrolmentType;
import unit.Unit_Research;

public class Student_Research extends Student {
    // Enrolment Type
    private EnrolmentType enrolmentType = EnrolmentType.R;
    private Unit_Research unitResearch;

    public Student_Research(StudentDetails _studentDetails, Unit_Research _unitResearch) {
        super(_studentDetails);
        this.unitResearch = _unitResearch;
    }

    public double calculateOverallMark() {
        return unitResearch.calculateOverallMark();
    }

    @Override
    public void reportGrade() {
        StudentDetails studentDetails = getStudentDetails();
        System.out.println("Enrolment Type: " + enrolmentType.name());
        System.out.println("Student Id: " + studentDetails.studentID);
        System.out.println("Name: " + this.getName());
        this.unitResearch.reportFinalGrade();

    }
}
