import acm.program.ConsoleProgram;



public class ThisOldManSong extends ConsoleProgram {

	private int number=1;
	private String[] word={"thumb", "shoe", "knee", "door", "hive", "sticks", "up to heaven", "pate", "spine", "shin"};

	
	public void run(){
	
		for (int i=0; i<10; i++){
			println("This old man, he played "+ number+ ".");
			println("He plaed kcik-knack on my " + word[i] + ".");
			println("With a knick-knack, paddy-whack,");
			println("Give your dog a bone.");
			println("This old man came rolling home.");
	
	
			number++;
			println("");
		}
	}
}
