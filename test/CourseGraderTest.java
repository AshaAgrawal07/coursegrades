import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CourseGraderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //tests for the getCoursesFromDept()
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

    //tests for getProfs

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

    //tests for getCoursesWithinRange

    @Test
    public void getCoursesWithinRange() {
    }

    @Test
    public void getCoursesWithNumberofStudents() {
    }

    @Test
    public void getMostStudents() {
    }

    @Test
    public void getLeastStudents() {
    }

    @Test
    public void totalStudentsInCourses() {
    }

    @Test
    public void totalStudentsWithGrades() {
    }

    @Test
    public void avgGPA() {
    }
}
