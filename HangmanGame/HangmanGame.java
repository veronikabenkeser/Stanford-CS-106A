import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.util.ArrayList;

public class HangmanGame extends ConsoleProgram {
	
	public void init(){
		canvas = new HangmanCanvas();
		add(canvas);
	}

    public void run() {
    	setup1();
		prepareLaunch();
		launch();
   }

    private void setup1(){
    	canvas.reset();
	
    	println("Welcome to Hangman!");
    	hangmanGame = new HangmanLexicon();
    }
    
	private void prepareLaunch(){
		int wordIndex = rgen.nextInt(0, hangmanGame.getWordCount()-1);
	    
		word = hangmanGame.getWord(wordIndex);
	
		while(true){
			String promptResponse = readLine("Do you want to play this awesome Hangman Game? \n(Type \"yes\" or \"no\") \n ");
			if (wantToPlayGame(promptResponse)){
				println("YAY!");
				break;
			} else if (promptResponse.length()>=2 && promptResponse.substring(0, 2).equalsIgnoreCase("no")) {
				println("OK, we won't play then. Closing the window...");
				pause(960);
				System.exit(1);
			} else {
				println("Invalid input. Please enter \"yes\" or \"no\".");
			}
		}
	}
	
	private void launch(){
		guessWord = "";
		
		for (int k=0; k<word.length(); k++){
			char star = '-';
			guessWord += star;
		}
		
		println("The word now looks like this: " + guessWord);
		println("You have " + count +" guesses left.");
		
	
		while(atLeast1MissingLetter(guessWord)){
			guessWord =update(guessWord);
			
			println("The word now looks like this: " + guessWord);
	
			
			if (guessWord.equals(word) || count<1) break;
						
			if(!guessWord.equals(word)){
				if (count<1) break;
				println("You have " + ((count>1)?count +" guesses":"only one guess") + " left.");
			}
			
		}
	
		println(feedback());
		
	}
	
	
	private boolean wantToPlayGame(String promptResponse){
			if (promptResponse.length()<2) return false;
			return (promptResponse.substring(0, 2).equalsIgnoreCase("ye") || promptResponse.substring(0, 2).equalsIgnoreCase("es"));
		
	}
	
		private String update(String guessWord){
			
			String guessLetterStr = readLine("Your guess: ");
			
			if(enteredLetter(guessLetterStr)){
			char guessLetterChar = upperCaseGuessLetterChar(guessLetterStr);
			
			String result = "";
			char ch2=0;
	
			for (int i=0; i < word.length(); i++){
	
				char currentChar = guessWord.charAt(i);
				
				if(currentChar == '-' && word.charAt(i) == guessLetterChar){									
					ch2 = guessLetterChar ;
				} else {
					ch2=currentChar;
					
				}
				result +=ch2;
			}
			
			if (!arrContainsLetter(guessLetterChar)) letterFeedback2(result, guessLetterChar);
			
			guessWord=result;
			
		}
			canvas.displayWord(guessWord);
			return guessWord;
		
		}
		
		private String feedback(){
			if (guessWord.equals(word)){
				return ("You guessed the word: " + guessWord + 
						"\nYou win.");
			} else {
				return ("You're completely hung." +
						"\nThe word was: "+ word + "." +
						"\nYou lose.");
			}
		}
	
		private boolean enteredLetter(String guessLetterStr){
			
			if (guessLetterStr.length()>1 || !Character.isLetter(guessLetterStr.charAt(0))){
				println("You have not entered a valid letter.");
				return false;
			} else {
				return true;
			}
		}
		
		private char upperCaseGuessLetterChar(String guessLetterStr){
			char guessLetterChar = guessLetterStr.charAt(0);
			if (Character.isLowerCase(guessLetterChar)){
				guessLetterChar = Character.toUpperCase(guessLetterChar);
			}
			return guessLetterChar;
	}
		
	private boolean atLeast1MissingLetter(String guessWord){
		return (!guessWord.equals(word));
	}
	
	private boolean arrContainsLetter(char guessLetterChar){
		boolean result =false;
		for (int k=0; k<arr.size(); k++){
			if(arr.get(k) == guessLetterChar){
				println("You have already tried guessing this letter. The word does have this letter.");
				result = true;
				break;
			} 
		}
		return (result);
	}
	
	private void letterFeedback2(String result, char guessLetterChar){
		if(result.equals(guessWord)){
			println("There are no "+ guessLetterChar + "'s in this word." );
			count --;
			canvas.noteIncorrectGuess(guessLetterChar);
		} else {
			arr.add(guessLetterChar);
			println("That guess is correct.");
		}
	}

	/*Private Instance Variables */
    private HangmanLexicon hangmanGame;
    private RandomGenerator rgen = new RandomGenerator();
    private String word;
    private int numberOfAttempts = 8;
    private int count =numberOfAttempts;
    private String guessWord;
	private ArrayList <Character> arr = new ArrayList <Character>();
	private HangmanCanvas canvas;
}
