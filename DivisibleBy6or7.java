import acm.program.ConsoleProgram;

public class DivisibleBy6or7 extends ConsoleProgram{ 
	
	private int n;
	
	public void run(){
		for(n=1; n<=100; n++){
			if ((n%6==0 || n%7==0) && !(n%6==0 && n%7==0)){
			println(n);
			}
		}
	}
}