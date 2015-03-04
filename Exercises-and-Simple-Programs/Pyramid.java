/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Pyramid extends GraphicsProgram {

	GRect brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
	
/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	private double ADJUSTED_BRICKS_IN_BASE = BRICKS_IN_BASE; //making it double so that the math works out later
	
	/* Pyramid Aligned to the Left
	
	public void run() {
		for(int k=0; k<BRICKS_IN_BASE; k++){
		
			for(int i=0; i<=k; i++){
				
				int x=i*BRICK_WIDTH;
				int y= k*BRICK_HEIGHT;
				
				GRect rectangle = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				add(rectangle);
			}
			
			System.out.println();
			
			
		}
  }
}
