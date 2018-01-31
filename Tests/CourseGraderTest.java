import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CourseGraderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    private CourseGrader classes;
    private CourseGrader[] classesArray;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        classes = gson.fromJson(CLASSES_JSON, CourseGrader.class);
        classesArray = gson.fromJson(CLASSES_JSON_ARRAY, CourseGrader[].class);
    }

    private static final String CLASSES_JSON = "  { \"CRN\": 60354, \"Subject\": " +
            "\"TE\", \"Number\": 298, \"Title\": \"Introduction to Innovation D\", " +
            "\"Section\": \"IND\", \"Type\": \"LCD\", \"Term\": 120138, \"Instructor\": " +
            "\"Bechtel, Jennifer M\", \"Grades\": [1, 15, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0]," +
            " \"Average\": 3.71 }\n";


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
        assertEquals("120138", classes.getTerm());
    }

    @Test
    public void getInstructor() {
        assertEquals("Bechtel, Jennifer M", classes.getInstructor());
    }

    @Test
    public void getAverage() {
        assertEquals(3.71, classes.getAverage(), 0);
    }

    @Test
    public void getGrades() {
        int[] grades = {1, 15, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        assertArrayEquals(grades, classes.getGrades());
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
            " [7, 16, 4, 4, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0], \"Average\": 3.71 }\n]";

    @Test
    public void getSubjectArray() {
        assertEquals("AAS", classesArray[0].getSubject());
    }

    @Test
    public void getNumberArray() {
        assertEquals(100, classesArray[0].getNumber());
    }

    @Test
    public void getTitleArray() {
        assertEquals("Intro Asian American Studies", classesArray[0].getTitle());
    }

    @Test
    public void getCRNArray() {
        assertEquals(41758, classesArray[0].getCRN());
    }

    @Test
    public void getSectionArray() {
        assertEquals("AD1", classesArray[0].getSection());
    }

    @Test
    public void getTypeArray() {
        assertEquals("DIS", classesArray[0].getType());
    }

    @Test
    public void getTermArray() {
        assertEquals("120138", classesArray[0].getTerm());
    }

    @Test
    public void getInstructorArray() {
        assertEquals("Arai, Sayuri", classesArray[0].getInstructor());
    }

    @Test
    public void getAverageArray() {
        assertEquals(3.72, classesArray[0].getAverage(), 0);
    }

    @Test
    public void getGradesArray() {
        int[] grades = {6, 16, 5, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(grades, classesArray[0].getGrades());
    }

    //PART TWO TESTING

    @Test
    public void sizeFits() {
        assertEquals(2586 + 2538 + 2273 + 2236 + 186 + 175, CourseGrader.convertToList().size());
    }

    //FILTERING TESTS BEGIN

    //-------------
    //tests for the getCoursesFromDept()
    //-------------

    @Test
    public void getCoursesFromDeptExists() {
        assertEquals(7 + 7 + 4 + 9, CourseGrader.getCoursesFromDept("AAS"));
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
        assertEquals(17 + 18 + 19 + 12, CourseGrader.getProfs("tim"));
    }

    @Test
    public void getProfsExistsUpperCase() {
        assertEquals(17 + 18 + 19 + 12, CourseGrader.getProfs("Tim"));
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
        ArrayList<String> coursesInRange = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int courseNum = CourseGrader.convertToList().get(i).getNumber();
            if (courseNum <= 100 && courseNum >= 40) {
                coursesInRange.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesInRange, CourseGrader.getCoursesWithinRange(40, 100));
    }

    @Test
    public void getCoursesWithinRangeExistsLessThan() {
        ArrayList<String> coursesInRange = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int courseNum = CourseGrader.convertToList().get(i).getNumber();
            if (courseNum <= 100 && courseNum >= 0) {
                coursesInRange.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesInRange, CourseGrader.getCoursesWithinRange(0, 100));
    }

    @Test
    public void getCoursesWithinRangeExistsGreaterThan() {
        ArrayList<String> coursesInRange = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int courseNum = CourseGrader.convertToList().get(i).getNumber();
            if (courseNum <= 400) {
                coursesInRange.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesInRange, CourseGrader.getCoursesWithinRange(400, 0));
    }

    @Test
    public void getCoursesWithinRangeExistsEquals() {
        ArrayList<String> coursesInRange = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int courseNum = CourseGrader.convertToList().get(i).getNumber();
            if (courseNum == 40) {
                coursesInRange.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesInRange, CourseGrader.getCoursesWithinRange(400, 400));
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
        ArrayList<String> coursesWithStudents = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int[] gradesDistribution = CourseGrader.convertToList().get(i).getGrades();
            int totalStudents = 0;
            for (int j = 0; j < gradesDistribution.length; j++) {
                totalStudents += gradesDistribution[j];
            }
            if (totalStudents <= 40 && totalStudents >= 10) {
                coursesWithStudents.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesWithStudents, CourseGrader.getCoursesWithNumberOfStudents(10, 40));
    }

    @Test
    public void getCoursesWithNumberOfStudentsLessThan() {
        ArrayList<String> coursesWithStudents = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int[] gradesDistribution = CourseGrader.convertToList().get(i).getGrades();
            int totalStudents = 0;
            for (int j = 0; j < gradesDistribution.length; j++) {
                totalStudents += gradesDistribution[j];
            }
            if (totalStudents <= 40 && totalStudents >= 0) {
                coursesWithStudents.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesWithStudents, CourseGrader.getCoursesWithNumberOfStudents(0, 40));
    }

    @Test
    public void getCoursesWithNumberOfStudentsGreaterThan() {
        ArrayList<String> coursesWithStudents = new ArrayList<String>();

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            int[] gradesDistribution = CourseGrader.convertToList().get(i).getGrades();
            int totalStudents = 0;
            for (int j = 0; j < gradesDistribution.length; j++) {
                totalStudents += gradesDistribution[j];
            }
            if (totalStudents <= 200) {
                coursesWithStudents.add(CourseGrader.convertToList().get(i).getTitle());
            }
        }
        assertEquals(coursesWithStudents, CourseGrader.getCoursesWithNumberOfStudents(200, 0));
    }

    @Test
    public void studentRangeMakesNoSense() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        CourseGrader.getCoursesWithNumberOfStudents(400, 300);
    }

    //-------------
    //tests for mostStudents
    //-------------

    @Test
    public void getMostStudentsExists() {
        int mostStudents = 0;

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            if (CourseGrader.convertToList().get(i).getSubject().toUpperCase().equals("CS")) {
                //get the grade distribution and then find the total number of students in the course
                int[] gradesDistribution = CourseGrader.convertToList().get(i).getGrades();
                int totalStudents = 0;
                for (int j = 0; j < gradesDistribution.length; j++) {
                    totalStudents += gradesDistribution[j];
                }
                //reset the most number of students in the course if need be
                if (totalStudents > mostStudents) {
                    mostStudents = totalStudents;
                }
            }
        }
        assertEquals(mostStudents, CourseGrader.getMostStudents("CS"));
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


    //-------------
    //tests for leastStudents
    //-------------

    @Test
    public void getLeastStudentsExists() {
        int leastStudents = 0;

        for (int i = 0; i < CourseGrader.convertToList().size(); i++) {
            if (CourseGrader.convertToList().get(i).getSubject().toUpperCase().equals("CS")) {
                //get the grade distribution and then find the total number of students in the course
                int[] gradesDistribution = CourseGrader.convertToList().get(i).getGrades();
                int totalStudents = 0;
                for (int j = 0; j < gradesDistribution.length; j++) {
                    totalStudents += gradesDistribution[j];
                }
                //reset the most number of students in the course if need be
                if (totalStudents < leastStudents) {
                    leastStudents = totalStudents;
                }
            }
        }
        assertEquals(leastStudents, CourseGrader.getLeastStudents("CS"));
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

/**
 //-------------
 //tests for totalStudentsInCourses
 //-------------

 @Test public void totalStudentsInCoursesIsValid() {
 assertEquals( **fill **,CourseGrader.totalStudentsInCourses( < "ACCY", "CS", "MATH" >));
 }

 @Test public void totalStudentsInCoursesIsValidLowerCase() {
 assertEquals( **fill **,CourseGrader.totalStudentsInCourses( < "ACCY", "Cs", "math" >));
 }

 @Test public void totalStudentsInCoursesDNE() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Invalid input");
 CourseGrader.totalStudentsInCourses( < "ACCY", "DERP", "MATH" >);
 }

 @Test public void totalStudentsInCoursesNull() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Null input");
 CourseGrader.totalStudentsInCourses( < null, "CS", "MATH" >);
 }

 @Test public void totalStudentsInCoursesNull() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Null input");
 CourseGrader.totalStudentsInCourses( < "ACCY", "", "MATH" >);
 }

 //-------------
 //tests for totalStudentsWithGrades
 //-------------

 @Test public void totalStudentsWithGradesExisits() {
 assertEquals( **fill **,CourseGrader.totalStudentsWithGrades("B", "A+"));
 }

 @Test public void gradeRangeNull() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Null input");
 CourseGrader.totalStudentsWithGrades(null, null);
 }

 @Test public void gradeRangeMakesNoSense() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Invalid input");
 CourseGrader.totalStudentsWithGrades("R", "L");
 }

 @Test public void studentRangeEmpty() {
 thrown.expect(IllegalArgumentException.class);
 thrown.expectMessage("Null input");
 CourseGrader.totalStudentsWithGrades("", "");
 }

 //-------------
 //tests for avgGPA
 //-------------

 @Test public void avgGPA() {
 assertEquals( 4.0,CourseGrader.avgGPA());
 }
 */
}
