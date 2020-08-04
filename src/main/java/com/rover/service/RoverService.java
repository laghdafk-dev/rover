package com.rover.service;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Rover;


/**
 * Interface RoverService that makes the rover spin to the left and to the right 
 * and move forward in its heading direction, if possible, on a plateau 
 * with an upper right point xMax, yMax
 * @author laghdafk
 *
 */

public interface RoverService {
	
	/**
	 * spin the rover 90 degrees to the left
	 * @param rover
	 */
	void leftSpin(Rover rover);
	
	/**
	 * spin the rover 90 degrees to the right
	 * @param rover
	 */
	void rightSpin(Rover rover);
	
	/**
	 * move the rover forward in its heading direction, if possible, on a plateau 
	 * with an upper right point xMax, yMax
	 * @param rover
	 * @param xMax
	 * @param yMax
	 * @return
	 * @throws ImpossibleMoveException
	 * @throws UnknownMoveException
	 */
	boolean moveForward(Rover rover, int xMax, int yMax) throws ImpossibleMoveException, UnknownMoveException;
}
