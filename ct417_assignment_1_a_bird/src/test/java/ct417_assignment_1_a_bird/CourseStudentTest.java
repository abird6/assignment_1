/**
 * CourseStudent test class used to test 'Student' coupling with 'CourseProgramme.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseStudentTest {

	// test objects
	CourseProgramme course;
	List<Student> students;
	List<Module> sampleModules;
	Student sampleStudent;
	
	@BeforeEach
	void setup() {
		students = new ArrayList<Student>();
		sampleModules = new ArrayList<Module>();
		course = new CourseProgramme(null, sampleModules, students, null, null);
		
		sampleStudent = new Student("19357176", "Anthony Bird", "21", null, new LocalDate(2000, 10, 10), null);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for students")
	void testGetStudents() {
		assertEquals(students, course.getStudents(), "CourseProgramme has list of students defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding students")
	void testAddStudent() {
		course.addStudent(sampleStudent);
		assertTrue("Student list should now contain sample Student", students.contains(sampleStudent));
	}
	
	@Test
	@DisplayName("Duplicate entry test")
	void testDuplicateAddStudent() {
		course.addStudent(sampleStudent);
		course.addStudent(sampleStudent);
		int count = 0;
		for( Student s : course.getStudents() ) {
			if( s == sampleStudent )
				count++;
		}
		assertEquals(1, count, "count should be 1 to show no duplicate entries");
	}
	
	@Test
	@DisplayName("Test mutator for removing students")
	void testRemoveStudent() {
		course.addStudent(sampleStudent);
		course.removeStudent(sampleStudent);
		assertFalse("Student list should not contain sample Student", students.contains(sampleStudent));
	}

}
