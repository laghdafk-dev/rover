package com.rover.service.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Control;
import com.rover.model.Heading;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.NasaInterventionService;
import com.rover.service.PlateauService;

/**
 * Implementation of NasaInterventionService interface
 * @author laghdafk
 *
 */

@Component
public class NasaInterventionServiceImpl implements NasaInterventionService {

	@Resource
	private PlateauService plateauService;

	/**
	 * Implementation of getPlateau
	 * @param filePath
	 */
	public Plateau getPlateau(String filePath) throws UnknownMoveException, ImpossibleMoveException, IOException {
		// Initialise the plateau on Mars
		Plateau plateau = new Plateau();

		/*
		 * Read data from the input file and make the NASA intervention on Mars
		 */
		ClassPathResource inputFile = new ClassPathResource(filePath);
		InputStreamReader isr = new InputStreamReader(inputFile.getInputStream());

		List<String> lines;
		try (BufferedReader myReader = new BufferedReader(isr)) {
			lines = myReader.lines().filter((line) -> line != null && line.length() != 0).collect(Collectors.toList());
		}
		
		String firstLine = lines.get(0); // first element
		String[] maxCoordinates = firstLine.split(" ", 2);
		plateau.setxMax(Integer.parseInt(maxCoordinates[0]));
		plateau.setyMax(Integer.parseInt(maxCoordinates[1]));

		List<Rover> rovers = IntStream.range(0, lines.size()).filter(i -> i % 2 == 1).mapToObj(lines::get).map(line -> {
			String[] initialPosition = line.split(" ", 3);
			return new Rover(Integer.parseInt(initialPosition[0]), Integer.parseInt(initialPosition[1]),
					Heading.valueOf(initialPosition[2]));
		}).collect(Collectors.toList()); // lignes impaires

		plateau.setRovers(rovers);

		List<List<Control>> listControlLines = IntStream.range(1, lines.size()).filter(i -> i%2==0).mapToObj(lines::get)
				.map(line -> line.chars().mapToObj(c -> Control.valueOf("" + (char) c)).collect(Collectors.toList()))
				.collect(Collectors.toList()); // lignes impaires
		
		for(int i=0; i<listControlLines.size(); i++) {			
			plateauService.moveRover(plateau, i, listControlLines.get(i));
		}
		return plateau;
	}
}