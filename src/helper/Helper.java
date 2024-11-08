package helper;

public class Helper {
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public static String getFinalGrade(double overallMark) {
        if (overallMark >= 80) return "HD";
        if (overallMark >= 70) return "D";
        if (overallMark >= 60) return "C";
        if (overallMark >= 50) return "P";
        return "N";
    }

    public static void print(String message, PrintTypes types) {
        switch (types) {
            case INFO:
                System.out.println(GREEN + message + RESET);
                break;
            case REMOVE:
                System.out.println(RED + message + RESET);
                break;
            case DISPLAY:
                System.out.println(BLUE + message + RESET);
                break;
            case TITLE:
                System.out.println(CYAN + message + RESET);
                break;
        }
    }
}
