/**
 * ModuleLecturer test class used to test 'Lecturer' coupling with 'Module.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModuleLecturerTest {

	// test objects
	Module module;
	Lecturer lecturer;
	List<Module> sampleModules;
	
	@BeforeEach
	void setup() {
		sampleModules = new ArrayList<Module>();
		lecturer = new Lecturer("12345", "Dr John B", "40", new LocalDate(1990, 1, 1), sampleModules);
		module = new Module("CT417", "Software Engineering III", null, null, lecturer);
	}
	
	// ====================== Accessor Method Testing =====================
	
	@Test
	@DisplayName("Test accessor for Lecturer object")
	void testGetLecturer() {
		assertSame(lecturer, module.getLecturer(), "Lecturer object included in Module instance should be returned");
	}
	
	// ====================== Mutator Method Testing =====================
	
	@Test
	@DisplayName("Test mutator for Lecturer object")
	void testSetLecturer() {
		List<Module> changeModules = new ArrayList<Module>();
		Lecturer changeLecturer = new Lecturer("54321", "Dr Jim B", "41", new LocalDate(1980, 12, 1), changeModules);
		module.setLecturer(changeLecturer);
		assertSame(changeLecturer, module.getLecturer(), "New Lecturer object should be returned from accessor method");
	}
	
	@Test
	@DisplayName("Test automatic assigning of Lecturer to the module")
	void testLecturerAutoAssign() {
		List<Module> changeModules = new ArrayList<Module>();
		Lecturer changeLecturer = new Lecturer("54321", "Dr Jim B", "41", new LocalDate(1980, 12, 1), changeModules);
		module.setLecturer(changeLecturer);
		assertTrue("Module should now appear on lecturer's module list", changeLecturer.getModules().contains(module));
	}
}
