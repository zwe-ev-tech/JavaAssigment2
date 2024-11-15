package unit;

import helper.Helper;
import helper.PrintTypes;
import model.ResearchDetails;

public class Unit_Research extends Unit{
    private ResearchDetails researchDetails;

    public Unit_Research(ResearchDetails _researchDetails) {
        super(EnrolmentType.R);
        this.researchDetails = _researchDetails;
    }

    public ResearchDetails getResearchDetails() {
        return researchDetails;
    }

    // Calculate overall mark
    public double calculateOverallMark() {
        return this.researchDetails.proposal * 0.4 + this.researchDetails.dissertation * 0.6;
    }

    // Show final grade
    private String getFinalGrade() {
        double overallMark = calculateOverallMark();
        return Helper.getFinalGrade(overallMark);
    }

    @Override
    public void reportFinalGrade() {
        String finalGrade = getFinalGrade();
        Helper.print("Proposal: " + this.researchDetails.proposal, PrintTypes.INFO);
        Helper.print("Dissertation: " + this.researchDetails.dissertation, PrintTypes.INFO);
        Helper.print("Final Grade: " + finalGrade, PrintTypes.INFO);
    }

}
