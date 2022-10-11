/**
 * This is the Student class
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import org.joda.time.*;

import java.util.ArrayList;
import java.util.List;

public class Student {
	// instance variables
	private String id, name, age;
	private LocalDate dob;
	private List<Module> modules;
	private CourseProgramme course;
	
	public Student(String id, String name, String age, CourseProgramme course, LocalDate dob, List<Module> modules) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
		this.dob = dob;
		this.modules = modules;
	}
	
	// overloaded constructor for instantiating independent Student objects
	public Student(String id, String name, String age, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.course = new CourseProgramme(null, null, null);
		this.modules = new ArrayList<Module>();
	}
	
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	
	public void setID(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setAge(String age) { this.age = age; }
	public void setCourse(CourseProgramme course) { 
		if( course != this.course && this.course != null && course != null ) { // if the student has changed courses ??
			this.course.removeStudent(this);				// remove student from the previous course
		}
		this.course = course;								// assign the new course to the student
		if(course != null ) {
			if (course.getStudents().indexOf(this) == -1) 		// if the student is not registered with the course object ??
				course.addStudent(this);						// register the student with the course
		}
		
	}
	public void setDOB(LocalDate dob) {	this.dob = dob; }
	public void addModule(Module module) { 
		if ( modules.indexOf(module) == -1 )				// checking if the student already has the module
			this.modules.add(module); 
		if ( module.getStudents().indexOf(this) == -1 )		// checking if the module already has the student 
			module.addStudent(this);
	}
	public void removeModule(Module module) { 
		if ( modules.indexOf(module) != -1 )				// checking that the module can be removed from the student's list
			modules.remove(module); 
		if ( module.getStudents().indexOf(this) != -1 ) 	// checking that the student can be removed from the module
			module.removeStudent(this);
	}
	
	/**
	 * 
	 * Accessor Methods
	 * 
	 */
	
	public String getID() { return id; }
	public String getName() { return name; }
	public String getAge() { return age; }
	public CourseProgramme getCourse() { return course; }
	public LocalDate getDOB() { return dob; }
	public List<Module> getModules() { return modules; }
	public String getUsername() { return name.replaceAll(" ", "") + this.age; }
	
}
