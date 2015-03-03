/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.util.*;

public class HangmanLexicon {
	
	// This is the HangmanLexicon constructor
	public HangmanLexicon() {		
		try {
			BufferedReader rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			list = new ArrayList <String>();

			while(true){
				String line =rd.readLine();
				list.add(line);
				if (line == null) break;
			}
		rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}


/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return list.size();
	}

/** Returns the word at the specified index. 
 * @param wordIndex */
	public String getWord(int wordIndex) {
		return list.get(wordIndex);
	}


/* Private Instance Variables */
	ArrayList <String> list = new ArrayList <String>();
}
