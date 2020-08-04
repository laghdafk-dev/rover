package com.rover.model;


/**
 * The rover's model constituted by two positional coordinates x and y 
 * and a heading that can be changed 
 * @author laghdafk
 *
 */

public class Rover {
	private int x;
	private int y;
	private Heading h;
	
	/**
	 * Constructor of rover with parameters
	 * @param x
	 * @param y
	 * @param h
	 */
	public Rover(int x, int y, Heading h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}

	/**
	 * get x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * set this.x to x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * increments x by one
	 */
	public void incrementX() {
		x++;
	}
	
	/**
	 * decrement x by one
	 */
	public void decrementX() {
		x--;
	}
	
	/**
	 * get y
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * set this.y to y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * increment y by one
	 */
	public void incrementY() {
		y++;
	}
	
	/**
	 * decrement y by one
	 */
	public void decrementY() {
		y--;
	}
	
	/**
	 * get h the rover's heading
	 * @return h
	 */
	public Heading getH() {
		return h;
	}

	/**
	 * set value of heading to h
	 * @param h
	 */
	public void setH(Heading h) {
		this.h = h;
	}
	
	/**
	 * Override equals method for Rover instances
	 */
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
        // Check if obj is an instance of Rover or not 
        if (!(obj instanceof Rover)) { 
            return false; 
        } 
          
        // typecast obj to Rover so that we can compare data members  
        Rover rover = (Rover) obj; 
          
        // Compare the data members and return accordingly
        return ((this.x == rover.getX()) && (this.y == rover.getY()) && (this.h == rover.getH()));

	}
	/**
	 * returns the rover as a string
	 */
	@Override
	public String toString() {
		return x + " " + y + " " + h;
	}

}
