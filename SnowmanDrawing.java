

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class SnowmanDrawing extends GraphicsProgram {	
	private static final int numberOfCircles =3;
	private double radius = 70;
	private int sizeofButtonSquare = 10;
	
	public void run(){
		drawBody(radius);
		
	}
	
	
    private double changeInSize = .55;
    
	private void drawBody(double radius){
		
		double startingX= getWidth()/2-radius;
	    double startingY= getHeight()-radius;
	    
		for(int i =0; i<numberOfCircles; i++ ){
			
			double x= startingX;
			double y= startingY;
			GOval circle = new GOval(radius*2, radius*2);
			
			add(circle, x, y);
			

			while(i==1){
				double y0= y+sizeofButtonSquare;

				for(int q=0; q<3; q++){
					
				double x0= getWidth()/2-(sizeofButtonSquare/2);
				GRect button = new GRect(sizeofButtonSquare, sizeofButtonSquare);
			
				add(button, x0, y0);	
				
				y0=y0+2*sizeofButtonSquare;
			}
				
			break;
			}
			
			while(i==2){
				//mouth
				double x1=getWidth()/2-radius/3/2;
				double y1= y+radius+radius/3;
				GOval mouth = new GOval(radius/3, radius/2);
				add(mouth, x1, y1);
				
				//nose
				double x2=getWidth()/2-1;
				double y2=y+radius+radius/2-3;
				GLabel nose = new GLabel("v");
				add(nose, x2, y2);
				// or add(new GLabel("v"),getWidth()/2-1, y+radius+radius/2-3);
					
				//eyes	
				double x3= getWidth()/2-(radius/2);
				double y3= y+radius-(radius/4);
					
				for(int k=0; k<2; k++){
					GOval eyes = new GOval(radius/4,radius/4);
					add(eyes, x3, y3);
					x3=getWidth()/2+(radius/2)-radius/4;
				}
				break;
			}
			radius=radius*changeInSize;
			startingX= getWidth()/2-radius;
			startingY= startingY-(radius*2);
		}
	}
}
	
