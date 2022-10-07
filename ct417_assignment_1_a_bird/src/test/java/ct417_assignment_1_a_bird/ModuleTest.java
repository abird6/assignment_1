/**
 * Module test class used to test 'Module.java' methods
 * independent of other classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModuleTest {

	// test objects
	Module module;
	
	@BeforeEach
	void setup() {
		module = new Module("CT417", "Software Engineering III", null, null, null);
	}
	
	// ====================== Accessor Method Testing ======================
	@Test
	@DisplayName("Test accessor method for 'id'")
	void testGetID() {
		assertEquals("CT417", module.getID(), "Module id is CT417");
	}
	
	@Test
	@DisplayName("Test accessor method for 'name'")
	void testGetName() {
		assertEquals("Software Engineering III", module.getName(), "Module name is Software Engineering III");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for 'id'")
	void testSetID() {
		module.setID("EE123");
		assertEquals("EE123", module.getID(), "Module should now have and id='EE123'");
	}
	
	@Test
	@DisplayName("Test mutator for 'name'")
	void testSetName() {
		module.setName("Analogue Systems");
		assertEquals("Analogue Systems", module.getName(), "Module should now have name='Analogue Systems'");
	}
}
