package com.rover.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rover.MyAppTests;
import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Heading;
import com.rover.model.Rover;
import com.rover.service.RoverService;




/**
 * Unit Test of RoverService class
 * @author laghdafk
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppTests.class)
public class RoverServiceTest {
	
	@Resource
	private RoverService roverService;
	
	@Test
	public void testLeftSpin() {
		int x = 1;
		int y = 1;
		Heading h = Heading.N;
		Rover rover = new Rover(x, y, h);
		  
		roverService.leftSpin(rover);
		assertEquals(x, rover.getX());
		assertEquals(y, rover.getY());
		assertEquals(Heading.E, rover.getH());
		  
		roverService.leftSpin(rover);
		assertEquals(x, rover.getX());
		assertEquals(y, rover.getY());
		assertEquals(Heading.S, rover.getH());
		 
		roverService.leftSpin(rover);
		assertEquals(x, rover.getX());
		assertEquals(y, rover.getY());
		assertEquals(Heading.W, rover.getH());

		 
		roverService.leftSpin(rover);
		assertEquals(x, rover.getX());
		assertEquals(y, rover.getY());
		assertEquals(Heading.N, rover.getH());
		  
		System.out.println("TEST LEFTSPIN:------------------SUCCESS-----------");
	  }
	
	  @Test
	  public void testRightSpin() {
		  int x = 1;
		  int y = 1;
		  Heading h = Heading.N;
		  Rover rover = new Rover(x, y, h);
		  
		  roverService.rightSpin(rover);
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(Heading.W, rover.getH());
		  
		  roverService.rightSpin(rover);
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(Heading.S, rover.getH());
		  
		  roverService.rightSpin(rover);
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(Heading.E, rover.getH());
		  
		  roverService.rightSpin(rover);
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(Heading.N, rover.getH());
		  
		  System.out.println("TEST RIGHTSPIN:------------------SUCCESS-----------");
	  }
	  
	  @Test
	  public void testMoveForward() {
		  int x = 1;
		  int y = 1;
		  Heading h = Heading.N;
		  Rover rover = new Rover(x, y, h);
		  
		  int xMax=4; 
		  int yMax=5;
		  
		  try {
			  for (int i=0; i<4; i++) {
				  roverService.moveForward(rover, xMax, yMax);
				  y++;
				  assertEquals(x, rover.getX());
				  assertEquals(y, rover.getY());
				  assertEquals(h, rover.getH());
			  }
		  } catch (UnknownMoveException e) {
			  fail("UnknownMoveException wrongly thrown");
		  } catch (ImpossibleMoveException e) {
			  fail("ImpossibleMoveException wrongly thrown");
		  }
		  
		  assertThrows(ImpossibleMoveException.class, () -> {
			  roverService.moveForward(rover, xMax, yMax);
			  });
		  
		  h = Heading.E;
		  rover.setH(h);
		  roverService.moveForward(rover, xMax, yMax);
		  x++;
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(h, rover.getH());
		  
		  h = Heading.S;
		  rover.setH(h);
		  roverService.moveForward(rover, xMax, yMax);
		  y--;
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(h, rover.getH());
		  
		  h = Heading.W;
		  rover.setH(h);
		  roverService.moveForward(rover, xMax, yMax);
		  x--;
		  assertEquals(x, rover.getX());
		  assertEquals(y, rover.getY());
		  assertEquals(h, rover.getH());
		  
		  System.out.println("TEST MOVEFORWARD:------------------SUCCESS-----------");
	  }

}
