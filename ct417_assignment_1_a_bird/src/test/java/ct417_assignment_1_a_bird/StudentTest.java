/**
 * Student test class used to test 'Student.java' methods
 * independent of other classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.LocalDate;

class StudentTest {
	
	// test objects
	Student student;
	LocalDate dob;
	
	@BeforeEach
	void setup() {
		dob = new LocalDate(2000, 10, 10);
		student = new Student("19357176", "Anthony Bird", "21", null, dob, null);	// course and module fields left null
	}
	
	// ====================== Accessor Method Testing ======================
	@Test
	@DisplayName("Test accessor method for 'id'")
	void testGetID() {
		assertEquals("19357176", student.getID(), "Student's ID is 19357176");
	}
	
	@Test
	@DisplayName("Test accessor method for 'name'")
    void testGetName() {
    	assertEquals("Anthony Bird", student.getName(), "Student's name is Anthony Bird");
    }
	
	@Test 
	@DisplayName("Test accessor method for 'age'")
	void testGetAge() {
		assertEquals("21", student.getAge(), "Student's age is 21");
	}
	
	@Test
	@DisplayName("Test accessor method for 'date of birth'")
	void testGetDOB() {
		assertSame(dob, student.getDOB(), "'dob' test object and method return should be the same");
	}
	
	@Test
	@DisplayName("Test generator method for usernames")
	void testGetUsername() {
		assertEquals("AnthonyBird21", student.getUsername(), "Username should concantenate student's name and age with no whitespace");
	}
	
	// ====================== Mutator Method Testing ======================
	@Test
	@DisplayName("Testing mutator for 'id'")
	void testSetID() {
		student.setID("67175391");
		assertEquals("67175391", student.getID(), "Student's id should now be 67175391");
	}
	
	@Test
	@DisplayName("Testing mutator for 'name'")
	void testSetName() {
		student.setName("Joe Bloggs");
		assertEquals("Joe Bloggs", student.getName(), "Student's name should now be Joe Bloggs");
	}
	
	@Test
	@DisplayName("Testing mutator for 'age'")
	void testSetAge() {
		student.setAge("22");
		assertEquals("22", student.getAge(), "Student's age should now be 22");
	}
	
	@Test
	@DisplayName("Testing new username with mutators")
	void testChangeUsername() {
		student.setAge("25");
		student.setName("Jimmy Neutron");
		assertEquals("JimmyNeutron25", student.getUsername(), "Student's new username should be JimmyNeutron25");
	}
	
	@Test
	@DisplayName("Testing username generation with double barrell name")
	void testUsernameDblName() {
		student.setName("Chris Martin Griffin");
		assertEquals("ChrisMartinGriffin21", student.getUsername(), "Student's new username should incorporate their full name");
	}
	
	@Test
	@DisplayName("Tesing mutator for date of birth")
	void testSetDOB() {
		LocalDate changeDOB = new LocalDate(2005, 11, 12);
		student.setDOB(changeDOB);
		assertSame(changeDOB, student.getDOB(), "New LocalDate object should be returned in accessor");
	}

}
