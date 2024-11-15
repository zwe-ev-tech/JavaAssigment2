package student;

import helper.Helper;
import helper.PrintTypes;
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

    public Unit_Research getUnitResearch() {
        return unitResearch;
    }

    @Override
    public void reportGrade() {
        StudentDetails studentDetails = getStudentDetails();
        Helper.print("Enrolment Type: " + enrolmentType.name(), PrintTypes.INFO);
        Helper.print("Student Id: " + studentDetails.studentID, PrintTypes.INFO);
        Helper.print("Name: " + this.getName(), PrintTypes.INFO);
        this.unitResearch.reportFinalGrade();

    }
}
