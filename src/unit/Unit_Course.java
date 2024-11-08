package unit;

import helper.Helper;
import helper.PrintTypes;
import model.CourseDetails;

public class Unit_Course extends Unit{
    private CourseDetails courseDetails;

    public Unit_Course(CourseDetails _courseDetails) {
        super(EnrolmentType.C);
        this.courseDetails = _courseDetails;
    }

    public void setAssignments(int[] assignmentMarks) {
        this.courseDetails.assignments = assignmentMarks;
    }

    public void setFinalExam(int examMark) {
        this.courseDetails.finalExam = examMark;
    }

    // Calculate overall mark
    public double calculateOverallMark() {
        double overallMark = 0;
        for (int mark : this.courseDetails.assignments) overallMark += mark;
        return (overallMark / 4) * 0.6 + this.courseDetails.finalExam * 0.4;
    }

    // Show final grade
    public String getFinalGrade() {
        double overallMark = calculateOverallMark();
        return Helper.getFinalGrade(overallMark);
    }

    @Override
    public void reportFinalGrade() {
        int i = 1;
        for(int assigment : this.courseDetails.assignments) {
            Helper.print("Assigment " + i + ": " + assigment, PrintTypes.INFO);
            i++;
        }
        Helper.print("Final Exam: " + this.courseDetails.finalExam, PrintTypes.INFO);
        String finalGrade = this.getFinalGrade();
        Helper.print("Final Grade: " + finalGrade, PrintTypes.INFO);
    }
}
