/**
 * Student test class used to test 'Student.java' methods
 * independent of other classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.LocalDate;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StudentTest {
	
	// test objects
	Student student;
	LocalDate dob;
	
	public StudentTest() {

	}

	@Before
	public void setup() {
		dob = new LocalDate(2000, 10, 10);
		student = new Student("19357176", "Anthony Bird", "21", dob);	// course and module fields left null
	}
	
	// ====================== Accessor Method Testing ======================
	@Test
	public void testGetID() {
		assertEquals("Student's ID is 19357176", "19357176", student.getID());
	}
	
	@Test
	public void testGetName() {
    		assertEquals("Student's name is Anthony Bird", "Anthony Bird", student.getName());
    	}
	
	@Test 
	public void testGetAge() {
		assertEquals("Student's age is 21", "21", student.getAge());
	}
	
	@Test
	public void testGetDOB() {
		assertSame("'dob' test object and method return should be the same", dob, student.getDOB());
	}
	
	@Test
	public void testGetUsername() {
		assertEquals("Username should concantenate student's name and age with no whitespace", "AnthonyBird21", student.getUsername());
	}
	
	// ====================== Mutator Method Testing ======================
	@Test
	public void testSetID() {
		student.setID("67175391");
		assertEquals("Student's id should now be 67175391", "67175391", student.getID());
	}
	
	@Test
	public void testSetName() {
		student.setName("Joe Bloggs");
		assertEquals("Student's name should now be Joe Bloggs", "Joe Bloggs", student.getName());
	}
	
	@Test
	public void testSetAge() {
		student.setAge("22");
		assertEquals("Student's age should now be 22", "22", student.getAge());
	}
	
	@Test
	public void testChangeUsername() {
		student.setAge("25");
		student.setName("Jimmy Neutron");
		assertEquals("Student's new username should be JimmyNeutron25", "JimmyNeutron25", student.getUsername());
	}
	
	@Test
	public void testUsernameDblName() {
		student.setName("Chris Martin Griffin");
		assertEquals("Student's new username should incorporate their full name", "ChrisMartinGriffin21", student.getUsername());
	}
	
	@Test
	public void testSetDOB() {
		LocalDate changeDOB = new LocalDate(2005, 11, 12);
		student.setDOB(changeDOB);
		assertSame("New LocalDate object should be returned in accessor", changeDOB, student.getDOB());
	}

}
