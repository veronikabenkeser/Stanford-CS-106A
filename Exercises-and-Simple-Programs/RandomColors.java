/** This program draws a set of 10 circles with different sizes,
* positions, and colors. Each circle has a randomly chosen
* color, a randomly chosen radius between 5 and 50 pixels,
* and a randomly chosen position on the canvas, subject to
* the condition that the entire circle must fit inside the
* canvas without extending past the edge.
*/

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class RandomColors extends GraphicsProgram{ 
	private static final int NUM_OF_CIRCLES = 10;
	private static final int MAX_CIRCLE_RADIUS = 50;
	private static final int MIN_CIRCLE_RADIUS = 5;

	public void run(){
	
		for (int i=0; i<NUM_OF_CIRCLES; i++){
			int r = rgen.nextInt(MIN_CIRCLE_RADIUS, MAX_CIRCLE_RADIUS);
			int x= rgen.nextInt(0, getWidth()-2*r);
			int y = rgen.nextInt(0, getHeight()-2*r);
			
			GOval circle = new GOval (x, y, 2*r, 2*r);
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			add(circle);
			}

	}
	/*private instance variable*/
	private RandomGenerator rgen= RandomGenerator.getInstance();
}
