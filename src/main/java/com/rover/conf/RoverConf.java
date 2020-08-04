package com.rover.conf;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.NasaInterventionService;

@Configuration
public class RoverConf implements CommandLineRunner {
	@Resource
	private NasaInterventionService nasaInterventionService;
	
	/**
	 * run method launches nasaInterventionService.getPlateau
	 * taking as argument the input file and writes the final
	 * position and heading of each rover as output
	 * @param input.txt in args[0]
	 */
	@Override
	public void run(String... args) {
		try {
			Plateau plateau = nasaInterventionService.getPlateau(args[0]);
			for (Rover rover : plateau.getRovers()) {
				System.out.println(rover);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error while trying to read the input file");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnknownMoveException e) {
			e.printStackTrace();
		} catch (ImpossibleMoveException e) {
			e.printStackTrace();
		}
	}
}