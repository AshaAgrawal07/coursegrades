import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.google.gson.Gson;

import static org.junit.Assert.*;


public class CourseGraderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CourseGrader classes;
    private CourseGrader[] classesArray;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        classes = gson.fromJson(COURSE_JSON, CourseGrader.class);
        classesArray = gson.fromJSON(COURSE_JSON_ARRAY, CourseGrader[].class);
    }

    private static final String CLASSES_JSON = "  { \"CRN\": 60354, \"Subject\": " +
            "\"TE\", \"Number\": 298, \"Title\": \"Introduction to Innovation D\", " +
            "\"Section\": \"IND\", \"Type\": \"LCD\", \"Term\": 120138, \"Instructor\": " +
            "\"Bechtel, Jennifer M\", \"Grades\": [1, 15, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0]," +
            " \"Average\": 3.71 },\n";


    @Test
    public void getSubject() {
        assertEquals("TE", classes.getSubject());
    }

    @Test
    public void getNumber() {
        assertEquals(298, classes.getNumber());
    }

    @Test
    public void getTitle() {
        assertEquals("Introduction to Innovation D", classes.getTitle());
    }

    @Test
    public void getCRN() {
        assertEquals(60354, classes.getCRN());
    }

    @Test
    public void getSection() {
        assertEquals("IND", classes.getSection());
    }

    @Test
    public void getType() {
        assertEquals("LCD", classes.getType());
    }

    @Test
    public void getTerm() {
        assertEquals(120138, classes.getTerm());
    }

    @Test
    public void getInstructor() {
        assertEquals("Bechtel, Jennifer", classes.getInstructor());
    }

    @Test
    public void getAverage() {
        assertEquals(3.71, classes.getAverage());
    }

    @Test
    public void getGrades() {
        assertEquals([1, 15, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0], classes.getGrades());
    }

    //----

    private static final String CLASSES_JSON_ARRAY = "[{ \"CRN\": 41758, \"Subject\": \"AAS\", \"Number\": 100, " +
            "\"Title\": \"Intro Asian American Studies\", \"Section\": \"AD1\", \"Type\": \"DIS\", \"Term\": 120138, " +
            "\"Instructor\": \"Arai, Sayuri\", \"Grades\": [6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\":" +
            " 3.72 },\n" +
            "  { \"CRN\": 47100, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", " +
            "\"Section\": \"AD2\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Arai, Sayuri\", \"Grades\": " +
            "[6, 11, 4, 5, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.64 },\n" +
            "  { \"CRN\": 47102, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", " +
            "\"Section\": \"AD3\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Davis, Thomas E\", \"Grades\":" +
            " [2, 24, 1, 2, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.75 },\n" +
            "  { \"CRN\": 51248, \"Subject\": \"AAS\", \"Number\": 100, \"Title\": \"Intro Asian American Studies\", " +
            "\"Section\": \"AD4\", \"Type\": \"DIS\", \"Term\": 120138, \"Instructor\": \"Davis, Thomas E\", \"Grades\":" +
            " [7, 16, 4, 4, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.71 },\n]";

    @Test
    public void getSubject() {
        assertEquals("AAS", classesArray[0].getSubject());
    }

    @Test
    public void getNumber() {
        assertEquals(100, classesArray[0].getNumber());
    }

    @Test
    public void getTitle() {
        assertEquals("Intro Asian American Studies", classesArray[0].getTitle());
    }

    @Test
    public void getCRN() {
        assertEquals(41758, classesArray[0].getCRN());
    }

    @Test
    public void getSection() {
        assertEquals("AD3", classesArray[0].getSection());
    }

    @Test
    public void getType() {
        assertEquals("DIS", classesArray[0].getType());
    }

    @Test
    public void getTerm() {
        assertEquals(120138, classesArray[0].getTerm());
    }

    @Test
    public void getInstructor() {
        assertEquals("Aria, Sayuri", classesArray[0].getInstructor());
    }

    @Test
    public void getAverage() {
        assertEquals(3.72, classesArray[0].getAverage());
    }

    @Test
    public void getGrades() {
        assertEquals([6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0], classesArray[0].getGrades());
    }

    //-------------
    //tests for the getCoursesFromDept()
    //-------------

    @Test
    public void getCoursesFromDeptExists() {
        assertEquals( **fill **,CourseGrader.getCoursesFromDept("ACCY"));
    }

    @Test
    public void deptNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getCoursesFromDept(null);
    }

    @Test
    public void deptEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getCoursesFromDept("");
    }

    @Test
    public void deptDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getCoursesFromDept("DERP");
    }

    //-------------
    //tests for getProfs
    //-------------

    @Test
    public void getProfsExistsLowerCase() {
        assertEquals( **fill **,CourseGrader.getProfs("tim"));
    }

    @Test
    public void getProfsExistsUpperCase() {
        assertEquals( **fill **,CourseGrader.getProfs("Tim"));
    }

    @Test
    public void profDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getProfs("Derpity derp derp");
    }

    @Test
    public void profNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getProfs(null);
    }

    @Test
    public void profEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getProfs("");
    }

    //-------------
    //tests for getCoursesWithinRange
    //-------------

    @Test
    public void getCoursesWithinRangeExists() {
        assertEquals( **fill **,CourseGrader.getCoursesWithinRange(40, 100));
    }

    @Test
    public void getCoursesWithinRangeExistsLessThan() {
        assertEquals( **fill **,CourseGrader.getCoursesWithinRange(0, 100));
    }

    @Test
    public void getCoursesWithinRangeExistsGreaterThan() {
        assertEquals( **fill **,CourseGrader.getCoursesWithinRange(400, 0));
    }

    @Test
    public void getCoursesWithinRangeExistsEquals() {
        assertEquals( **fill **,CourseGrader.getCoursesWithinRange(400, 400));
    }

    @Test
    public void courseRangeNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getCoursesWithinRange(null, null);
    }

    @Test
    public void courseRangeMakesNoSense() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getCoursesWithinRange(400, 300);
    }

    //-------------
    //tests for coursesWithNumberOfStudents
    //-------------

    @Test
    public void getCoursesWithNumberOfStudentsExisits() {
        assertEquals( **fill **,CourseGrader.getCoursesWithNumberOfStudents(10, 40));
    }

    @Test
    public void getCoursesWithNumberOfStudentsLessThan() {
        assertEquals( **fill **,CourseGrader.getCoursesWithNumberOfStudents(0, 40));
    }

    @Test
    public void getCoursesWithNumberOfStudentsGreaterThan() {
        assertEquals( **fill **,CourseGrader.getCoursesWithNumberOfStudents(200, 0));
    }

    @Test
    public void studentRangNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getCoursesWithNumberOfStudents(null, null);
    }

    @Test
    public void studentRangeMakesNoSense() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getCoursesWithNumberOfStudents(400, 300);
    }

    @Test
    public void studentRangeDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getCoursesWithNumberOfStudents(1000, 3000);
    }

    //-------------
    //tests for mostStudents
    //-------------

    @Test
    public void getMostStudentsExists() {
        assertEquals( **fill **,CourseGrader.getMostStudents("CS"));
    }

    @Test
    public void courseWithMostStudentsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getMostStudents(null);
    }

    @Test
    public void courseWithMostStudentsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getMostStudents("");
    }

    @Test
    public void courseWithMostStudentsDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getMostStudents("DERP~~~");
    }

    //-------------
    //tests for leastStudents
    //-------------

    @Test
    public void getLeastStudentsExists() {
        assertEquals( **fill **,CourseGrader.getLeastStudents("CS"));
    }

    @Test
    public void courseWithLeatStudentsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getLeastStudents(null);
    }

    @Test
    public void courseWithLeastStudentsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.getLeastStudents("");
    }

    @Test
    public void courseWithleastStudentsDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getLeastStudents("DERP~~~");
    }

    //-------------
    //tests for totalStudentsInCourses
    //-------------

    @Test
    public void totalStudentsInCoursesIsValid() {
        assertEquals( **fill **,CourseGrader.totalStudentsInCourses( < "ACCY", "CS", "MATH" >));
    }

    @Test
    public void totalStudentsInCoursesIsValidLowerCase() {
        assertEquals( **fill **,CourseGrader.totalStudentsInCourses( < "ACCY", "Cs", "math" >));
    }

    @Test
    public void totalStudentsInCoursesDNE() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.totalStudentsInCourses( < "ACCY", "DERP", "MATH" >);
    }

    @Test
    public void totalStudentsInCoursesNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.totalStudentsInCourses( < null, "CS", "MATH" >);
    }

    @Test
    public void totalStudentsInCoursesNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.totalStudentsInCourses( < "ACCY", "", "MATH" >);
    }

    //-------------
    //tests for totalStudentsWithGrades
    //-------------

    @Test
    public void totalStudentsWithGradesExisits() {
        assertEquals( **fill **,CourseGrader.totalStudentsWithGrades("B", "A+"));
    }

    @Test
    public void gradeRangeNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.totalStudentsWithGrades(null, null);
    }

    @Test
    public void gradeRangeMakesNoSense() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.totalStudentsWithGrades("R", "L");
    }

    @Test
    public void studentRangeEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Null input");
        CourseGrader.totalStudentsWithGrades("", "");
    }

    //-------------
    //tests for avgGPA
    //-------------

    @Test
    public void avgGPA() {
        assertEquals( **fill **,CourseGrader.avgGPA());
    }
}
