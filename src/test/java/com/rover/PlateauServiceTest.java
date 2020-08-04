package com.rover;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.rover.model.Control;
import com.rover.model.Heading;
import com.rover.model.Plateau;
import com.rover.model.Rover;
import com.rover.service.RoverService;
import com.rover.service.impl.PlateauServiceImpl;
import com.rover.service.impl.RoverServiceImpl;


/**
 * Unit Test of PlateaurService class
 * @author laghdafk
 *
 */

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {PlateauServiceImpl.class, RoverServiceImpl.class, Rover.class}, loader = AnnotationConfigContextLoader.class)
public class PlateauServiceTest {
	
	@Mock
    private RoverService roverService;
	
	@Resource
	@InjectMocks 
	private PlateauServiceImpl plateauService;
	
	@BeforeEach
	public void setUp() {
	    RoverService roverService = mock(RoverServiceImpl.class);
	    doCallRealMethod().when(roverService).leftSpin(any(Rover.class));
	}

	@Test
	public void testMoveRover() {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new Rover(0, 0, Heading.N));
		rovers.add(new Rover(2, 4, Heading.E));
		rovers.add(new Rover(3, 3, Heading.S));
		
		Plateau plateau = new Plateau(4, 4, rovers);
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
		assert(plateau.getRovers().get(indexRover).getX() == 4);
		assert(plateau.getRovers().get(indexRover).getY() == 2);
		assert(plateau.getRovers().get(indexRover).getH() == Heading.E);
		
		assert(plateau.getRovers().get(0).getX() == 0);
		assert(plateau.getRovers().get(0).getY() == 0);
		assert(plateau.getRovers().get(0).getH() == Heading.N);
		
		assert(plateau.getRovers().get(2).getX() == 3);
		assert(plateau.getRovers().get(2).getY() == 3);
		assert(plateau.getRovers().get(2).getH() == Heading.S);
		
		System.out.println("TEST MOVEROVER:------------------SUCCESS-----------");
		
	}
	

}
