package com.rover.model;


import java.util.ArrayList;
import java.util.List;


/**
 * The mars plateau's model defined by the coordinates of the
 * upper right point xMax and yMax and the list of rovers 
 * landing on that plateau
 * @author laghdafk
 */

public class Plateau {
	private int xMax; //coordinate x of the upper right point 
	private int yMax; //coordinate y of the upper right point 
	private List<Rover> rovers; //list of all rovers on the plateau
	
	/**
	 * Default constructor 
	 */
	public Plateau() {
		this.xMax = 0;
		this.yMax = 0;
		this.rovers = new ArrayList<Rover>();
	}

	/**
	 * Constructor  with parameters
	 * @param xMax
	 * @param yMax
	 * @param rovers
	 */
	public Plateau(int xMax, int yMax, List<Rover> rovers) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.rovers = rovers;
	}

	/**
	 * get xMax
	 * @return xMax
	 */
	public int getxMax() {
		return xMax;
	}

	/**
	 * set this.xMax to xMax
	 * @param xMax
	 */
	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * get yMax
	 * @return yMax
	 */
	public int getyMax() {
		return yMax;
	}

	/**
	 * set this.yMax to yMax
	 * @param yMax
	 */
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
	
	/**
	 * get list of rovers
	 * @return rovers
	 */
	public List<Rover> getRovers() {
		return rovers;
	}
	
	/**
	 * set list of rovers to rovers
	 * @param rovers
	 */
	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}
	
	/**
	 * adds the rover to this.rovers
	 * and return true if added
	 * @param rover
	 * @return boolean 
	 */
	public boolean addRover(Rover rover) {
		return this.rovers.add(rover);
	}
	
	/**
	 * Override equals method for Plateau instances
	 */
	@Override
	public boolean equals(Object obj) {
		// If the object is compared with itself then return true   
        if (obj == this) { 
            return true; 
        } 
  
        // Check if obj is an instance of Plateau or not 
        if (!(obj instanceof Plateau)) { 
            return false; 
        } 
          
        // typecast obj to Plateau so that we can compare data members  
        Plateau plateau = (Plateau) obj; 
          
        // Compare the data members and return accordingly
        return (this.xMax == plateau.getxMax()) && (this.yMax == plateau.getyMax()) && (this.rovers.equals(plateau.getRovers()));

	}

	/**
	 * return the plateau as a string
	 */
	@Override
	public String toString() {
		return "Plateau [xMax=" + xMax + ", yMax=" + yMax + ", rovers=" + rovers + "]";
	}
}
