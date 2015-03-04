/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final int numberOfCircles =3;
	private static final double PixelsInInch =72.0;
	private double radius = 1.0*PixelsInInch;
	
	
	public void run(){
		drawTarget(radius);
	}
		
	private void drawTarget(double radius){
		
		for(int i=1; i<numberOfCircles+1; i++){
			double x = getWidth()/2.0-radius;
			double y = getHeight()/2.0-radius;
			
			GOval circle= new GOval(2.0*radius, 2.0*radius);
			add(circle, x, y);
			circle.setFilled(true);
			radius = radius-25.2; 
	
			if(i%2 != 0){
				circle.setColor(Color.RED);
			} else {
				circle.setColor(Color.WHITE);
			}
		}
	}
}
