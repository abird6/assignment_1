/**
 * LecturerModule test class used to test 'Module' coupling with 'Lecturer.java'
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class LecturerModuleTest {

	// test objects
	Lecturer lecturer;
	List<Module> modules;
	Module sampleModule;
	
	public LecturerModuleTest() {

	}

	@Before
	public void setup() {
		modules = new ArrayList<Module>();
		lecturer = new Lecturer(null, null, null, null, modules);
		sampleModule = new Module("CT417", "Software Engineering III");
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing Lecturer.getModules()
	public void testGetModules() {
		assertEquals("Lecturer has list of modules defined in setup()", modules, lecturer.getModules());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing Lecturer.addModule()
	public void testAddModule() {
		lecturer.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test // testing Lecturer.addModule() w/ duplicate entry
	public void testDuplicateAdd() {
		lecturer.addModule(sampleModule);
		lecturer.addModule(sampleModule);
		int count = 0;
		for( Module m : lecturer.getModules() ) {
			if( m == sampleModule )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}
	
	@Test // testing Lecturer.removeModule()
	public void testRemoveModule() {
		lecturer.addModule(sampleModule);
		lecturer.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}

}