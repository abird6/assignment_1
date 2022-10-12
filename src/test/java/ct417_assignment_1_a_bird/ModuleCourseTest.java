/**
 * ModuleCourse test class used to test 'CourseProgramme' coupling with 'Module.java'
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

public class ModuleCourseTest {

	// test objects
	Module module;
	List<CourseProgramme> courses;
	CourseProgramme sampleCourse;
	
	public ModuleCourseTest() {

	}

	@Before
	public void setup() {
		courses = new ArrayList<CourseProgramme>();
		module = new Module("CT417", "Software Engineering III", null, courses, null);
		sampleCourse = new CourseProgramme("ECE", new LocalDate(2022, 9, 23), new LocalDate(2023, 5, 10));
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing Module.getCourses()
	public void testGetCourse() {
		assertEquals("Module has list of CourseProgramme objects defined in setup()", courses, module.getCourses());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing Module.addCourse()
	public void testAddCourse() {
		module.addCourse(sampleCourse);
		assertTrue("CourseProgramme list should now contain sample CourseProgramme", courses.contains(sampleCourse));
	}
	
	@Test // testing Module.addCourse() w/ duplicate entry
	public void testDuplicateAddCourse() {
		module.addCourse(sampleCourse);
		module.addCourse(sampleCourse);
		int count = 0;
		for( CourseProgramme c : module.getCourses() ) {
			if( c == sampleCourse )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}
	
	@Test // testing Module.removeCourse()
	public void testRemoveCourse() {
		module.addCourse(sampleCourse);
		module.removeCourse(sampleCourse);
		assertFalse("CourseProgramme list should not contain sample CourseProgramme", courses.contains(sampleCourse));
	}
}
