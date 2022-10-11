/**
 * This is the CourseProgramme class.
 * Used by Module and Student classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class CourseProgramme {
	// instance variables
	private String name;
	private List<Module> modules;
	private List<Student> students;
	private LocalDate startDate, endDate;
	
	public CourseProgramme(String name, List<Module> modules, List<Student> students, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.modules = modules;
		this.students = students;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	// overloaded constructor for instantiating independent CourseProgramme objects
	public CourseProgramme(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = new ArrayList<Module>();
		this.students = new ArrayList<Student>();
	}
	
	public CourseProgramme(String name, List<Module> modules, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = modules;
		this.students = new ArrayList<Student>();
	}
	
	public CourseProgramme(String name, LocalDate startDate, LocalDate endDate,  List<Student> students) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.students = students;
		this.modules = new ArrayList<Module>();
	}
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	public void setName(String name) { this.name = name; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	public void addModule(Module module) { 
		if( module.getCourses().indexOf(this) == -1 )	// checking that the course can be added to the module
			module.addCourse(this);
		if( this.getModules().indexOf(module) == -1 )	// checking that the module can be added to the course
			modules.add(module);
	}
	public void removeModule(Module module) { 
		if( module.getCourses().indexOf(this) != -1) 	// checking that the course can be removed by the module
			module.removeCourse(this);
		if( this.getModules().indexOf(module) != -1)	// checking that the module can be removed by the course
			modules.remove(module);
	}
	public void addStudent(Student student) {  
		if( student.getCourse() != this)
			student.setCourse(this);					// if not done already, assign this course to the student
		if( students.indexOf(student) == -1 )
			students.add(student);
		for ( Module m : this.getModules() ) {		
			student.addModule(m);					// assign the relevant modules to the student
		}
	}
	public void removeStudent(Student student) { 
		if( this.getStudents().indexOf(student) != -1) // checking that the student can be removed from the course 
			students.remove(student);
	
		student.setCourse(null);					// the student now has no course 
		for ( Module m : this.getModules() ) {
			student.removeModule(m);				// clear the student's modules
		}
	}
	
	/**
	 * 
	 * Accessor Methods
	 * 
	 */
	public String getName() { return name; }
	public List<Module> getModules() { return modules; }
	public List<Student> getStudents() { return students; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getEndDate() { return endDate; }


}

