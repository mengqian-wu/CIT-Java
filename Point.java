
/** 
 * Represents a point with x and y 
 * @author fengliang
 *
 */
public class Point {
    
	//instance vars 
	/**
	 * x for point 
	 */
	int x; 
	
	/**
	 * y for point 
	 */
	int y; 
	
	/**
	 * sum of x and y
	 */
	int sum; 
	
	//constructor 
	/**
	 * Creates a point at the given x and y
	 * @param x for point
	 * @param y for point
	 */
	public Point(int x, int y) {
		this.x = x; 
		this.y = y; 
		this.sum = x + y; 
	}
	
	/**
	 * Creates a point at the gicen x and y
	 */
	public Point() {
		//calls the first constructor with default values, 0 and 0 
		//the second constructor calls the first constructor by using the keyword 'this' and providing the necesasry arguments, default values for x and y.
		this(0, 0); 
	}
	public static void main(String[] args) {
		
		Point point1 = new Point(2, 4);
		System.out.println(point1.x);
		System.out.println(point1.y); 
		System.out.println(point1.sum); 
		
		// this should be the default one 
		Point point2 = new Point();
		System.out.println(point2.x);
		System.out.println(point2.y); 
		System.out.println(point2.sum); 
			

	}

}
