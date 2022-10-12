/**
 * CourseStudent test class used to test 'Student' coupling with 'CourseProgramme.java'
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class CourseStudentTest {

	// test objects
	CourseProgramme course;
	List<Student> students;
	Student sampleStudent;
	
	public CourseStudentTest() {

	}

	@Before
	public void setup() {
		students = new ArrayList<Student>();
		course = new CourseProgramme("ECE", new LocalDate(2023, 9, 2), new LocalDate(2024, 5, 1), students);
		sampleStudent = new Student("19357176", "Anthony Bird", "21", new LocalDate(2000, 10, 10));
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing CourseProgramme.getStudents()
	public void testGetStudents() {
		assertEquals("CourseProgramme has list of students defined in setup()", students, course.getStudents());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing CourseProgramme.addStudent()
	public void testAddStudent() {
		course.addStudent(sampleStudent);
		assertTrue("Student list should now contain sample Student", students.contains(sampleStudent));
	}
	
	@Test // testing CourseProgramme.addStudent() w/ duplicate entry
	public void testDuplicateAddStudent() {
		course.addStudent(sampleStudent);
		course.addStudent(sampleStudent);
		int count = 0;
		for( Student s : course.getStudents() ) {
			if( s == sampleStudent )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}
	
	@Test // testing CourseProgramme.removeStudent()
	public void testRemoveStudent() {
		course.addStudent(sampleStudent);
		course.removeStudent(sampleStudent);
		assertFalse("Student list should not contain sample Student", students.contains(sampleStudent));
	}
}
