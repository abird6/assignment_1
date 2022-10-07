/**
 * Lecture test class used to test 'Lecturer.java' methods
 * independent of any other classes
 * @author Anthony Bird
 */
package ct417_assignment_1_a_bird;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LecturerTest {
	
	// test objects
	LocalDate dob;
	Lecturer lecturer;
	
	@BeforeEach
	void setup() {
		dob = new LocalDate(1980, 12, 25);
		lecturer = new Lecturer("12345", "Dr Joe Bloggs", "42", dob, null);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accessor for 'id'")
	void testGetID() {
		assertEquals("12345", lecturer.getID(), "Lecturer has id='12345'");
	}
	
	@Test
	@DisplayName("Test accessor method for 'name'")
    void testGetName() {
    	assertEquals("Dr Joe Bloggs", lecturer.getName(), "Lecturer has name='Dr Joe Bloggs'");
    }
	
	@Test 
	@DisplayName("Test accessor method for 'age'")
	void testGetAge() {
		assertEquals("42", lecturer.getAge(), "Lecturer has age='42'");
	}
	
	@Test
	@DisplayName("Test accessor method for 'date of birth'")
	void testGetDOB() {
		assertSame(dob, lecturer.getDOB(), "'dob' test object and method return should be the same");
	}
	
	@Test
	@DisplayName("Test generator method for usernames")
	void testGetUsername() {
		assertEquals("DrJoeBloggs42", lecturer.getUsername(), "Username should concantenate lecturer's name and age with no whitespace i.e. 'DrJoeBloggs42'");
	}
	
	// ====================== Mutator Method Testing ======================
	@Test
	@DisplayName("Testing mutator for 'id'")
	void testSetID() {
		lecturer.setID("54321");
		assertEquals("54321", lecturer.getID(), "Lecturer should now have id='54321'");
	}
	
	@Test
	@DisplayName("Testing mutator for 'name'")
	void testSetName() {
		lecturer.setName("Dr Tim Sullivan");
		assertEquals("Dr Tim Sullivan", lecturer.getName(), "Lecturer should now have name='Dr Tim Sullivan'");
	}
	
	@Test
	@DisplayName("Testing mutator for 'age'")
	void testSetAge() {
		lecturer.setAge("30");
		assertEquals("30", lecturer.getAge(), "Lecturer should now have age='30'");
	}
	
	@Test
	@DisplayName("Testing new username with mutators")
	void testChangeUsername() {
		lecturer.setAge("35");
		lecturer.setName("Dr John Bellingham");
		assertEquals("DrJohnBellingham35", lecturer.getUsername(), "Lecturer should now have username 'DrJohnBellingham35'");
	}
	
	@Test
	@DisplayName("Tesing mutator for date of birth")
	void testSetDOB() {
		LocalDate changeDOB = new LocalDate(1990, 11, 12);
		lecturer.setDOB(changeDOB);
		assertSame(changeDOB, lecturer.getDOB(), "New LocalDate object should be returned in accessor");
	}

}
