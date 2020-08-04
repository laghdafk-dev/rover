package com.rover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.rover.exception.ImpossibleMoveException;
import com.rover.exception.UnknownMoveException;
import com.rover.model.Heading;
import com.rover.model.Rover;
import com.rover.service.RoverService;
import com.rover.service.impl.RoverServiceImpl;



/**
 * Unit Test of RoverService class
 * @author laghdafk
 *
 */

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = RoverServiceImpl.class, loader = AnnotationConfigContextLoader.class)
class RoverServiceTest {
	
	@Resource
	private RoverService roverService;
	
	@Test
	void testLeftSpin() {
		int x = 1;
		int y = 1;
		Heading h = Heading.N;
		Rover rover = new Rover(x, y, h);
		  
		roverService.leftSpin(rover);
		assert(rover.getX() == x);
		assert(rover.getY() == y);
		assert(rover.getH() == Heading.E);
		  
		roverService.leftSpin(rover);
		assert(rover.getX() == x);
		assert(rover.getY() == y);
		assert(rover.getH() == Heading.S);
		 
		roverService.leftSpin(rover);
		assert(rover.getX() == x);
		assert(rover.getY() == y);
		assert(rover.getH() == Heading.W);
		 
		roverService.leftSpin(rover);
		assert(rover.getX() == x);
		assert(rover.getY() == y);
		assert(rover.getH() == Heading.N);
		  
		System.out.println("TEST LEFTSPIN:------------------SUCCESS-----------");
	  }
	
	  @Test
	  void testRightSpin() {
		  int x = 1;
		  int y = 1;
		  Heading h = Heading.N;
		  Rover rover = new Rover(x, y, h);
		  
		  roverService.rightSpin(rover);
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == Heading.W);
		  
		  roverService.rightSpin(rover);
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == Heading.S);
		  
		  roverService.rightSpin(rover);
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == Heading.E);
		  
		  roverService.rightSpin(rover);
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == Heading.N);
		  
		  System.out.println("TEST RIGHTSPIN:------------------SUCCESS-----------");
	  }
	  
	  @Test
	  void testMoveForward() {
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
				  assert(rover.getX() == x);
				  assert(rover.getY() == y);
				  assert(rover.getH() == h);
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
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == h);
		  
		  h = Heading.S;
		  rover.setH(h);
		  roverService.moveForward(rover, xMax, yMax);
		  y--;
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == h);
		  
		  h = Heading.W;
		  rover.setH(h);
		  roverService.moveForward(rover, xMax, yMax);
		  x--;
		  assert(rover.getX() == x);
		  assert(rover.getY() == y);
		  assert(rover.getH() == h);
		  
		  System.out.println("TEST MOVEFORWARD:------------------SUCCESS-----------");
	  }

}
