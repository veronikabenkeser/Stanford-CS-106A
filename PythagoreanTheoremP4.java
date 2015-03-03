
import acm.program.ConsoleProgram;


public class PythagoreanTheoremP4  extends ConsoleProgram{ 

	public void run(){
		println("Enter values to compute Pythagorean theorem.");
		int a = readInt("a: ");
		int b = readInt("b: ");
		
		double c = (double)(Math.sqrt((Math.pow(a, 2))+Math.pow(b,2)));
		
		println("c = " + c);
	}
}