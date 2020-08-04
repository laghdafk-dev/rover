/**
 * The rover's model constituted by two positional coordinates x and y 
 * and a heading that can be changed 
 * @author laghdafk
 *
 */
package com.rover.model;


public class Rover {
	private int x;
	private int y;
	private Heading h;
	
	/**
	 * @param x
	 * @param y
	 * @param h
	 */
	public Rover(int x, int y, Heading h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void incrementX() {
		x++;
	}
	
	public void decrementX() {
		x--;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void incrementY() {
		y++;
	}
	
	public void decrementY() {
		y--;
	}

	public Heading getH() {
		return h;
	}

	public void setH(Heading h) {
		this.h = h;
	}
	
	@Override
	public String toString() {
		return x + " " + y + " " + h;
	}

}
