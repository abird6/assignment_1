/**
 * CourseModule test class used to test 'Module' coupling with 'CourseProgramme.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

public class CourseModuleTest {

	// test objects
	CourseProgramme course;
	List<Module> modules;	
	Module sampleModule;
	
	public CourseModuleTest() {

	}	

	@Before
	public void setup() {
		modules = new ArrayList<Module>();
		course = new CourseProgramme("ECE", modules, new LocalDate(2023, 9, 12), new LocalDate(2024, 5, 6));
		
		sampleModule = new Module("CT417", "Software Engineering III");
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	public void testGetModules() {
		assertEquals("CourseProgramme has list of modules defined in setup()", modules, course.getModules());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	public void testAddModule() {
		course.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test
	public void testDuplicateEntry() {
		course.addModule(sampleModule);
		course.addModule(sampleModule);
		int count = 0;
		for( Module m : course.getModules() ) {
			if( m== sampleModule )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}

	
	@Test
	public void testRemoveModule() {
		course.addModule(sampleModule);
		course.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}
}
