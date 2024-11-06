package model;

public class StudentDetails {
    public String firstName;
    public String lastName;
    public Long studentID;

    public StudentDetails(String _firstName, String _lastName, Long _studentID) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.studentID = _studentID;
    }
}
