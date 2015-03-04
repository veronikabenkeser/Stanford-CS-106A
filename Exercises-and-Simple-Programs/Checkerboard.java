import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Checkerboard extends GraphicsProgram {
	
private int numberOfRows =8;
private int numberofSquares =8;
private int lengthOfSquare =30;
private int widthOfSquare =30;
private int radius=24;


	public void run(){
		drawCheckerboard();
	}
	

	
	private void drawCheckerboard(){
		for(int i=0; i<numberOfRows; i++){
			for(int k=0; k<numberOfRows; k++){
				int x = k*lengthOfSquare;
				int y= i*widthOfSquare;
				GRect square = new GRect(lengthOfSquare, widthOfSquare);
				add(square, x, y);
			}
			
			if(i==0 || i%2==0){
				for(int q=0; q<numberofSquares; q=q+2){
					int x1 = (widthOfSquare+(widthOfSquare-radius)/2)+(widthOfSquare)*q;
					int y1=((lengthOfSquare-radius)/2)+lengthOfSquare*i;
					GOval circle = new GOval(radius, radius);
					add(circle, x1, y1);
				}
			}
			
			if(i%2!=0){
				for(int q=0; q<numberofSquares; q=q+2){
					int x2 = (widthOfSquare-radius)/2+ widthOfSquare*q;
					int y2=(lengthOfSquare-radius)/2+lengthOfSquare*i;
					GOval circle = new GOval(radius, radius);
					add(circle, x2, y2);
				}		
			}
		}
	}
}
