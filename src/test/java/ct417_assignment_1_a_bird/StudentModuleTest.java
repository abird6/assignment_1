/**
 * StudentModule test class used to test 'Module' coupling in 'Student.java'
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StudentModuleTest {
	
	// test objects
	List<Module> modules;
	Module sampleModule;
	Student student;
	
	public StudentModuleTest() {

	}

	@Before
	public void setup() {
		modules = new ArrayList<Module>();
		student = new Student(null, null, null, null, null, modules);
		sampleModule = new Module("CT417", "Software Engineering III");
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing Student.getModules()
	public void testGetModules() {
		assertEquals("Student has list of modules defined in setup()", modules, student.getModules());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing Student.addModule()
	public void testAddModule() {
		student.addModule(sampleModule);
		assertTrue("Module list should now contain sample Module", modules.contains(sampleModule));
	}
	
	@Test // testing Student.addModule() w/ duplicate entry
	public void testDuplicateAddModule() {
		student.addModule(sampleModule);
		student.addModule(sampleModule);
		int count = 0;
		for( Module m : student.getModules() ) {
			if( m == sampleModule )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}
	
	@Test // testing Student.removeModule()
	public void testRemoveModule() {
		student.addModule(sampleModule);
		student.removeModule(sampleModule);
		assertFalse("Module list should not contain sample Module", modules.contains(sampleModule));
	}
}
