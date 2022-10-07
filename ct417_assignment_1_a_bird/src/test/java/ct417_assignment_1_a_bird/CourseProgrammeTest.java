/**
 * CourseProgramme test class to test 'CourseProgramme.java' methods
 * independent of any other classes
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CourseProgrammeTest {

	// test objects
	LocalDate startDate, endDate;
	CourseProgramme course;
	
	@BeforeEach
	void setup() {
		startDate = new LocalDate(2022, 9, 23);
		endDate =  new LocalDate(2023, 5, 1);
		course = new CourseProgramme("ECE", null, null, startDate, endDate);
	}
	
	// ====================== Accessor Method Testing ======================
	
	@Test
	@DisplayName("Test accessor method for 'name'")
	void testGetName() {
		assertEquals("ECE", course.getName(), "CourseProgramme has name='ECE'");
	}
	
	@Test
	@DisplayName("Test accessor for 'startDate'")
	void testGetStartDate() {
		assertSame(startDate, course.getStartDate(), "'startDate' test object and method return should be the same");
	}
	
	@Test
	@DisplayName("Test accessor for 'endDate'")
	void testGetEndDate() {
		assertSame(endDate, course.getEndDate(), "'endDate' test object and method return should be the same");
	}
	
	// ====================== Mutator Method Testing ======================
		
	@Test
	@DisplayName("Test mutator for 'name'")
	void testSetName() {
		course.setName("CS");
		assertEquals("CS", course.getName(), "CourseProgramme should now have name='CS'");
	}
	
	@Test
	@DisplayName("Test mutator for 'startDate'")
	void testSetStartDate() {
		LocalDate changeStartDate = new LocalDate(2023, 9, 25);
		course.setStartDate(changeStartDate);
		assertSame(changeStartDate, course.getStartDate(), "New LocalDate object should be returned in accessor");
	}
	
	@Test
	@DisplayName("Test mutator for 'endDate'")
	void testSetEndDate() {
		LocalDate changeEndDate = new LocalDate(2024, 5, 30);
		course.setEndDate(changeEndDate);
		assertSame(changeEndDate, course.getEndDate(), "New LocalDate object should be returned in accessor");;
	}
}
