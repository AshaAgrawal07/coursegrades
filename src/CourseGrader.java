import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class CourseGrader {

    @SerializedName("CRN")
    private int CRN;

    @SerializedName("Subject")
    private String Subject;

    @SerializedName("Number")
    private int Number;

    @SerializedName("Title")
    private String Title;

    @SerializedName("Section")
    private String Section;

    @SerializedName("Type")
    private String Type;

    @SerializedName("Term")
    private String Term;

    @SerializedName("Grades")
    private int[] Grades;

    @SerializedName("Instructor")
    private String Instructor;

    @SerializedName("Average")
    private double Average;


    //getMethods for parsing

    @SerializedName("CRN")
    public int getCRN() {
        return CRN;
    }

    public java.lang.String getSubject() {
        return Subject;
    }

    public int getNumber() {
        return Number;
    }

    public java.lang.String getTitle() {
        return Title;
    }

    public java.lang.String getSection() {
        return Section;
    }

    public java.lang.String getType() {
        return Type;
    }

    public java.lang.String getTerm() {
        return Term;
    }

    public int[] getGrades() {
        return Grades;
    }

    public java.lang.String getInstructor() {
        return Instructor;
    }

    public double getAverage() {
        return Average;
    }


    //method for part 2

    public static ArrayList<CourseGrader> convertToList() {
        List<String> files = Data.getJsonFilesAsList();
        ArrayList<CourseGrader> filesIntoObjects = new ArrayList<CourseGrader>();

        for (String filename : files) {
            Gson gson = new Gson();
            String str = Data.getFileContentsAsString(filename);
            filesIntoObjects.addAll(Arrays.asList(gson.fromJson(str, CourseGrader[].class)));
        }
        return filesIntoObjects;
    }

    //filtering methods

    /**
     *
     * @param dept the department or course subject that we are looking in
     * @return tan Arraylist of the names of the courses in the given department
     */
    public ArrayList<String> getCoursesFromDept(String dept) {
        ArrayList<String> coursesFromDept = new ArrayList<String>();
        if (dept == null || dept.toUpperCase().trim() == "") {
            throw new IllegalArgumentException("Null input");
        }

        //for (int i = 0; i <)

        if (coursesFromDept.size() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
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
     *                   if upperBound is 0, but there is a lowerBound, then I will consider it as "greater than given
     *                      lowerBound"
     * @return an ArrayList of courses that are within the specified range
     */
    public ArrayList<String> getCoursesWithinRange(int lowerBound, int upperBound) {
        ArrayList<String> coursesInRange = new ArrayList<String>();

        if (lowerBound > upperBound && upperBound != 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return coursesInRange;
    }

    /**
     *
     * @param lowerBound the lowest inclusive number of students in any course
     * @param upperBound the highest inclusive number of students in any course
     *                   if upperBound is less than lowerBound, then there will be an invalid input error
     *                   if upperBound is 0, but there is a lowerBound, then I will consider it as "greater than given
     *                      lowerBound"
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

        /*for(int i = 0; i < courseObjects.size; i++) {
            if(courseObjects.get(i).getGrade()) {

            }
        }*/
        return total;
    }

    /**
     *
     * @return the average GPA of the students per class
     */
    public ArrayList<Double> avgGPA () {
        ArrayList<Double> averages = new ArrayList<Double>();
        return averages;
    }
}
