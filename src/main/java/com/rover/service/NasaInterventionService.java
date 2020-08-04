package com.rover.service;


import java.io.IOException;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Plateau;


/**
 * Interface of the NasaInterventionService that creates the mars plateau after 
 * moving rovers using data from the input file
 */

public interface NasaInterventionService {
	
	/**
	 * method get plateau using data from the input file
	 * @param filePath
	 * @return plateau
	 * @throws UnknownMoveException
	 * @throws ImpossibleMoveException
	 * @throws IOException
	 */
	Plateau getPlateau(String filePath) throws UnknownMoveException, ImpossibleMoveException, IOException;
}
