/**
 * Represent a seat in a classroom .
 * each seat has a row and column associated with it
 * It also MIGHT have a student assigned to it. 
 * @author fengliang
 *
 */
public class Seat {
	
	// instance vars 
	/**
	 * seat row.
	 */
	int row; 
	
	/**
	 * Seat column
	 */
	int column; 
	
	/**
	 * Student assigned to this seat, otherwise null.
	 */
	Student studentInSeat; // this is null until we assign a given student
	
	//constructor 
	/**
	 * Creates a seat for a class at the given row and colum
	 * @param row for seat
	 * @param column for seat 
	 */
	
	public Seat(int row, int column) {
		this.row = row; 
		this.column = column; 
	}
	
	//methods 
	/** 
	 * Assigns the given student to this seat.
	 * @param student to assign
	 */
	public void putStudentInSeat(Student student) {
		this.studentInSeat = student; 
	}
	
	/**
	 * Returns the row, column, and student for this seat. 
	 */
	public String toString() {
		return this.row + "," + this.column +":" + this.studentInSeat; // this will also call the toString method 
		
	}

}
