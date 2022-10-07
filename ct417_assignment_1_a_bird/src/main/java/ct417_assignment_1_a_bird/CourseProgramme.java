/**
 * This is the CourseProgramme class.
 * Used by Module and Student classes
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import java.util.List;

import org.joda.time.LocalDate;

public class CourseProgramme {
	// instance variables
	private String name;
	private List<Module> modules;
	private List<Student> students;
	private LocalDate startDate, endDate;
	
	CourseProgramme(String name, List<Module> modules, List<Student> students, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.modules = modules;
		this.students = students;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * 
	 * Mutator Methods
	 * 
	 */
	public void setName(String name) { this.name = name; }
	public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
	public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
	public void addModule(Module module) { modules.add(module); }
	public void removeModule(Module module) { modules.remove(module); }
	public void addStudent(Student student) { students.add(student); }
	public void removeStudent(Student student) { students.remove(student); }
	
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

