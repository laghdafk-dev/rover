package com.rover.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Heading;
import com.rover.model.Rover;
import com.rover.service.RoverService;

/**
 * Implementation of RoverService interface
 * @author laghdafk
 *
 */

@Component
public class RoverServiceImpl implements RoverService{

	/**
	 * Makes the rover spin 90 degrees left starting from
	 * its current heading
	 */
	public void leftSpin(Rover rover) {
		List<Heading> headings = new ArrayList<Heading>();
		headings.add(Heading.N);
		headings.add(Heading.E);
		headings.add(Heading.S);
		headings.add(Heading.W);
		Heading currentHeading = rover.getH();
		int currentHeadingIndex = headings.indexOf(currentHeading);
		int newHeadingIndex = (currentHeadingIndex +1) % 4;
		Heading newHeading = headings.get(newHeadingIndex);
		rover.setH(newHeading);
	}

	
	/**
	 * Makes the rover spin 90 degrees right starting from
	 * its current heading
	 */
	public void rightSpin(Rover rover) {
		List<Heading> headings = new ArrayList<Heading>();
		headings.add(Heading.N);
		headings.add(Heading.E);
		headings.add(Heading.S);
		headings.add(Heading.W);
		Heading currentHeading = rover.getH();
		int currentHeadingIndex = headings.indexOf(currentHeading);
		int newHeadingIndex = (currentHeadingIndex + 3) % 4;
		Heading newHeading = headings.get(newHeadingIndex);
		rover.setH(newHeading);
	}
	
	/**
	 * Makes the rover move forward one grid point  
	 * in the direction of its current heading
	 * if the move is possible
	 * @param xMax
	 * @param yMax
	 * @throws UnknownMoveException, ImpossibleMoveException
	 */
	public boolean moveForward(Rover rover, int xMax, int yMax) throws ImpossibleMoveException, UnknownMoveException {
		switch (rover.getH()) {
		case N:
			if (rover.getY() < yMax) {
				rover.incrementY();
				return true;
			} else {
				throw new ImpossibleMoveException("Rover could not move to the North");
			}

		case E:
			if (rover.getX() < xMax) {
				rover.incrementX();
				return true;
			} else {
				System.out.println("Rover could not move to the Est");
				return false;
			}

		case S:
			if (rover.getY() > 0) {
				rover.decrementY();
				return true;
			} else {
				System.out.println("Rover could not move to the South");
				return false;
			}
			
		case W:
			if (rover.getX() > 0) {
				rover.decrementX();
				return true;
			} else {
				System.out.println("Rover could not move to the West");
				return false;
			}

		default:
			throw new UnknownMoveException();
		}
	}
}
