import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/*
 * This program automatically numbers each horizontal line the user draws. The number is centered directly beneath the line.
 */

public class DrawingNumberedHorizontalLines extends GraphicsProgram{
	/*Variables ??*/
	public static final double LINE_TOLERANCE=2;
	
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
		endPointX= e.getX();
		endPointY=startPointY;
		line.setEndPoint(e.getX(), endPointY);	
	}
	
	public void mouseReleased(MouseEvent e){
		countString = Integer.toString(countLabel);
		lineLength(startPointX, startPointY, endPointX, endPointY);
		label = new GLabel(countString);
		
		if (countLabel<10){
			labelX = (startPointX+lineLength/2)-7/2;
		} else {
			labelX = (startPointX+lineLength/2)-7;
		}
			
		add(label, labelX, startPointY+12);
		countLabel++;
	}
	
	private double lineLength(double startPointX, double  startPointY, double  endPointX, double endPointY){
		double x=Math.pow((endPointX-startPointX), 2);
        double y=Math.pow((endPointY-startPointY), 2);
        lineLength = Math.sqrt(x+y);
        return lineLength;
	}
	
/*	Instance variables	*/
	private GLine line;
	private GLabel label;
	private double startPointX; /*The initial mouse position at X */
	private double startPointY; /*The initial mouse position at Y */
	private String countString;
	private int countLabel = 1;
	private double endPointX;
	private double endPointY;
	private double lineLength;	
	private double labelX;
	private double  oldY;
}
