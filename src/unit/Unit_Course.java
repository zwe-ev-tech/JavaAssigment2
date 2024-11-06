package unit;

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
        if (overallMark >= 80) return "HD";
        if (overallMark >= 70) return "D";
        if (overallMark >= 60) return "C";
        if (overallMark >= 50) return "P";
        return "N";
    }
}
