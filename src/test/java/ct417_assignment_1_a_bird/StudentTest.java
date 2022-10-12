/**
 * Student test class used to test 'Student.java' methods
 * independent of other classes
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

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
	@Test // testing Student.getID()
	public void testGetID() {
		assertEquals("Student's ID is 19357176", "19357176", student.getID());
	}
	
	@Test // testing Student.getName()
	public void testGetName() {
    		assertEquals("Student's name is Anthony Bird", "Anthony Bird", student.getName());
    	}
	
	@Test // testing Student.getAge()
	public void testGetAge() {
		assertEquals("Student's age is 21", "21", student.getAge());
	}
	
	@Test // testing Student.getDOB()
	public void testGetDOB() {
		assertSame("'dob' test object and method return should be the same", dob, student.getDOB());
	}
	
	@Test // testing Student.getUsername()
	public void testGetUsername() {
		assertEquals("Username should concantenate student's name and age with no whitespace", "AnthonyBird21", student.getUsername());
	}
	
	// ====================== Mutator Method Testing ======================
	@Test // testing Student.setID()
	public void testSetID() {
		student.setID("67175391");
		assertEquals("Student's id should now be 67175391", "67175391", student.getID());
	}
	
	@Test // testing Student.setName()
	public void testSetName() {
		student.setName("Joe Bloggs");
		assertEquals("Student's name should now be Joe Bloggs", "Joe Bloggs", student.getName());
	}
	
	@Test // testing Student.setAge()
	public void testSetAge() {
		student.setAge("22");
		assertEquals("Student's age should now be 22", "22", student.getAge());
	}
	
	@Test // testing Student.getUsername() w/ a change in Student.name and Student.age
	public void testChangeUsername() {
		student.setAge("25");
		student.setName("Jimmy Neutron");
		assertEquals("Student's new username should be JimmyNeutron25", "JimmyNeutron25", student.getUsername());
	}
	
	@Test // testing Student.getUsername() w/ a double barrell name
	public void testUsernameDblName() {
		student.setName("Chris Martin Griffin");
		assertEquals("Student's new username should incorporate their full name", "ChrisMartinGriffin21", student.getUsername());
	}
	
	@Test // testing Student.setDOB()
	public void testSetDOB() {
		LocalDate changeDOB = new LocalDate(2005, 11, 12);
		student.setDOB(changeDOB);
		assertSame("New LocalDate object should be returned in accessor", changeDOB, student.getDOB());
	}
}
