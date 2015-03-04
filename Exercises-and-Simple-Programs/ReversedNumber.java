import acm.program.ConsoleProgram;

/*
 * This program prints the digits in the number the user enters in reverse order.
 */

public class ReversedNumber extends ConsoleProgram{ 
	
	public void run(){
		
		while(true){ //this component let's the user enter info multiple times after the program has run once.
		int n=readInt("Please enter a positive integer that is more than 2 characters long:");
	
			while(n>0){ //when n<1 or 0, it skips this loop and returns to "Please enter..."
				
				int length= String.valueOf(n).length();
				
				if( length <3 ){
					println("You have not entered a number that is more than 2 characters long!");
					break;
				}
				String newNumber = "";
				
				for(int i=0; i<length; i++){
					int numberOnTheLeft=n%10;
					n=n/10;
					newNumber += Integer.toString(numberOnTheLeft);
				}
				
			println("The reversed number is "+ newNumber + ".");
			println("");
			
			}
		}
	}	
}
