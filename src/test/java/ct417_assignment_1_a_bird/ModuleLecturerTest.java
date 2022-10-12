/**
 * ModuleLecturer test class used to test 'Lecturer' coupling with 'Module.java'
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import org.joda.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ModuleLecturerTest {

	// test objects
	Module module;
	Lecturer lecturer;
	
	public ModuleLecturerTest() {

	}	

	@Before
	public void setup() {
		lecturer = new Lecturer("12345", "Dr John B", "40", new LocalDate(1990, 1, 1));
		module = new Module("CT417", "Software Engineering III", null, null, lecturer);
	}
	
	// ====================== Accessor Method Testing =====================
	
	@Test // testing Module.getLecturer()
	public void testGetLecturer() {
		assertSame("Lecturer object included in Module instance should be returned", lecturer, module.getLecturer());
	}
	
	// ====================== Mutator Method Testing =====================
	
	@Test // testing Module.setLecturer()
	public void testSetLecturer() {
		Lecturer changeLecturer = new Lecturer("54321", "Dr Jim B", "41", new LocalDate(1980, 12, 1));
		module.setLecturer(changeLecturer);
		assertSame("New Lecturer object should be returned from accessor method", changeLecturer, module.getLecturer());
	}
	
	@Test // testing Module.setLecturer() so Lecturer.getModules() is auto updated
	public void testLecturerAutoAssign() {
		Lecturer changeLecturer = new Lecturer("54321", "Dr Jim B", "41", new LocalDate(1980, 12, 1));
		module.setLecturer(changeLecturer);
		assertTrue("Module should now appear on lecturer's module list", changeLecturer.getModules().contains(module));
	}
}
