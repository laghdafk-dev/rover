package com.rover.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Control;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.PlateauService;
import com.rover.service.RoverService;

/**
 * Implementation of PlateauService
 * @author laghdafk
 * 
 */

@Component
public class PlateauServiceImpl implements PlateauService {

	@Resource
	private RoverService roverService;
	
	/**
	 * Moves, if possible, the rover stored in indexRover of  
	 * the plateau following the list of controls in parameter
	 * @param indexRover
	 * @param controls
	 * @throws UnknownMoveException
	 * @throws ImpossibleMoveException
	 */
	public void moveRover(Plateau plateau, int indexRover, List<Control> controls) throws UnknownMoveException, ImpossibleMoveException {
		Rover roverToMove = plateau.getRovers().get(indexRover);
		for (Control control: controls) {
			switch (control) {
			case L:
				roverService.leftSpin(roverToMove);
				break;
			case R:
				roverService.rightSpin(roverToMove);
				break;
			case M:
				roverService.moveForward(roverToMove, plateau.getxMax(), plateau.getyMax());
				break;
			default:
				throw new UnknownMoveException();
			}
		}
	}
}
