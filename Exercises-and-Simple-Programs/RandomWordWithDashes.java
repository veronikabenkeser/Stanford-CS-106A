import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class RandomWordWithDashes extends ConsoleProgram {

	private static final int  MIN_LETTERS = 1;
	
	private static final int MAX_LETTERS = 3;
	
	private static final int numberOfWords = 5;
	
		public void run() {
			println(makeAWord());
			
		}
		
		private String makeAWord(){
			String word = "";
			String words = "";
			
			for (int i=0; i<numberOfWords; i++){
				int numberOfChars = rgen.nextInt(MIN_LETTERS, MAX_LETTERS);
				
				for (int k=0; k<numberOfChars; k++){
					char ch = (char)rgen.nextInt('a', 'z');
					word +=ch;
				}
				
			words = word + spaceInBetween(16, "-") + words;
			
			}
			return words;
		}
		
		private RandomGenerator rgen = new RandomGenerator();
	
		private String spaceInBetween(int numberOfTimes, String str){
			String result = "";
			
			for ( int i=0; i<numberOfTimes; i++){
				result += str;
			}
		
			return result;
		}
}
