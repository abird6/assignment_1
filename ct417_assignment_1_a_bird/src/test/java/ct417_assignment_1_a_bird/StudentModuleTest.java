/**
 * StudentModule test class used to test 'Module' coupling in 'Student.java'
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

class StudentModuleTest {
	
	// test objects
	List<Module> modules;
	Module sampleModule;
	Student student;
	
	@BeforeEach
	void setup() {
		modules = new ArrayList<Module>();
		student = new Student(null, null, null, null, null, modules);
		
		sampleModule = new Module("CT417", "Software Engineering III", null, null, null);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for modules")
	void testGetModules() {
		assertEquals(modules, student.getModules(), "Student has list of modules defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding modules")
	void testAddModule() {
		student.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test
	@DisplayName("Test mutator for removing modules")
	void testRemoveModule() {
		student.addModule(sampleModule);
		student.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}

}
