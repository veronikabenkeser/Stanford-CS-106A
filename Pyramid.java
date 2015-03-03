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
*/
	
	
	
	public void run() {
		drawPyramid();
	}
	
	private void drawPyramid(){
		
		double startingPointx= getWidth()/2.0-ADJUSTED_BRICKS_IN_BASE*BRICK_WIDTH/2.0;
		double startingPointY= getHeight()-BRICK_HEIGHT;
		
		for (int row=0; row<BRICKS_IN_BASE; row++){//do it 14 times and incr by1.
			for (int column=0; column<ADJUSTED_BRICKS_IN_BASE; column++){
			
				GRect brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
				add(brick, startingPointx+BRICK_WIDTH*column, startingPointY-BRICK_HEIGHT*row); //e.d.in one roq, the 4th brick is 3 widths away, hencce why we use "column"
				
				
			}
			
			ADJUSTED_BRICKS_IN_BASE--;
			startingPointx= getWidth()/2.0-ADJUSTED_BRICKS_IN_BASE*BRICK_WIDTH/2.0;

		}
	}
}

/*
		for(int k=0; k<14; k++){ //for each row
			
			for (int spaces=1; spaces<=k; spaces++){//as the row increases, the number of things in the row increases
				
			System.out.print(" ");
				
		}
			for (int i=0; i<=4-k; i++){
				System.out.print("X");
			}
			
			System.out.println();
	}
	}
}

*/
	
/* for(int k=0; k<5; k++){ //for each row
			
			for (int spaces=1; spaces<=4-k; spaces++){//as the row increases, the number of things in the row increases
				
			System.out.print(" ");
				
		}
			for (int stars=0; stars<=k; stars++){
				System.out.print("X");
			}
			
			System.out.println();
		
	}
	}
}

*/
		
		

