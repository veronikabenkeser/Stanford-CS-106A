import acm.program.ConsoleProgram;

public class RemoveDuplicateLetter extends ConsoleProgram {
		public void run() {
		String word = readLine("Enter a word: ");
		println(removeDuplicateLetter(word));
	}
		
		private String removeDuplicateLetter(String word){
			String result = "";
			for (int i=0; i<word.length()-1; i++){
				char ch =word.charAt(i);
				if (ch != word.charAt(i+1)){
					result += ch;
				}
			}
			return result+word.charAt(word.length()-1);
		}
}
