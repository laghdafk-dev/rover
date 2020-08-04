/**
 * The plateau's service moves a rover on mars plateau following a list of 
 * controls   
 * @author laghdafk
 */
package com.rover.service;

import java.util.List;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Control;
import com.rover.model.Plateau;

public interface PlateauService {
	void moveRover(Plateau plateau, int indexRover, List<Control> controls) throws UnknownMoveException, ImpossibleMoveException;
}
