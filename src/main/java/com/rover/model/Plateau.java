package com.rover.model;
/**
 * The mars plateau's model defined by the coordinates of the
 * upper right point xMax and yMax and the list of rovers 
 * landing on that plateau
 * @author laghdafk
 */

/*
 * external imports
 */
import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int xMax; //coordinate x of the upper right point 
	private int yMax; //coordinate y of the upper right point 
	private List<Rover> rovers; //list of all rovers on the plateau
	
	public Plateau() {
		this.xMax = 0;
		this.yMax = 0;
		this.rovers = new ArrayList<Rover>();
	}

	/**
	 * @param xMax
	 * @param yMax
	 * @param rovers
	 */
	public Plateau(int xMax, int yMax, List<Rover> rovers) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.rovers = rovers;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}
	
	public boolean addRover(Rover rover) {
		return this.rovers.add(rover);
	}

	@Override
	public String toString() {
		return "Plateau [xMax=" + xMax + ", yMax=" + yMax + ", rovers=" + rovers + "]";
	}
}
