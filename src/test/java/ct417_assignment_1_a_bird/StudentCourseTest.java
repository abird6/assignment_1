/**
 * StudentCourse test class used to test 'CourseProgramme' coupling with 'Student.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StudentCourseTest {

	// test objects
	Student student;
	CourseProgramme course;
	
	public StudentCourseTest() {

	}

	@Before
	public void setup() {
		course = new CourseProgramme("ECE", new LocalDate(2023, 9, 23), new LocalDate(2024, 5, 1));
		student = new Student(null, null, null, course, null, null);
	}
	
	// ====================== Accessor Method Testing =====================
	
	@Test
	public void testGetCourse() {
		assertSame("CourseProgramme object included in Student instance should be returned", course, student.getCourse());
	}
	
	// ====================== Mutator Method Testing =====================
	
	@Test
	public void testSetCourse() {
		CourseProgramme changeCourse = new CourseProgramme("CS", new LocalDate(2023, 9, 1), new LocalDate(2024, 5, 4));
		student.setCourse(changeCourse);
		assertSame("New CourseProgramme object should be returned from accessor method", changeCourse, student.getCourse());
	}
	
	@Test 
	public void testStudentAutoAdd() {
		CourseProgramme changeCourse = new CourseProgramme("CS", new LocalDate(2023, 9, 1), new LocalDate(2024, 5, 4));		
		student.setCourse(changeCourse);
		assertTrue("Course should automatically add the student to its list", changeCourse.getStudents().contains(student));
	}
}
