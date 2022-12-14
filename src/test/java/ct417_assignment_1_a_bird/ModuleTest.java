/**
 * Module test class used to test 'Module.java' methods
 * independent of other classes
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ModuleTest {

	// test objects
	Module module;
	
	public ModuleTest() {

	}

	@Before
	public void setup() {
		module = new Module("CT417", "Software Engineering III");
	}
	
	// ====================== Accessor Method Testing ======================
	@Test // testing Module.getID()
	public void testGetID() {
		assertEquals("Module id is CT417", "CT417", module.getID());
	}
	
	@Test // testing Module.getName()
	public void testGetName() {
		assertEquals("Module name is Software Engineering III", "Software Engineering III", module.getName());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing Module.setID()
	public void testSetID() {
		module.setID("EE123");
		assertEquals("Module should now have and id='EE123'", "EE123", module.getID());
	}
	
	@Test // testing Module.setName()
	public void testSetName() {
		module.setName("Analogue Systems");
		assertEquals("Module should now have name='Analogue Systems'", "Analogue Systems", module.getName());
	}
}
