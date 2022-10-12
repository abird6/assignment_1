/**
 * This is the Student class ( final implementation )
 * Instances of this class are tightly coupled with CourseProgramme and Module objects
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import org.joda.time.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	// instance variables
	private String id, name, age;		// student's ID, full name and age 
	private LocalDate dob;				// student's date of birth
	private List<Module> modules; 		// a list of module's the student is taking
	private CourseProgramme course;		// the course that the student has enrolled in 
	
	public Student(String id, String name, String age, CourseProgramme course, LocalDate dob, List<Module> modules) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
		this.dob = dob;
		this.modules = modules;
	}
	
	/**
	 * Constuctor used if no course or list of modules is included
	 * Object place holders will be instantiated
	 *
	 */
	public Student(String id, String name, String age, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.course = new CourseProgramme(null, null, null);
		this.modules = new ArrayList<Module>();
	}
	
	/**
	 * Mutator Methods
	 * 
	 */
	// set the student ID (String)
	public void setID(String id) { this.id = id; }
	
	// set the student's full name (String)
	public void setName(String name) { this.name = name; }
	
	// set the student's age (String)
	public void setAge(String age) { this.age = age; }
	
	// set a course for this instance (CourseProgramme)
	// setting a course for this instance adds this student to the course
	public void setCourse(CourseProgramme course) { 
		if( course != this.course && this.course != null && course != null ) { 		// check if the student is already enrolled in another course
			this.course.removeStudent(this);										// remove student from the previous course
		}
		this.course = course;														// assign the new course to the student
		if(course != null ) {
			if (course.getStudents().indexOf(this) == -1) 							// check if the student is not enrolled with the new course
				course.addStudent(this);											
		}
	}
	
	// set the date of birth for the student
	public void setDOB(LocalDate dob) {	this.dob = dob; }
	
	// add a module for the student to take
	// adding  a module to this instance adds this student to the module
	public void addModule(Module module) { 
		if ( modules.indexOf(module) == -1 )				// check if the student already has the module
			this.modules.add(module); 
		if ( module.getStudents().indexOf(this) == -1 )		// check if the module already has the student 
			module.addStudent(this);
	}
	
	// remove a module from the this instance
	// removing a module from this student removes this student from the module
	public void removeModule(Module module) { 
		if ( modules.indexOf(module) != -1 )				// check that the module can be removed from the student's list
			modules.remove(module); 
		if ( module.getStudents().indexOf(this) != -1 ) 	// check that the student can be removed from the module
			module.removeStudent(this);
	}
	
	/**
	 * Accessor Methods
	 * 
	 */
	public String getID() { return id; }
	public String getName() { return name; }
	public String getAge() { return age; }
	public CourseProgramme getCourse() { return course; }
	public LocalDate getDOB() { return dob; }
	public List<Module> getModules() { return modules; }
	
	// generate a username by combining name and age fields
	// method removes any whitespace in full names
	public String getUsername() { return name.replaceAll(" ", "") + this.age; }
}
