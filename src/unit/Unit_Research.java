package unit;

import helper.Helper;
import model.ResearchDetails;

public class Unit_Research extends Unit{
    private ResearchDetails researchDetails;

    public Unit_Research(ResearchDetails _researchDetails) {
        super(EnrolmentType.R);
        this.researchDetails = _researchDetails;
    }

    // Calculate overall mark
    public double calculateOverallMark() {
        return this.researchDetails.proposal * 0.4 + this.researchDetails.dissertation * 0.6;
    }

    // Show final grade
    public String getFinalGrade() {
        double overallMark = calculateOverallMark();
        return Helper.getFinalGrade(overallMark);
    }

}
