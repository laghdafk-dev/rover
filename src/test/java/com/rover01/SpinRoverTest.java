//package com.rover;
//
//import org.junit.jupiter.api.Test;
//
//import com.rover.model.Heading;
//import com.rover.model.Rover;
//
//class SpinRoverTest {
//
//	@Test
//	void test() {
//		
//		// test rover constructor and getters
//		Rover rover = new Rover(1, 2, Heading.N);
//		assert(rover.getX() == 1);
//		assert(rover.getY() == 2);
//		assert(rover.getH() == Heading.N);
//		
//		// test left spin 360°
//		rover.leftSpin();
//		assert(rover.getH() == Heading.E);
//		rover.leftSpin();
//		assert(rover.getH() == Heading.S);
//		rover.leftSpin();
//		assert(rover.getH() == Heading.W);
//		rover.leftSpin();
//		assert(rover.getH() == Heading.N);
//		
//		// test right spin 360°
//		rover.rightSpin();
//		assert(rover.getH() == Heading.W);
//		rover.rightSpin();
//		assert(rover.getH() == Heading.S);
//		rover.rightSpin();
//		assert(rover.getH() == Heading.E);
//		rover.rightSpin();
//		assert(rover.getH() == Heading.N);
//		
//		
//	}
//
//}
//
