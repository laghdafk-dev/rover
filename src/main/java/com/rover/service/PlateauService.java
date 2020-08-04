package com.rover.service;


import java.util.List;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Control;
import com.rover.model.Plateau;


/**
 * Interface PlateauService that moves a rover on mars plateau following a list of 
 * controls   
 * @author laghdafk
 */

public interface PlateauService {
	
	/**
	 * moves a rover on mars plateau following a list of 
	 * controls   
	 * @param plateau
	 * @param indexRover
	 * @param controls
	 * @throws UnknownMoveException
	 * @throws ImpossibleMoveException
	 */
	void moveRover(Plateau plateau, int indexRover, List<Control> controls) 
			throws UnknownMoveException, ImpossibleMoveException;
}
