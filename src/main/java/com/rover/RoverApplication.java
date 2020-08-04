/**
 * The rover application 
 *
 * main class extends CommandLineRunner and re-implements its run method
 * that launches the intervention of NASA on Mars using the 
 * nasaInterventionService that takes as input the file input.txt
 * containing information about rovers and move controls
 * and writes the final position and heading for each rover as output
 * @input input.txt the name of the input file with rovers data
 * @output rovers final position and heading
 * @author laghdafk
 */


package com.rover;


import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.NasaInterventionService;

@SpringBootApplication
public class RoverApplication implements CommandLineRunner {

	@Resource
	private NasaInterventionService nasaInterventionService;
	
	
	/**
	 * run method launches nasaInterventionService getPlateau
	 * taking as argument 
	 * @param input.txt in arsg[0]
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

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RoverApplication.class, args);
	}
}
