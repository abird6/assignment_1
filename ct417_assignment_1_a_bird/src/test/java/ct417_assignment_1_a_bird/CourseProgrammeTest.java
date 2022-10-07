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

	CourseProgramme course;
	
	@BeforeEach
	void setup() {
		course = new CourseProgramme("ECE", null, null, new LocalDate(2022, 9, 23), new LocalDate(2023, 5, 1));
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
		assertEquals(new LocalDate(2022, 9, 23), course.getStartDate(), "Course should start on 23/9/2022");
	}
	
	@Test
	@DisplayName("Test accessor for 'endDate'")
	void testGetEndDate() {
		assertEquals(new LocalDate(2023, 5, 1), course.getEndDate(), "Course should end on 1/5/2023");
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
		course.setStartDate(new LocalDate(2023, 9, 25));
		assertEquals(new LocalDate(2023, 9, 25), course.getStartDate(), "Course should now start on 25/9/2023");
	}
	
	@Test
	@DisplayName("Test mutator for 'endDate'")
	void testSetEndDate() {
		course.setEndDate(new LocalDate(2024, 5, 30));
		assertEquals(new LocalDate(2024, 5, 30), course.getEndDate(), "Course should now end on 30/5/2023");
	}
}
