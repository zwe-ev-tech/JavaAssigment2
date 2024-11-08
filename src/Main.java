import java.net.URL;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        // Get URL of the csv file
        URL path = Thread.currentThread().getContextClassLoader().getResource("csv/students.csv");
        // Load CSV into Array List
        client.loadStudentDetails(path);
        // Display Menu
        client.displayMenu();
    }
}