import acm.program.ConsoleProgram;


public class SongLyrics extends ConsoleProgram {
	private int numberOfBottles = 4;

	public void run(){
		for(int i=0; i<4; i++){
		
			println(numberOfBottles + (numberOfBottles==1? " bottle of beer on the wall.":" bottles of beer on the wall."));
			println(numberOfBottles + (numberOfBottles==1? " bottle of beer.":" bottles of beer."));
			println("You take one down, pass it around.");
			
			numberOfBottles--;
			
			println(numberOfBottles + (numberOfBottles==1? " bottle of beer on the wall.":" bottles of beer on the wall."));
			println("");
		}
	}
}
