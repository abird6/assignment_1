/**
 * This is the Module class ( final implementation )
 * Instances of this class are tightly coupled with Student, CourseProgramme and Lecturer objects
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 *
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;

public class Module {
	
	// instance variables
	private String id, name;					// module code and full name
	private List<Student> students;				// list of students registered in the module
	private List<CourseProgramme> courses;		// list of courses the module is a part of
	private Lecturer lecturer;					// lecturer that teaches the module
	
	public Module(String id, String name, List<Student> students, List<CourseProgramme> courses, Lecturer lecturer) {
		this.id = id;
		this.name = name;
		this.students = students;
		this.courses = courses;
		this.lecturer = lecturer;
	}
	
	/**
	 * Constructor used if no Lecturer or list of students/courses are included
	 * New place holder object will be instantiated
	 *
	 */ 
	public Module(String id, String name) {
		this.id = id;
		this.name = name;
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<CourseProgramme>();
		this.lecturer = new Lecturer(null, null, null, null);
	}

	
	/**
	 * Mutator Methods
	 * 
	 */
	// set the module code (String)
	public void setID(String id) { this.id = id; }
	
	// set the name of the module (String)
	public void setName(String name) { this.name = name; }
	
	// add a student to the module (Student)
	// adding a student to this instance adds this module to the student's list of modules
	public void addStudent(Student student) { 
		if ( students.indexOf(student) == -1 )				// check if the student is already included in the module
			students.add(student); 
		if ( student.getModules().indexOf(this) == -1 )		// check if the student has added the module
			student.addModule(this);
	}
	
	// remove a student from the module (Student)
	// removing a student from this instance removes this module from the student's list of modules
	public void removeStudent(Student student) { 
		if ( students.indexOf(student) != -1 )				// check if the student can be removed 
			students.remove(student); 
		if ( student.getModules().indexOf(this) != -1 ) 	// check if this instance can be removed from the student's list
			student.removeModule(this);
	}
	
	// add an associated course to the module (CourseProgramme)
	// adding a course to this instance adds this module to the course object
	public void addCourse(CourseProgramme course) { 
		if( this.getCourses().indexOf(course) == -1)		// check if this instance is not already associated with the course
			courses.add(course);
		if( course.getModules().indexOf(this) == -1 )		// check if the course is not already associated with this instance
			course.addModule(this);
	}
	
	// remove an associated course from this instance (CourseProgramme)
	// removing a course from this instance removes this module from the course object
	public void removeCourse(CourseProgramme course) { 
		if( course.getModules().indexOf(this) != -1 )		// check if the course can be removed from this instance 
			courses.remove(course); 
		if( this.getCourses().indexOf(course) != -1)		// check if this instance can be removed from the course
			course.removeModule(this);
	}
	
	// assigns a lecturer to this instance (Lecturer)
	// assigning a lecturer to this instance adds this module to the lecturer's list of taught modules
	public void setLecturer(Lecturer lecturer) { 
		this.lecturer = lecturer; 
		if( lecturer != null ) {						
			if( lecturer.getModules().indexOf(this) == -1 )
				lecturer.addModule(this);
		}
	}
	
	/**
	 * Accessor Methods
	 * 
	 */
	public String getID() { return id; }
	public String getName() { return name; }
	public List<Student> getStudents() { return students; }
	public List<CourseProgramme> getCourses() { return courses; }
	public Lecturer getLecturer() { return lecturer; }
}
