import java.util.ArrayList;

public class CourseGrader {

    private int crn;
    private String subject;
    private int number;
    private String title;
    private String section;
    private String type;
    private String term;
    private ArrayList<Integer> gradesRecieved;
    private String prof;
    private double average;

    //getMethods for parsing

    public int getCrn() {
        return crn;
    }

    public String getSubject() {
        return subject;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getType() {
        return type;
    }

    public String getTerm() {
        return term;
    }

    public ArrayList<Integer> getGradesRecieved() {
        return gradesRecieved;
    }

    public String getProf() {
        return prof;
    }

    public double getAverage() {
        return average;
    }


    //filtering methods

    /**
     *
     * @param dept the department or course subject that we are looking in
     * @return tan Arraylist of the names of the courses in the given department
     */
    public ArrayList<String> getCoursesFromDept(String dept) {
        ArrayList<String> coursesFromDept = new ArrayList<String>();
        return coursesFromDept;
    }

    /**
     *
     * @param prof a string with part of a name
     * @return an ArrayList of professor names with the given String in it
     */
    public ArrayList<String> getProfs(String prof) {
        ArrayList<String> profs = new ArrayList<String>();
        return profs;
    }

    /**
     *
     * @param lowerBound the lowest inclusive numerical identifier for a course
     * @param upperBound the highest inclusive numerical identifier for a course
     *                   if upperBound is lower than lowerBound, then there will be an invalid input error
     *                   if upperBound is 0, but there is a lowerBound, then I will consider it as "greater than given lowerBound"
     * @return an ArrayList of courses that are within the specified range
     */
    public ArrayList<String> getCoursesWithinRange(int lowerBound, int upperBound) {
        ArrayList<String> coursesInRange = new ArrayList<String>();
        return coursesInRange;
    }

    /**
     *
     * @param lowerBound the lowest inclusive number of students in any course
     * @param upperBound the highest inclusive number of students in any course
     *                   if upperBound is less than lowerBound, then there will be an invalid input error
     *                   if upperBound is 0, but there is a lowerBound, then I will consider it as "greater than given lowerBound"
     * @return an ArrayList of courses that meet the bounds
     */
    public ArrayList<String> getCoursesWithNumberOfStudents(int lowerBound, int upperBound) {
        ArrayList<String> coursesWithStudents = new ArrayList<String>();
        return coursesWithStudents;
    }

    /**
     *
     * @param course the course we want to search through
     * @return the most number of students the given course ever had
     */
    public ArrayList<Integer> getMostStudents(String course) {
        ArrayList<Integer> mostStudents = new ArrayList<Integer>();
        return mostStudents;
    }

    /**
     *
     * @param course the course we want to search through
     * @return the least number of students the given course ever had
     */
    public ArrayList<Integer> getLeastStudents(String course) {
        ArrayList<Integer> leastStudents = new ArrayList<Integer>();
        return leastStudents;
    }

    //aggregation methods

    /**
     *
     * @param courses the collection of classes that we are searching through
     * @return the total number of students that have taken the collection of classes
     */
    public int totalStudentsInCourses (ArrayList<String> courses) {
        int total = 0;
        return total;
    }

    /**
     *
     * @param lowerBound the inclusive lowerBound of the grade
     * @param upperBound the inclusive upperBound of the grade
     *                   if upperBound is lower than the lowerBound, then there will be an invalid input error
     * @return the total number of students within the grade ranges
     */
    public int totalStudentsWithGrades (String lowerBound, String upperBound) {
        int total = 0;
        return total;
    }

    /**
     *
     * @return the average GPA of the students per class
     */
    public ArrayList<double> avgGPA () {
        ArrayList<Double> averages = new ArrayList<String>();
        return averages;
    }
}
