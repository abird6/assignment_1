/**
 * This is the CourseProgramme class ( final implementation )
 * Instances of this class are tightly coupled with Module and Student objects
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 *
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;

public class CourseProgramme {
	
	// instance variables
	private String name;					// name of the course i.e. 'ECE'
	private List<Module> modules;			// list of associated modules
	private List<Student> students;			// list of enrolled students 
	private LocalDate startDate, endDate;	// dates of term for the course
	
	public CourseProgramme(String name, List<Module> modules, List<Student> students, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.modules = modules;
		this.students = students;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * Constructor used if no set list of students or modules are included
	 * New lists for students and modules will be instantiated
	 *
	 */
	public CourseProgramme(String name, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = new ArrayList<Module>();
		this.students = new ArrayList<Student>();
	}
	
	/**
	 * Constructor used if no list of students is included
	 * New list for students will be instantiated
	 *
	 */
	public CourseProgramme(String name, List<Module> modules, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = modules;
		this.students = new ArrayList<Student>();
	}
	
	/**
	 * Constructor used if no list of modules is included 
	 * New list for modules will be instantiated
	 *
	 */
	public CourseProgramme(String name, LocalDate startDate, LocalDate endDate,  List<Student> students) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.students = students;
		this.modules = new ArrayList<Module>();
	}
	
	/**
	 * Mutator Methods
	 * 
	 */
	// set the name of the course (String)
	public void setName(String name) { this.name = name; }
	
	// set the start date for the course (org.joda.time.LocalDate)
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	
	// set the end date for the course (org.joda.time.LocalDate)
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	
	// add a module to the course (Module)
	// adding a module to the course also adds this course to the Module instance
	public void addModule(Module module) { 
		if( module.getCourses().indexOf(this) == -1 )	// check if this course is not in the module's course list
			module.addCourse(this);
		if( this.getModules().indexOf(module) == -1 )	// check if the module is not in the course's module list
			modules.add(module);
	}
	
	// remove a module from the course (Module)
	// removing a module from the course also removes this course from the Module instance
	public void removeModule(Module module) { 
		if( module.getCourses().indexOf(this) != -1) 	// check if this course can be removed from the module's list
			module.removeCourse(this);
		if( this.getModules().indexOf(module) != -1)	// check if the module can be removed from the course's list
			modules.remove(module);
	}
	
	// enroll a student to the course (Student)
	// adding a student to the course sets the student's course to this course
	// associated modules are also added to the student's listed modules
	public void addStudent(Student student) {  
		if( student.getCourse() != this)			// check if the student has its course set to this instance
			student.setCourse(this);					
		if( students.indexOf(student) == -1 )		// check if this course already has the student enrolled
			students.add(student);
		for ( Module m : this.getModules() ) {		
			student.addModule(m);					// assign the associated modules to the student
		}
	}
	
	// remove a student from the course (Student)
	// removing a student from this course sets the students course field to null
	// associated modules are also removed from the student's list
	public void removeStudent(Student student) { 
		if( this.getStudents().indexOf(student) != -1) 		// check that the student can be removed from this course 
			students.remove(student);
	
		student.setCourse(null);							// set student's course to null 
		for ( Module m : this.getModules() ) {
			student.removeModule(m);						// remove the student's associated modules
		}
	}
	
	/**
	 * Accessor Methods
	 * 
	 */
	public String getName() { return name; }
	public List<Module> getModules() { return modules; }
	public List<Student> getStudents() { return students; }
	public LocalDate getStartDate() { return startDate; }
	public LocalDate getEndDate() { return endDate; }
}

