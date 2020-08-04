package com.rover.service;


import static org.mockito.Mockito.doCallRealMethod;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*; 

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rover.MyAppTests;
import com.rover.model.Control;
import com.rover.model.Heading;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.PlateauService;
import com.rover.service.RoverService;


/**
 * Unit Test of PlateaurService class
 * @author laghdafk
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppTests.class) 
public class PlateauServiceTest {
		
	@Resource
	private PlateauService plateauService;
	
	@MockBean
    private RoverService roverService;
	
	@BeforeEach
	public void setUp() {
	    doCallRealMethod().when(roverService).leftSpin(ArgumentMatchers.any(Rover.class));
	    doCallRealMethod().when(roverService).rightSpin(ArgumentMatchers.any(Rover.class));
	    doCallRealMethod().when(roverService).moveForward(ArgumentMatchers.any(Rover.class), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
	}

	@Test
	public void testMoveRover() {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new Rover(0, 0, Heading.N));
		rovers.add(new Rover(2, 4, Heading.E));
		rovers.add(new Rover(3, 3, Heading.S));
		
		Plateau plateau = new Plateau(16, 16, rovers);
		int indexRover = 1;
		List<Control> controls = new ArrayList<Control>();
		controls.add(Control.M);
		controls.add(Control.L);
		controls.add(Control.M);
		controls.add(Control.M);
		controls.add(Control.R);
		controls.add(Control.M);
		System.out.println(controls);
		System.out.println(plateau.getRovers());
		
		plateauService.moveRover(plateau, indexRover, controls);
		System.out.println(plateau.getRovers().get(indexRover));
		assertEquals(2, plateau.getRovers().get(indexRover).getX());
		assertEquals(4,plateau.getRovers().get(indexRover).getY());
		assertEquals(Heading.E, plateau.getRovers().get(indexRover).getH());
		
		assertEquals(0, plateau.getRovers().get(0).getX());
		assertEquals(0,plateau.getRovers().get(0).getY());
		assertEquals(Heading.N, plateau.getRovers().get(0).getH());
		
		assertEquals(3, plateau.getRovers().get(2).getX());
		assertEquals(3, plateau.getRovers().get(2).getY());
		assertEquals(Heading.S, plateau.getRovers().get(2).getH());
		
		System.out.println("TEST MOVEROVER:------------------SUCCESS-----------");
		
	}
	

}
