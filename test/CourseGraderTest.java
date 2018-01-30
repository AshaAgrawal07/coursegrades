import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CourseGraderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void totalStudentsInCourses() {
    }

    //-------------
    //tests for totalStudentsWithGrades
    //-------------

    @Test
    public void totalStudentsWithGrades() {
    }

    //-------------
    //tests for avgGPA
    //-------------

    @Test
    public void avgGPA() {
    }
}
