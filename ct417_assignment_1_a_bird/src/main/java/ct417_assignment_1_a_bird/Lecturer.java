/**
 * This is the Lecturer class
 * @author Anthony Bird
 *
 */

package ct417_assignment_1_a_bird;

import org.joda.time.*;
import java.util.List;

public class Lecturer {
	// instance variables
	private String id, name, age;
	private LocalDate dob;
	private List<Module> modules;
	
	public Lecturer(String id, String name, String age, LocalDate dob, List<Module> modules) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.modules = modules;
	}
	
	// overloaded constructor for instantiating independent Lecturer objects
	public Lecturer(String id, String name, String age, LocalDate dob) {
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
	public void setDOB(LocalDate dob) {	this.dob = dob; }
	public void addModule(Module module) { this.modules.add(module); }
	public void removeModule(Module module) { this.modules.remove(module);	}
	
	/**
	 * 
	 * Accessor Methods
	 * 
	 */
	
	public String getID() { return id; }
	public String getName() { return name; }
	public String getAge() { return age; }
	public LocalDate getDOB() { return dob; }
	public List<Module> getModules() { return modules; }
	public String getUsername() { return name.replaceAll(" ", "") + this.age; }
}

