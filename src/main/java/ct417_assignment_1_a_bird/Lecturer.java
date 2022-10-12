/**
 * This is the Lecturer class ( final implementation )
 * Instances of this class are tightly coupled with Module objects
 * @author Anthony Bird
 * email: a.bird6@universityofgalway.ie
 */

package ct417_assignment_1_a_bird;

import org.joda.time.*;
import java.util.ArrayList;
import java.util.List;

public class Lecturer {
	
	// instance variables
	private String id, name, age;		// lecturer's staff ID, full name and age
	private LocalDate dob;				// lecturer's date of birth
	private List<Module> modules;		// list of modules the lecturer teaches
	
	public Lecturer(String id, String name, String age, LocalDate dob, List<Module> modules) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.modules = modules;
	}
	
	/**
	 * Constructor used if no module list is included
	 * New list of modules will be instantiated
	 *
	 */
	public Lecturer(String id, String name, String age, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.modules = new ArrayList<Module>();
	}

	
	/**
	 * Mutator Methods
	 * 
	 */
	// set the staff ID of the lecturer (String)
	public void setID(String id) { this.id = id; }
	
	// set the name of the lecturer (String)
	public void setName(String name) { this.name = name; }
	
	// set the age of the lecturer (String)
	public void setAge(String age) { this.age = age; }
	
	// set the date of birth of the lecturer (org.joda.time.LocalDate)
	public void setDOB(LocalDate dob) {	this.dob = dob; }
	
	// add a module to the lecturer's list of taught modules (Module)
	// adding a module here sets the module's lecturer to this instance
	public void addModule(Module module) { 
		if( this.getModules().indexOf(module) == -1 )		// check that the lecturer does not have the module assigned
			modules.add(module);
		if( module.getLecturer() != this )					// check that the module does not have its lecturer set to this instance 
			module.setLecturer(this);
	}
	
	// remove a module from the lecturer's list of taught modules (Module)
	// removing a module from here sets the module's lecturer to null
	public void removeModule(Module module) { 
		if( this.getModules().indexOf(module) != -1)		// check that the module can be removed 
			modules.remove(module);	
		if( module.getLecturer() == this)					// if the module's lecturer is this instance, set lecturer to null
			module.setLecturer(null);
	}
	
	/**
	 * Accessor Methods
	 * 
	 */
	public String getID() { return id; }
	public String getName() { return name; }
	public String getAge() { return age; }
	public LocalDate getDOB() { return dob; }
	public List<Module> getModules() { return modules; }
	
	// generate a username by combining name and age fields
	// method removes any whitespace in full names
	public String getUsername() { return name.replaceAll(" ", "") + this.age; }
}

