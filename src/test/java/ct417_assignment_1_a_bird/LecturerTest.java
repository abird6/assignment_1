/**
 * Lecture test class used to test 'Lecturer.java' methods
 * independent of any other classes
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */
package ct417_assignment_1_a_bird;

import org.joda.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class LecturerTest {
	
	// test objects
	LocalDate dob;
	Lecturer lecturer;
	
	public LecturerTest() {
	
	}	

	@Before
	public void setup() {
		dob = new LocalDate(1980, 12, 25);
		lecturer = new Lecturer("12345", "Dr Joe Bloggs", "42", dob);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing Lecturer.getID()
	public void testGetID() {
		assertEquals("Lecturer has id='12345'", "12345", lecturer.getID());
	}
	
	@Test // testing Lecturer.getName()
	public void testGetName() {
    		assertEquals("Lecturer has name='Dr Joe Bloggs'", "Dr Joe Bloggs", lecturer.getName());
    	}
	
	@Test // testing Lecturer.getAge()
	public void testGetAge() {
		assertEquals("Lecturer has age='42'", "42", lecturer.getAge());
	}
	
	@Test // testing Lecturer.getDOB()
	public void testGetDOB() {
		assertSame("'dob' test object and method return should be the same", dob, lecturer.getDOB());
	}
	
	@Test // testing Lecturer.getUsername()
	public void testGetUsername() {
		assertEquals("Username should concantenate lecturer's name and age with no whitespace i.e. 'DrJoeBloggs42'", "DrJoeBloggs42", lecturer.getUsername());
	}
	
	// ====================== Mutator Method Testing ======================
	@Test // testing Lecturer.setID()
	public void testSetID() {
		lecturer.setID("54321");
		assertEquals("Lecturer should now have id='54321'", "54321", lecturer.getID());
	}
	
	@Test // testing Lecturer.setName()
	public void testSetName() {
		lecturer.setName("Dr Tim Sullivan");
		assertEquals("Lecturer should now have name='Dr Tim Sullivan'", "Dr Tim Sullivan", lecturer.getName());
	}
	
	@Test // testing Lecturer.setAge()
	public void testSetAge() {
		lecturer.setAge("30");
		assertEquals("Lecturer should now have age='30'", "30", lecturer.getAge());
	}
	
	@Test // testing Lecturer.getUsername() w/ a change in Lecturer.name and Lecturer.age
	public void testChangeUsername() {
		lecturer.setAge("35");
		lecturer.setName("Dr John Bellingham");
		assertEquals("Lecturer should now have username 'DrJohnBellingham35'", "DrJohnBellingham35", lecturer.getUsername());
	}
	
	@Test // testing Lecturer.setDOB()
	public void testSetDOB() {
		LocalDate changeDOB = new LocalDate(1990, 11, 12);
		lecturer.setDOB(changeDOB);
		assertSame("New LocalDate object should be returned in accessor", changeDOB, lecturer.getDOB());
	}
}
