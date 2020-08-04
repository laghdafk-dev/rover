package com.rover.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rover.MyAppTests;
import com.rover.model.Heading;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.RoverService;
import com.rover.service.impl.NasaInterventionServiceImpl;



/**
 * Unit Test of NasaInterventionService class
 * @author laghdafk
 *
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppTests.class)
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
			assertTrue(expectedPlateau.equals(plateau));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TEST GETPLATEAU:------------------SUCCESS-----------");

		
	}
	

}
