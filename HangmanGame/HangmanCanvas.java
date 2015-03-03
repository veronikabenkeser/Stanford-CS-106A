/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Stroke;
import java.util.ArrayList;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		GLine scaffold = new GLine(initX, initY, initX, initY+SCAFFOLD_HEIGHT);
		GLine beamP1 = new GLine (initX, initY, BEAM_LENGTH+initX, initY);
		GLine beamP2 = new GLine (BEAM_LENGTH+initX, initY, BEAM_LENGTH+initX, initY+ROPE_LENGTH);
		add(scaffold);
		add(beamP2);
		add(beamP1);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		GLabel label1= new GLabel(word);
		double x1= 20;
		double y1 = getHeight()/2+SCAFFOLD_HEIGHT/2;
		label1.setFont(new Font("Serif", Font.BOLD, 25));
		
		if(getElementAt(x1, y1) !=null){
			remove(getElementAt(x1, y1));
		}
		
		add(label1, x1, y1);
	}
		

/**
 * Updates the display to correspond to incorrect guesses. Calling this method causes the next body part to appear
 * on the scaffold; the incorrect guess is then recorded on the screen.
 */
	public void noteIncorrectGuess(char letter) {
		addBodyPart();
		addLetter(letter);
	}
	
	private void addBodyPart(){
		count++;
		
		switch (count) {
		case 1:
			head();
			break;
		case 2:
			body();
			break;
		case 3:	
			leftArm();
			break;
		case 4:
			rightArm();
			break;
		case 5:
			leftLeg();
			break;
		case 6:
			rightLeg();
			break;
		case 7:
			leftFoot();
			break;
		case 8:
			rightFoot();
			break;
		}
	}
	
	
	private void head(){
		GOval head = new GOval (BEAM_LENGTH+initX-HEAD_RADIUS, initY+ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	
	private void body(){
		GLine body = new GLine (BEAM_LENGTH+initX, initY+ROPE_LENGTH+HEAD_RADIUS*2, BEAM_LENGTH+initX, initY+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
		add(body);
	}
	
	private void leftArm(){
		GLine arm1 = new GLine (BEAM_LENGTH+initX-UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+
				ARM_OFFSET_FROM_HEAD, BEAM_LENGTH+initX,initY+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		GLine arm2 = new GLine (BEAM_LENGTH+initX-UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+
				ARM_OFFSET_FROM_HEAD, BEAM_LENGTH+initX-UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+
				ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);

		add(arm1);
		add(arm2);
	}
	
	private void rightArm(){
		GLine arm1 = new GLine (BEAM_LENGTH+initX, initY+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,BEAM_LENGTH+
				initX+UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		GLine arm2 = new GLine (BEAM_LENGTH+initX+UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+
				ARM_OFFSET_FROM_HEAD, BEAM_LENGTH+initX+UPPER_ARM_LENGTH, initY+HEAD_RADIUS*2+
				ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);

		add(arm1);
		add(arm2);
	}
	
	private void leftLeg(){
		GLine foot1 = new GLine (BEAM_LENGTH+initX - HIP_WIDTH, initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH,BEAM_LENGTH+initX, initY+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
		GLine foot2 = new GLine (BEAM_LENGTH+initX - HIP_WIDTH, initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH, BEAM_LENGTH+initX - HIP_WIDTH,initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH+LEG_LENGTH);
		add(foot1);
		add(foot2);
	}
	
	private void rightLeg(){
		GLine foot1 = new GLine (BEAM_LENGTH+initX,initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH,BEAM_LENGTH+initX +HIP_WIDTH ,initY+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH);
		GLine foot2 = new GLine (BEAM_LENGTH+initX +HIP_WIDTH, initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH,BEAM_LENGTH+initX +HIP_WIDTH,initY+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		add(foot1);
		add(foot2);
	}
	
	private void leftFoot(){
		GLine foot3 = new GLine (BEAM_LENGTH+initX - HIP_WIDTH-FOOT_LENGTH, initY+ROPE_LENGTH+
				HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH, BEAM_LENGTH+initX - HIP_WIDTH,initY+ROPE_LENGTH+
				HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		add(foot3);
	}
	
	private void rightFoot(){
		GLine foot3 = new GLine (BEAM_LENGTH+initX +HIP_WIDTH, initY+ROPE_LENGTH+HEAD_RADIUS*2+
				BODY_LENGTH+LEG_LENGTH, BEAM_LENGTH+initX +HIP_WIDTH+FOOT_LENGTH,initY+ROPE_LENGTH+
				HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH);
		add(foot3);
	}

	private void addLetter(char letter){
		if (arr.size()==0) arr.add(letter);
		
		if (!arr.contains(letter)){
			arr.add(letter);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<arr.size(); i++){
			sb.append(arr.get(i));
		}
		
		String text = sb.toString();
		
		GLabel label = new GLabel(text);
		double x= 20;
		double y =getHeight()/2+SCAFFOLD_HEIGHT/2+40;
		if(getElementAt(x, y) !=null){
			remove(getElementAt(x, y));
		}
		add(label, x, y);
	}
	
/*Private Instance Variables */
	
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 30;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 48;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private ArrayList <Character> arr = new ArrayList <Character>();
	private int count=0;
	private double initY = getHeight()/2+60;
	private double initX = 20;
}
