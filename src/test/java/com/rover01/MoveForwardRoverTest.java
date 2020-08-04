//package com.rover;
//
//import org.junit.jupiter.api.Test;
//
//import com.rover.exception.ImpossibleMoveException;
//import com.rover.exception.UnknownMoveException;
//import com.rover.model.Heading;
//import com.rover.model.Rover;
//
//class RoverTest {
//
//	
//	@Test
//	void test() {
//		int xMax = 5;
//		int yMax = 4;
//		
//		Rover rover = new Rover(1, 2, Heading.N);
//		assert(rover.getX() == 1);
//		assert(rover.getY() == 2);
//		assert(rover.getH() == Heading.N);
//		
//		// test move forward
//		try {
//			rover.moveForward(xMax, yMax);
//			assert(rover.getX() == 1);
//			assert(rover.getY() == 3);
//			assert(rover.getH() == Heading.N);
//			
//			rover.moveForward(xMax, yMax);
//			assert(rover.getX() == 1);
//			assert(rover.getY() == 4);
//			assert(rover.getH() == Heading.N);
//			
//			rover.moveForward(xMax, yMax);
//			
//		} catch (UnknownMoveException e1) {
//			
//			
//		} catch (ImpossibleMoveException e2) {
//			
//		}
//		
//		
//		
//	}
//
//}
