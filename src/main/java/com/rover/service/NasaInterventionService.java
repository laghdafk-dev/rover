package com.rover.service;

import java.io.IOException;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Plateau;

public interface NasaInterventionService {
	Plateau getPlateau(String filePath) throws UnknownMoveException, ImpossibleMoveException, IOException;
}
