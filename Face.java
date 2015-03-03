import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Face extends GraphicsProgram {
	
	private static final int HEAD_WIDTH= 100;
	private static final int HEAD_HEIGHT= 170;
	private static final int EYE_RADIUS = 10;
	private static final int MOUTH_WIDTH = 50;
	private static final int MOUTH_HEIGHT = 25;


	public void run(){
		addFace(getWidth()/2, getHeight()/2);
	}
	
	/* Adds the entire face centered at (cx, cy) */

	private void addFace(double centeredx, double centeredy){ // in ()s, we have the center of each piece
		addHead(centeredx, centeredy);
		addEye(centeredx-HEAD_WIDTH/4, centeredy-HEAD_HEIGHT/4);
		addEye(centeredx+HEAD_WIDTH/4, centeredy-HEAD_HEIGHT/4);
		addMouth(centeredx, centeredy+HEAD_HEIGHT/4); //things in () represent new "centered x" and "centeredy" that will be going into the addMouth method 
													// later in the code
													//we're finding the center of the mouth this way			
	}
	
	/* Adds the head centered at (cx, cy) */
	
	private void addHead(double centeredx ,double centeredy){
		double x= centeredx-HEAD_WIDTH/2 ;   //above, we have the center of the head - centeredx , centeredy. Now, we are moving x to the left in order to make
											// the object centered in relation to the frame
		double y= centeredy-HEAD_HEIGHT/2;
		GRect head = new GRect ( x, y, HEAD_WIDTH,  HEAD_HEIGHT);
		add(head);

		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		head.setColor(Color.BLACK);
		}
	
	private void addEye(double centeredx ,double centeredy){
		double x = centeredx-EYE_RADIUS;
		double y= centeredy-EYE_RADIUS;
		GOval eyes = new GOval (x, y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		eyes.setFilled(true);
		eyes.setColor(Color.YELLOW);
		add(eyes);
		
	}
	
	private void addMouth(double centeredx, double centeredy){
		double x = centeredx-MOUTH_WIDTH/2;
		double y=centeredy - MOUTH_HEIGHT/2; //Saying that whatever the center of the mouth is , pull it up by MouthHeight/2
		GRect mouth = new GRect (x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}
}

/*
Another way to look at it:
-When we're writing a method (e.g. addMouth), we say that the mouth begins MOUTH_WIDTH/2 pixels away from the center of the mouth.
-When the code "addMouth(centeredx, centeredy+HEAD_HEIGHT/4);" is executed, "centeredy+HEAD_HEIGHT/4" becomes "centeredy" that goes into the addMouth method.
Consequently, we now have the center of the mouth - MOUTH_WIDTH/2.
*/