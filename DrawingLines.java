/* 
 * This is a GraphicsProgram that allows users to draw lines on the canvas. As the user drags the mouse, the line follows the mouse. The line is set 
 * in place once the user releases the mouse. The user then can start drawing new lines.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

/* This class allows users to draw lines on the canvas. */ 

public class DrawingLines extends GraphicsProgram{
	
	/* initialization */
	public void init(){
		addMouseListeners();
	}
	
	/* Called on mouse press to create a new line */ 
	public void mousePressed(MouseEvent e){
		startPointX = e.getX();
		startPointY = e.getY();		
		line = new GLine (startPointX, startPointY, startPointX, startPointY);
		add(line);
		}
	
	/* Called on mouse drag to reset the endpoint*/ 
	public void mouseDragged(MouseEvent e){
		line.setEndPoint(e.getX(), e.getY());	
	}
	
/*	Private Instance variables	*/
	private GLine line;
	private double startPointX; /*The initial mouse position at X */
	private double startPointY; /*The initial mouse position at Y */

}