/**
 * StudentCourse test class used to test 'CourseProgramme' coupling with 'Student.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentCourseTest {

	// test objects
	Student student;
	CourseProgramme course;
	
	@BeforeEach
	void setup() {
		course = new CourseProgramme("ECE", null, null, null, null);
		student = new Student(null, null, null, course, null, null);
	}
	
	// ====================== Accessor Method Testing =====================
	
	@Test
	@DisplayName("Test accessor for CourseProgramme object")
	void testGetCourse() {
		assertSame(course, student.getCourse(), "CourseProgramme object included in Student instance should be returned");
	}
	
	// ====================== Mutator Method Testing =====================
	
	@Test
	@DisplayName("Test mutator for CourseProgramme object")
	void testSetCourse() {
		CourseProgramme changeCourse = new CourseProgramme("CS", null, null, null, null);
		student.setCourse(changeCourse);
		assertSame(changeCourse, student.getCourse(), "New CourseProgramme object should be returned from accessor method");
	}

}
