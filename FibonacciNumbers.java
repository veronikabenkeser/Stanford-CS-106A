
import acm.program.ConsoleProgram;


public class  FibonacciNumbers  extends ConsoleProgram{ 
	
	private int int0=0;
	private int int1 =1;
	
	
	public void run(){
		for(int i=0; i<16; i++){
			int sum= int0+int1;
			int0=int1;
			int1=sum;
			println("F" + i +" = " + sum);
		}
	}
}
