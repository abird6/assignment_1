/**
 * ModuleStudent test class used to test 'Student' coupling with 'Module.java'
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ModuleStudentTest {
	
	// test objects
	Module module;
	List<Student> students;
	Student sampleStudent;
	
	public ModuleStudentTest() {
	
	}

	@Before
	public void setup() {
		students = new ArrayList<Student>();

		module = new Module("CT417", "Software Engineering III", students, null, null);
		
		sampleStudent = new Student("1935176", "Anthony Bird", "21", new LocalDate(2000, 10, 10));
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing Module.getStudents()
	public void testGetStudents() {
		assertEquals("Module has list of Student objects defined in setup()", students, module.getStudents());
	}
	
	// ====================== Mutator Method Testing ======================
	
	@Test // testing Module.addStudent()
	public void testAddStudent() {
		module.addStudent(sampleStudent);
		assertTrue("Student list should now contain sample Student", students.contains(sampleStudent));
	}
	
	@Test // testing Module.addStudent() w/ duplicate entry
	public void testDuplicateAdd() {
		module.addStudent(sampleStudent);
		module.addStudent(sampleStudent);
		int count = 0;
		for( Student s : module.getStudents() ) {
			if( s == sampleStudent )
				count++;
		}
		assertEquals("count should be 1 to show no duplicate entries", 1, count);
	}
	
	@Test // testing Module.removeStudent()
	public void testRemoveStudent() {
		module.addStudent(sampleStudent);
		module.removeStudent(sampleStudent);
		assertFalse("Student list should not contain sample Student", students.contains(sampleStudent));
	}
}
