/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
	private static final int DELAY = 20;
	
/** Runs the Breakout program. */
	public void run() {
		setup();
		while (!gameOver()){
			if (ballClicked){
				play();	
			}
		}
	}
	
/*
 * 	This method creates the bricks, paddle, ball, and the initial welcome message.
 */
	private void setup(){
		brickWall();
		paddle();
		initialization();
		ball();
	}

/*
 * 	This method makes the ball move around the screen and interact with all of the objects on the screen. 
 * 	When the ball hits the bottom wall, the program calculates the number of remaining attempts, and adds 
 * 	the ball to the center of the screen.
*/
	private void play(){
		while(!ballHitBottomWall()){
			moveBall();
			checkForCollisionWithWall();
			bounceOffObject();
			pause(DELAY);
		}
		attemptCount();
		giveFeedback();
		nextAttempt();		
	}
	
/* 
 *	If the ball hits the bottom, this method returns the value true.
 */
	private boolean ballHitBottomWall(){
		return (ball.getY()+BALL_RADIUS*2)>getHeight();
	}

/*
 * 	This method sets up the brick wall.
 */
	private void brickWall(){
		for (int i=0; i<NBRICK_ROWS; i++){
			for (int k=0; k<NBRICKS_PER_ROW; k++){
				double x = getWidth()/2-(BRICK_WIDTH*NBRICKS_PER_ROW/2)-((NBRICKS_PER_ROW-1)*BRICK_SEP)/2+BRICK_WIDTH*k+BRICK_SEP*k;
				double y = BRICK_Y_OFFSET+BRICK_HEIGHT*i+BRICK_SEP*i;
				brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				if (i<2) brick.setColor(Color.RED);
				if(i>1 && i<4) brick.setColor(Color.ORANGE);
				if(i>3 && i<6) brick.setColor(Color.YELLOW);
				if(i>5 && i<8) brick.setColor(Color.GREEN);
				if(i>7 && i<NBRICK_ROWS) brick.setColor(Color.CYAN);
				brick.setFilled(true);
				add(brick);	
			}
		}
	}

/*
 *	This method creates the paddle.
 */
	private void paddle(){
		paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle, getWidth()/2-PADDLE_WIDTH/2, getHeight()-PADDLE_Y_OFFSET);
		addMouseListeners();
	}
	
/*
 * 	When the mouse is pressed, the location of the mouse is updated to see whether 
 *	the user has selected any of the objects on the screen.
 *	(non-Javadoc)
 *	@see acm.program.Program#mousePressed(java.awt.event.MouseEvent)
 */
	public void mousePressed(MouseEvent e){
		lastX = e.getX();
		lastY = e.getY();
		gobj = getElementAt(lastX,lastY);	
	}
	
/*
 * 	The user moves the paddle by dragging the mouse while the paddle is selected.
 *	(non-Javadoc)
 *	@see acm.program.Program#mouseDragged(java.awt.event.MouseEvent)
 */
	public void mouseDragged(MouseEvent e){
		if (gobj == paddle){
				if(((gobj.getX()+(e.getX()-lastX))>=0) && (gobj.getX()+(e.getX()-lastX)<=(getWidth()-PADDLE_WIDTH))){
				gobj.move(e.getX()-lastX, 0);
				lastX=e.getX();
			}
		}
	}
	
/*
 * 	Before the game begins, the player is asked to click the ball in order to start the game.	
 */
	 private void initialization(){
		label = new GLabel ("Click the ball to start the game");
		label.setFont(new Font("Serif", Font.BOLD, 18));
		label.setColor(Color.GREEN);
		double x = (getWidth() - label.getWidth()) / 2;
		double y = (getHeight() +  label.getAscent()) / 2 + 25;
		add(label, x, y);
	}

/*
 * 	Ball is created. The ball's velocity is negative half of the time.
 */
	 private void ball(){
		ball= new GOval(getWidth()/2-BALL_RADIUS,getHeight()/2-BALL_RADIUS, BALL_RADIUS*2, BALL_RADIUS*2);
		add(ball);
		ball.setFilled(true);
		ball.sendToBack();
		vy= +3.0;
		vx=rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx=-vx;
	 }
	
/*
 *	The game starts when the user clicks the ball.
 *	(non-Javadoc)
 *	@see acm.program.Program#mouseClicked(java.awt.event.MouseEvent)
 */
	public void mouseClicked(MouseEvent e){
		clickedX=e.getX();
		clickedY=e.getY();	
		firstClickedObject = getElementAt(clickedX, clickedY);
		
		if (firstClickedObject == ball) {
			
			ballClicked = true;
			remove(label);
		}
	}
	
	/*
	 * This method makes the ball move around.
	 */
	private void moveBall(){
		ball.move(vx, vy);
	}
	
	/*
	 * This method checks whether the ball has collided with any of the 4 walls.
	 * If the ball collides with the top wall, the ball's y velocity will be reversed and it will start heading down.
	 * If the ball collides with the right or left wall, the ball's x velocity will be reversed.
	 * If the ball collides with the bottom wall, the ball will be removed from the screen.
	 */
	private void checkForCollisionWithWall(){
		if(ball.getY()<0) {
			vy = -vy; 		
			bounceClip.play(); 
			moveBall();
		} else if ((ball.getX()+BALL_RADIUS*2)>getWidth() || (ball.getX()<0)) {
			vx = -vx; //launch the  ball right or left by reversing its velocity
			bounceClip.play(); 
			moveBall();
		} else if (ballHitBottomWall()) { 
			remove(ball);
		}
	}
	
	/*In order to give feedback about how many attempts the user has left, we need to be able to access the attemptsLeft variable. This method 
	 * returns an integer as the attemptsLeft variable and subsequently updates the attemptsLeft variable in the sentence "Click the ball to try 
	 * again. You have " + attemptsLeft + " attempts remaining."
	 */
	private int attemptCount(){
		attemptsMade++;
		attemptsLeft = NTURNS-attemptsMade;
		return attemptsLeft;
	}

/*This method makes the user click the ball after each round of the game in order to launch the ball again. If ballClicked remained true, the user
 * would only need to launch it one in the beginning of the game. The user has NTURNS. If the user has not yet used his/her 3 attempts, the ball
 * will re-appear in the center of the screen.
 */
	private void nextAttempt(){
		ballClicked = false;
		
		if (attemptsLeft != 0){
			add(ball, getWidth()/2-BALL_RADIUS,getHeight()/2-BALL_RADIUS);
		}
	}
	
	/*
	 * This method returns the object the ball has collided with. If the ball did not hit any objects, then the returned value is null.
	 */
	private GObject getCollidingObject(){ 
		
		if (getElementAt(ball.getX(), ball.getY()) != null){
			return (getElementAt(ball.getX(), ball.getY()));
		} else if (getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()) != null){ 
			return (getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()));
		} else if ((getElementAt(ball.getX(), ball.getY()+2*BALL_RADIUS) !=null)){
			return (getElementAt(ball.getX(), ball.getY()+2*BALL_RADIUS));
		} else if (getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()+2*BALL_RADIUS)!=null){
			return (getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()+2*BALL_RADIUS));
		} else {
			return (null);
		}
		
	}
		
	/*
	 *If the ball has collided with the paddle, we reverse the ball's y velocity (make the ball go up).
	 *If the ball has collided with any of the bricks, we reverse the ball's y velocity (make the ball go down).
	 */
	private void bounceOffObject(){	
		GObject collider = getCollidingObject();
		
		if (collider != null){
			if(collider == paddle){
				if ((ball.getY()<=((getHeight()-PADDLE_Y_OFFSET)+(1/3)*(getHeight()-PADDLE_Y_OFFSET)))){
				vy = - vy;
				bounceClip.play(); 
				moveBall();
				}
			} else { 
				vy = -vy;
				bounceClip.play(); 
				moveBall();
				remove(collider);
				bricksRemaining--;
			
			}
		}
	}
	
	/*We want to know whether any of the points on the ball have come in contact with an object.
	 * Because we think of a GOval as being enclosed in a square, we will 
	 * be checking whether any of the 4 corner points of the square came in contact 
	 * with any other objects in the world. 
	 */
	private boolean collisionWithObjectOccured(){
		return (getElementAt(ball.getX(), ball.getY()) != null) ||
		(getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()) != null) ||
		(getElementAt(ball.getX(), ball.getY()+2*BALL_RADIUS) !=null) ||
		(getElementAt(ball.getX()+2*BALL_RADIUS, ball.getY()+2*BALL_RADIUS)!=null);
	}
			
	/*The game is over if the ball hits the bottom wall or if the player gets rid of 
	 * all the bricks. 
	 */
	private boolean gameOver(){
		return (attemptsMade > NTURNS) || (bricksRemaining == 0);
	}
	
	/**
	 * This method returns a GLabel object.
	 * 
	 * @param string The content of the GLabel
	 */
	private GLabel feedbackLabel(String string){
		label = new GLabel(string);
		label.setFont(new Font("Serif", Font.BOLD, 18));
		label.setColor(Color.MAGENTA);
		x = (getWidth() - label.getWidth()) / 2;
		y = (getHeight() + label.getAscent()) / 2+25; 

		return label;
	}
	
	/*
	 * This method modifies the content of the GLabel above based on the conditions encountered in the game.
	 * If there are no more bricks left, the player sees the message that he/she has won.
	 * If the player has used up all his attempts to get rid of the bricks, the message states that the game is over.
	 * If ball touched the bottom wall/ player did not hit it in time, but the player has not yet used up his 3 attempts,
	 * the message shows him/her how many attempts are left.
	 */
	private void giveFeedback(){
		
		if (bricksRemaining == 0){
			label.setColor(Color.GREEN);
			add(feedbackLabel("You won! Pop that champagne! It's time to celebrate."), x, y);
		} else if ((ball.getY()+BALL_RADIUS*2)>getHeight() && attemptsMade >= NTURNS){
			add(feedbackLabel("HAHA! YOU LOST! GAME OVER."), x, y);
		} else {
			add(feedbackLabel("Click the ball to try again. You have " + attemptsLeft + ((attemptsLeft>1) ? " attempts" : " attempt" ) + " remaining."), x, y);
		}
	}
		
	/*
	 * This is the sound the ball makes each time it hits something.
	 */
	AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	
	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private GRect brick;
	private GRect paddle;
	private GObject gobj;
	private GOval ball;
	private GLabel label;
	private double lastX;
	private double lastY;
	private double clickedX;
	private double clickedY;
	private double vx, vy; // velocity of the ball
	private int bricksRemaining = NBRICKS_PER_ROW *NBRICK_ROWS;
	GObject firstClickedObject;
	boolean ballClicked;
	private int attemptsLeft;
	private int attemptsMade = 0;
	private double x;
	private double y;
}
