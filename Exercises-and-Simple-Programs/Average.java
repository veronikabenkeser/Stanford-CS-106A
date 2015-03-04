import acm.program.ConsoleProgram;

public class Average extends ConsoleProgram{ 
	
	private static final int SENTINEL = -1;
	private int sum = 0;
	private double average;
	private int numberOfDigits=0;
	private int n;
	
	public void run(){
		println("This program calculates the average store in the class.");
		println("Enter values, one per line.");
		println("Type " + SENTINEL+ " to signal that you're done with your list of scores");

	
		while(true){
		n =readInt("Enter a score: ");
		numberOfDigits++;

		if (n==SENTINEL) break;

		sum = sum+n;
		average=(double)sum/numberOfDigits;
		

		}
		println((n==SENTINEL && numberOfDigits==1)? "The average score could not be calculated": "The average is " + average + ".");

	}
}
