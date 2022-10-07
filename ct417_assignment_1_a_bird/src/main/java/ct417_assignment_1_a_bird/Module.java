/**
 * This is the Module class.
 * Used by the Student and Lecturer classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import java.util.List;

public class Module {
	// instance variables
	private String id, name;
	private List<Student> students;
	private List<CourseProgramme> courses;
	private Lecturer lecturer;
	
	Module(String id, String name, List<Student> students, List<CourseProgramme> courses, Lecturer lecturer) {
		this.id = id;
		this.name = name;
		this.students = students;
		this.courses = courses;
		this.lecturer = lecturer;
	}
	
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	public void setID(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void addStudent(Student student) { students.add(student); }
	public void removeStudent(Student student) { students.remove(student); }
	public void addCourse(CourseProgramme course) { courses.add(course); }
	public void removeCourse(CourseProgramme course) { courses.remove(course); }
	public void setLecturer(Lecturer lecturer) { this.lecturer = lecturer; }
	
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
