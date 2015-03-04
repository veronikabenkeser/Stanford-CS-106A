import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class RandomWordGenerator extends ConsoleProgram {

	private static final int  MIN_LETTERS = 3;
	private static final int MAX_LETTERS = 8;
	
		public void run() {
			for (int k =0; k<5; k++){
				println(makeAWord());
			}
		}
		
		private String makeAWord(){
			String word = "";
			String words = "";
			
			int numberOfChars = rgen.nextInt(MIN_LETTERS, MAX_LETTERS);
			
			for (int i=0; i<numberOfChars; i++){
				char ch = (char)rgen.nextInt('a', 'z');
				word +=ch;
			}
			return word;
			}
  private RandomGenerator rgen = new RandomGenerator();	
  }
