import acm.program.ConsoleProgram;

public class SmallestAndLargestNumber extends ConsoleProgram{ 
	private static final int SENTINEL = 0;
	
	public void run(){
		intoText();
		findSmallestAndLargestNumber();
	}
	
	private void intoText(){
	println("This program finds the largest and smallest number. Please enter 0 to signal that you are done entering numbers.");
	}
	
	private void findSmallestAndLargestNumber(){
		int number1 = readInt("Please enter a number:");
		
		if (number1 == SENTINEL){
			println("The min and max cannot be determined since you have not entered any values.");
		}
		
		int min = number1;
		int max= number1;
		
		while(number1 !=SENTINEL){
			int number2 = readInt("Please enter a number:");
			if (number2 == SENTINEL){
				println("Smallest Number: " + min + ".");
				println("Largest Number: " + max + ".");
				break;
			}
			max=Math.max(max, number2);
			min= Math.min(min,  number2);
		}	
	}
}
