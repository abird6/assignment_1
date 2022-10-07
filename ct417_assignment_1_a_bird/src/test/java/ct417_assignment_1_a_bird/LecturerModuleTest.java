/**
 * LecturerModule test class used to test 'Module' coupling with 'Lecturer.java'
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

class LecturerModuleTest {

	// test objects
	Lecturer lecturer;
	List<Module> modules;
	Module sampleModule;
	
	@BeforeEach
	void setup() {
		modules = new ArrayList<Module>();
		lecturer = new Lecturer(null, null, null, null, modules);
		
		sampleModule = new Module("CT417", "Software Engineering III", null, null, null);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for modules")
	void testGetModules() {
		assertEquals(modules, lecturer.getModules(), "Lecturer has list of modules defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding modules")
	void testAddModule() {
		lecturer.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test
	@DisplayName("Test mutator for removing modules")
	void testRemoveModule() {
		lecturer.addModule(sampleModule);
		lecturer.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}

}