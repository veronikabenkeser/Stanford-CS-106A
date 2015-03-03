import acm.program.ConsoleProgram;

public class RemoveSubStrings2 extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter a sentence: ");
		String  substringToRemove = readLine("Enter the fragment you want to remove from the sentence above: ");
	
		 println(removeAllSubstrings(str, substringToRemove));
	}


	private String removeAllSubstrings(String str, String substringToRemove){
		for (int i =0; i<str.length(); i++){
			int substringIndex = str.indexOf(substringToRemove);
				if (substringIndex > 0){
						str = str.substring(0, substringIndex) + str.substring(substringIndex+substringToRemove.length(), str.length());
				}	
		}
		return str;
	}
}