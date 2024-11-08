package model;

public class CourseDetails {
    public String unitId;
    public int level;
    public int finalExam;
    public int[] assignments = new int[4];

    public CourseDetails(String _unitId, int _level, int[] _assignments, int _finalExam) {
        this.unitId = _unitId;
        this.level = _level;
        this.finalExam = _finalExam;
        this.assignments = _assignments;

    }
}
