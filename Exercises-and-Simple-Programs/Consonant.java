import java.awt.Color;
import java.awt.Font;

import acm.program.ConsoleProgram;

public class Consonant extends ConsoleProgram {
	public void run() {
		setFont(new Font("Serif", Font.BOLD, 14));
		println("This program determines whether a given letter is a consonant.");
		println();
		
		
		while(true){
			String letter = readLine("Enter a letter: ");
			char ch = letter.charAt(0);			
			if (letter.length() == 1 && Character.isLetter(ch)){
				println(letter + " is" + isEnglishConsonant(ch) + "a consonant.");
				println();
			} else {
				println("You have not entered a valid letter.");
				println();
			}
		}
	}
		
	private String isEnglishConsonant(char ch) {
		switch (Character.toLowerCase(ch)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
			return (" not ");
		default:
			return (" ");
		}
	}
}
