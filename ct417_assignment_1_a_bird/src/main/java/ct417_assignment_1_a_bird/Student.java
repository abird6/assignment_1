/**
 * This is the Student class
 * @author Anthony Bird
 */

package ct417_assignment_1_a_bird;

import org.joda.time.*;
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
	}
	
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	
	public void setID(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setAge(String age) { this.age = age; }
	public void setCourse(CourseProgramme course) { this.course = course; }
	public void setDOB(LocalDate dob) {	this.dob = dob; }
	public void addModule(Module module) { this.modules.add(module); }
	public void removeModule(Module module) { this.modules.remove(module); }
	
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
