package helper;

public class Helper {

    public static String getFinalGrade(double overallMark) {
        if (overallMark >= 80) return "HD";
        if (overallMark >= 70) return "D";
        if (overallMark >= 60) return "C";
        if (overallMark >= 50) return "P";
        return "N";
    }
}
