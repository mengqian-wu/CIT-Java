/**
 * Represents a student in the class.
 * Each student has a name and ID. 
 * @author fengliang
 *
 */
public class Student {
	// instance vars 
	String name; 
	String ID; 
	// constructor 
	/**
	 * Create a student with the given name and ID
	 * @param name of student
	 * @param ID for student
	 */
	public Student(String name, String ID) {
		this.name = name; 
		this.ID = ID; 
	}
	
	/**
	 * returns name of student to print object student 
	 */
	public String toString() {
		return this.name; 
	}
	

}
