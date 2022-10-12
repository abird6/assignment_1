/**
 * CourseProgramme test class to test 'CourseProgramme.java' methods
 * independent of any other classes
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

// import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.LocalDate;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

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
	
	@Test
	public void testGetName() {
		assertEquals("CourseProgramme has name='ECE'", "ECE", course.getName());
	}
	
	@Test
	public void testGetStartDate() {
		assertSame("'startDate' test object and method return should be the same", startDate, course.getStartDate());
	}
	
	@Test
	public void testGetEndDate() {
		assertSame("'endDate' test object and method return should be the same", endDate, course.getEndDate());
	}
	
	// ====================== Mutator Method Testing ======================
		
	@Test
	public void testSetName() {
		course.setName("CS");
		assertEquals("CourseProgramme should now have name='CS'", "CS", course.getName());
	}
	
	@Test
	public void testSetStartDate() {
		LocalDate changeStartDate = new LocalDate(2023, 9, 25);
		course.setStartDate(changeStartDate);
		assertSame("New LocalDate object should be returned in accessor", changeStartDate, course.getStartDate());
	}
	
	@Test
	public void testSetEndDate() {
		LocalDate changeEndDate = new LocalDate(2024, 5, 30);
		course.setEndDate(changeEndDate);
		assertSame("New LocalDate object should be returned in accessor", changeEndDate, course.getEndDate());
	}
}
