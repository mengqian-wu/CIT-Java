import java.util.ArrayList;

/**
 * Represents a classroom with students 
 * Each classroom has a list of students 
 * and an array that represents the seats in the classroom.
 * @author fengliang
 *
 */
public class Classroom {
	
	//instance vars 
	/**
	 * Name of building
	 */
	String buildingName; 
	
	/**
	 * Name of classroom
	 */
	String roomName;
	
	/** 
	 * List of students in the classroom 
	 */
	//import ArrayList java.util & create Student class
	ArrayList<Student> students; 
	
	/**
	 * Seats in the classroom
	 */
	Seat[][] seats; //create seat class
	
	/**
	 * Creates a classroom with given building name, room name, number of rows of seats, and number of columns of seats 
	 * @param buildingName: name of building
	 * @param roomName: name of room 
	 * @param rows for seats
	 * @param columns for seats 
	 */
	//constructor 
	public Classroom(String buildingName, String roomName, int rows, int columns) {
		// set building name 
		this.buildingName = buildingName; 
		
	    // set room name 
		this.roomName = roomName; 
		
		//initialize seats array 
		this.seats = new Seat[rows][columns]; 
		
		//populate seats array with instances of seat class 
		//iterate over rows 
		for (int i = 0; i < rows; i++) {
			// iterate over columns 
			for (int j = 0; j < columns; j++) {
				// give each location its own new instance of seat class
				// give i (row) and j (column) location in the array 
				seats[i][i] = new Seat(i, j); 
				
			}
		}
		// initialize list of students
		this.students = new ArrayList<Student>(); 
		
		
	}
	
	/**
	 * Adds the given student to list of students
	 * @param student to add
	 */
	public void addAStudent(Student student) {
		this.students.add(student); 
	}
	
	/**
	 * Find an available seat and assign it to given student: iterate over seat until we find the available seat 
	 * @param student
	 */
	public void assignStudentToSeat(Student student) {
		int rows = this.seats.length; //gets the number of rows of seats
		int columns = this.seats[0].length; // gets the number of columns of seats 
		
		// iterate over the rows and columns 
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// get seat in location and see if it's availabel by checking if there is a student in the seat 
				if (this.seats[i][j].studentInSeat == null) {
					
					// if null, no student has been assigned to it 
					this.seats[i][j].putStudentInSeat(student);
					
					// exit loop and method all at once 
					return; 
				}
			}
		}
		
	}
	/**
	 * Print all students in the classroom.
	 */
	public void printAllStudents() {
		System.out.println("Students in class: "); 
		for (Student student: this.students) {
			System.out.println(student); // this will call the toString method in the student class 	
		}
	}
	
	public String toString() {
		String s = "\n"; 
		
		int rows = this.seats.length; //gets the number of rows of seats 
		int columns = this.seats[0].length;// gets the number of columns of seats 
				
		// iterate over the rows and columns 
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				s += this.seats[i][j] + "\t"; // calls the toString method in the seat class 
			}
			s += "\n"; // adds newline at end of each row 
		}
	    return s; 
	}
	
	/**
	 * Return layout of classroom, with seat and student 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create classroom 
		Classroom hunstman = new Classroom("HH", "105", 10, 5); 
		
       // create students 
		Student finegan = new Student("finegan", "fineganw"); 
		Student bob = new Student("bob", "roberts"); 
		
		// add students to classroom 
		hunstman.addAStudent(finegan);
		hunstman.addAStudent(bob); 
		
		// assign students to seats 
		hunstman.assignStudentToSeat(finegan);
		hunstman.assignStudentToSeat(bob); 
		
		// print list of all students in class 
		hunstman.printAllStudents(); 
		
		// print classroom itself 
		System.out.println(hunstman); // this will also call the toString method in the classroom class 
	}
}
