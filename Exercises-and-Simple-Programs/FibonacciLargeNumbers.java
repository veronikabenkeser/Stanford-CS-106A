import acm.program.ConsoleProgram;

/*
 * The program displays those terms in the Fibonacci sequence that are less than 10,000. 
 * Since the program continues as long as the value of the term is less than the maximum value, we use a while loop.
 */

public class  FibonacciLargeNumbers  extends ConsoleProgram{ 

	private static final int MAX_TERM_VALUE =10000;
	private int term0= 0;
	private int term1=1;

	public void run(){
		while (term0< MAX_TERM_VALUE){
			println(term0);
			int sum=term0+term1;
			term0=term1;
			term1=sum;
		}	
	}
}
