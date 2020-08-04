/**
 * The rover's service makes the rover spin to the left and to the right 
 * and move forward in its heading direction, if possible, on a plateau 
 * with an upper right point xMax, yMax
 * @author laghdafk
 *
 */

package com.rover.service;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Rover;

public interface RoverService {
	void leftSpin(Rover rover);
	void rightSpin(Rover rover);
	boolean moveForward(Rover rover, int xMax, int yMax) throws ImpossibleMoveException, UnknownMoveException;
}
