/**
 * StudentCourse test class used to test 'CourseProgramme' coupling with 'Student.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentCourseTest {

	// test objects
	Student student;
	CourseProgramme course;
	List<Student> sampleStudents;
	List<Module> sampleModules;
	
	@BeforeEach
	void setup() {
		sampleStudents = new ArrayList<Student>();
		sampleModules = new ArrayList<Module>();
		course = new CourseProgramme(null, sampleModules, sampleStudents, null, null);
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
		List<Student> changeStudents = new ArrayList<Student>();
		List<Module> changeModules = new ArrayList<Module>();
		CourseProgramme changeCourse = new CourseProgramme(null, changeModules, changeStudents, null, null);
		student.setCourse(changeCourse);
		assertSame(changeCourse, student.getCourse(), "New CourseProgramme object should be returned from accessor method");
	}
	
	@Test 
	@DisplayName("Test student added to course object automatically")
	void testStudentAutoAdd() {
		List<Student> changeStudents = new ArrayList<Student>();
		List<Module> changeModules = new ArrayList<Module>();
		CourseProgramme changeCourse = new CourseProgramme(null, changeModules, changeStudents, null, null);		
		student.setCourse(changeCourse);
		assertTrue("Course should automatically add the student to its list", changeCourse.getStudents().contains(student));
	}
}
