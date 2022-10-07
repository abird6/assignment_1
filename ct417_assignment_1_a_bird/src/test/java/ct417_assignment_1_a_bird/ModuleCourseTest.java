/**
 * ModuleCourse test class used to test 'CourseProgramme' coupling with 'Module.java'
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

class ModuleCourseTest {

	// test objects
	Module module;
	List<CourseProgramme> courses;
	CourseProgramme sampleCourse;
	
	@BeforeEach
	void setup() {
		courses = new ArrayList<CourseProgramme>();
		module = new Module("CT417", "Software Engineering III", null, courses, null);
		
		sampleCourse = new CourseProgramme("ECE", null, null, new LocalDate(2022, 9, 23), new LocalDate(2023, 5, 10));
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for courses")
	void testGetCourse() {
		assertEquals(courses, module.getCourses(), "Module has list of CourseProgramme objects defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding courses")
	void testAddCourse() {
		module.addCourse(sampleCourse);
		assertTrue("CourseProgramme list should now contain sample CourseProgramme", courses.contains(sampleCourse));
	}
	
	@Test
	@DisplayName("Test mutator for removing courses")
	void testRemoveCourse() {
		module.addCourse(sampleCourse);
		module.removeCourse(sampleCourse);
		assertFalse("CourseProgramme list should not contain sample CourseProgramme", courses.contains(sampleCourse));
	}

}
