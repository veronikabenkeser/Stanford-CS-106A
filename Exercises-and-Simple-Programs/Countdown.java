import acm.program.ConsoleProgram;

public class Countdown extends ConsoleProgram{ 
	
	public void run(){
		int n=readInt("Enter a number to begin countdown:");
		
		while(n>0){ // can also solve this with a 'for' loop. If n=10, the program prints numbers starting from 9.
			n--;
			println(n);
	
		}
	}
}
