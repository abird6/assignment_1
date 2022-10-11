/**
 * ModuleStudent test class used to test 'Student' coupling with 'Module.java'
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModuleStudentTest {
	
	// test objects
	Module module;
	List<Student> students;
	Student sampleStudent;
	List<Module> sampleModules;
	
	@BeforeEach
	void setup() {
		students = new ArrayList<Student>();
		sampleModules = new ArrayList<Module>();
		module = new Module("CT417", "Software Engineering III", students, null, null);
		
		sampleStudent = new Student("1935176", "Anthony Bird", "21", null, new LocalDate(2000, 10, 10), sampleModules);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accesor for students")
	void testGetStudents() {
		assertEquals(students, module.getStudents(), "Module has list of Student objects defined in setup()");
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test
	@DisplayName("Test mutator for adding students")
	void testAddStudent() {
		module.addStudent(sampleStudent);
		assertTrue("Student list should now contain sample Student", students.contains(sampleStudent));
	}
	
	@Test
	@DisplayName("Duplicate entry test")
	void testDuplicateAdd() {
		module.addStudent(sampleStudent);
		module.addStudent(sampleStudent);
		int count = 0;
		for( Student s : module.getStudents() ) {
			if( s == sampleStudent )
				count++;
		}
		assertEquals(1, count, "count should be 1 to show no duplicate entries");
	}
	
	@Test
	@DisplayName("Test mutator for removing students")
	void testRemoveStudent() {
		module.addStudent(sampleStudent);
		module.removeStudent(sampleStudent);
		assertFalse("Student list should not contain sample Student", students.contains(sampleStudent));
	}

}
