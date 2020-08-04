package com.rover;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.rover.model.Heading;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.RoverService;
import com.rover.service.impl.NasaInterventionServiceImpl;
import com.rover.service.impl.PlateauServiceImpl;



/**
 * Unit Test of NasaInterventionService class
 * @author laghdafk
 *
 */

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {NasaInterventionServiceImpl.class, PlateauServiceImpl.class, Plateau.class}, loader = AnnotationConfigContextLoader.class)
public class NasaInterventionServiceTest {
	
	@Mock
    private RoverService roverService;
	
	@Resource
	@InjectMocks
	private NasaInterventionServiceImpl nasaInterventionService;
	
	@Test
	public void TestGetPlateau() {
		try {
			Plateau plateau = nasaInterventionService.getPlateau("input.txt");
			Rover rover1 = new Rover(1, 3, Heading.N);
			Rover rover2 = new Rover(5, 5, Heading.E);
			List<Rover> rovers = new ArrayList<Rover>();
			rovers.add(rover1);
			rovers.add(rover2);
			Plateau expectedPlateau = new Plateau(5, 5, rovers);
			assertThat(plateau).isNotNull();
			assert(plateau.equals(expectedPlateau));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
