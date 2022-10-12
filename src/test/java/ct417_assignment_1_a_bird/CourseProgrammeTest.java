/**
 * CourseProgramme test class to test 'CourseProgramme.java' methods
 * independent of any other classes
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import org.joda.time.LocalDate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class CourseProgrammeTest {

	// test objects
	LocalDate startDate, endDate;
	CourseProgramme course;
	
	public CourseProgrammeTest() {
	
	}

	@Before
	public void setup() {
		startDate = new LocalDate(2022, 9, 23);
		endDate =  new LocalDate(2023, 5, 1);
		course = new CourseProgramme("ECE", startDate, endDate);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test // testing CourseProgramme.getName()
	public void testGetName() {
		assertEquals("CourseProgramme has name='ECE'", "ECE", course.getName());
	}
	
	@Test // testing CourseProgramme.getStartDate()
	public void testGetStartDate() {
		assertSame("'startDate' test object and method return should be the same", startDate, course.getStartDate());
	}
	
	@Test // testing CourseProgramme.getEndDate()
	public void testGetEndDate() {
		assertSame("'endDate' test object and method return should be the same", endDate, course.getEndDate());
	}
	
	// ====================== Mutator Method Testing ======================
		
	@Test // testing CourseProgramme.setName()
	public void testSetName() {
		course.setName("CS");
		assertEquals("CourseProgramme should now have name='CS'", "CS", course.getName());
	}
	
	@Test // testing CourseProgramme.setStartDate()
	public void testSetStartDate() {
		LocalDate changeStartDate = new LocalDate(2023, 9, 25);
		course.setStartDate(changeStartDate);
		assertSame("New LocalDate object should be returned in accessor", changeStartDate, course.getStartDate());
	}
	
	@Test // testing CourseProgramme.setEndDate()
	public void testSetEndDate() {
		LocalDate changeEndDate = new LocalDate(2024, 5, 30);
		course.setEndDate(changeEndDate);
		assertSame("New LocalDate object should be returned in accessor", changeEndDate, course.getEndDate());
	}
}
