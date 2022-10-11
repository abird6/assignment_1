/**
 * CourseModule test class used to test 'Module' coupling with 'CourseProgramme.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseModuleTest {

	// test objects
	CourseProgramme course;
	List<Module> modules;
	List<CourseProgramme> sampleCourses;
	Module sampleModule;
	
	@BeforeEach
	void setup() {
		modules = new ArrayList<Module>();
		sampleCourses = new ArrayList<CourseProgramme>();
		course = new CourseProgramme(null, modules, null, null, null);
		
		sampleModule = new Module("CT417", "Software Engineering III", null, sampleCourses, null);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for modules")
	void testGetModules() {
		assertEquals(modules, course.getModules(), "CourseProgramme has list of modules defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding modules")
	void testAddModule() {
		course.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test
	@DisplayName("Duplicate entry test")
	void testDuplicateEntry() {
		course.addModule(sampleModule);
		course.addModule(sampleModule);
		int count = 0;
		for( Module m : course.getModules() ) {
			if( m== sampleModule )
				count++;
		}
		assertEquals(1, count, "count should be 1 to show no duplicate entries");
	}

	
	@Test
	@DisplayName("Test mutator for removing modules")
	void testRemoveModule() {
		course.addModule(sampleModule);
		course.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}
}
