import acm.program.ConsoleProgram;


public class HailstoneSequence extends ConsoleProgram{ 
	
	int count = 0;
	int n;
	
	public void run(){
		intoText();
		checkIf1After1Operation();
		findN1();
	}
	
	private void intoText(){
	println("This program determins the point at which n becomes 1.");
	}
	
	private boolean isEven(int n){
		return (n%2 == 0);
	}
	private boolean isOdd(int n){
		return (n%2 != 0);
	}
	
	private void checkIf1After1Operation(){
		n = readInt("Pick some positive integer: ");
		if (n==0 || n <0){
			println("You have not entered a positive integer.");
		} else if (isEven(n)){
			n = n/2;
			count++;
		} else if (isOdd(n)){
			n = n*3+1;
			count++;
		}
		
		if (n==1){
			println("It took " + count + " operations to get to 1.");
		}
	}
	
	private void findN1(){
		
		while(n !=1){
			
			while(isEven(n)){   //or if(isEven(n)){
				int originaln1=n;
				n = n/2;
				count++;
				println( originaln1 + " is even so I take half: " + n);
				
				if (n==1) break; 	
			}
			
			if (n==1) break;     // WOULD NOT need this line in that situation
	
			while(isOdd(n)){ //or if(isOdd(n)){
				int originaln2=n;
				n = n*3+1;
				count++;
				println(originaln2 + " is odd, so I make 3n+1: " + n);
				
				if (n==1) break; 
			}	
		}		
	println("The process took " + count + " to reach 1.");
	}
}
