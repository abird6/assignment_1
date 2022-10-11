/**
 * This is the Module class.
 * Used by the Student and Lecturer classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import java.util.ArrayList;
import java.util.List;

public class Module {
	// instance variables
	private String id, name;
	private List<Student> students;
	private List<CourseProgramme> courses;
	private Lecturer lecturer;
	
	public Module(String id, String name, List<Student> students, List<CourseProgramme> courses, Lecturer lecturer) {
		this.id = id;
		this.name = name;
		this.students = students;
		this.courses = courses;
		this.lecturer = lecturer;
	}
	
	// overloaded constructor for instantiating independent Module objects
	public Module(String id, String name) {
		this.id = id;
		this.name = name;
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<CourseProgramme>();
		this.lecturer = new Lecturer(null, null, null, null);
	}

	
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	public void setID(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void addStudent(Student student) { 
		if ( students.indexOf(student) == -1 )				// checking if the module already has the student
			students.add(student); 
		if ( student.getModules().indexOf(this) == -1 )		// checking if the student already has the module 
			student.addModule(this);
	}
	public void removeStudent(Student student) { 
		if ( students.indexOf(student) != -1 )				// checking that the student can be removed from the module
			students.remove(student); 
		if ( student.getModules().indexOf(this) != -1 ) 	// checking that the module can be removed from the student's list
			student.removeModule(this);
	}
	public void addCourse(CourseProgramme course) { 
		if( this.getCourses().indexOf(course) == -1)
			courses.add(course);
		if( course.getModules().indexOf(this) == -1 )
			course.addModule(this);
	}
	public void removeCourse(CourseProgramme course) { 
		if( course.getModules().indexOf(this) != -1 )
			courses.remove(course); 
		if( this.getCourses().indexOf(course) != -1)
			course.removeModule(this);
	}
	public void setLecturer(Lecturer lecturer) { 
		this.lecturer = lecturer; 
		if( lecturer != null ) {
			if( lecturer.getModules().indexOf(this) == -1 )
				lecturer.addModule(this);
		}
		
	}
	
	/**
	 * 
	 * Accessor Methods
	 * 
	 */
	
	public String getID() { return id; }
	public String getName() { return name; }
	public List<Student> getStudents() { return students; }
	public List<CourseProgramme> getCourses() { return courses; }
	public Lecturer getLecturer() { return lecturer; }
	
}
