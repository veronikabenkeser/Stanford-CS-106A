import acm.program.ConsoleProgram;

public class RemoveSubStrings extends ConsoleProgram {
	public void run() {
		 System.out.println("the result " + 13/2%2);

		String str = readLine("Enter a sentence: ");
		String  substringToRemove = readLine("Enter the fragment you want to remove from the sentence above: ");
	
		 println(removeAllSubstrings(str, substringToRemove));
	}


	private String removeAllSubstrings(String str, String substringToRemove){
		while(str.indexOf(substringToRemove)>=0){ // while the str contains the substring
			int startOfSubstringToRemove = str.indexOf(substringToRemove);
		
			if (startOfSubstringToRemove != 0){
				str = (str.substring(0, startOfSubstringToRemove) + str.substring(startOfSubstringToRemove+substringToRemove.length(), str.length()));
			} else {
				str = str.substring(substringToRemove.length(), str.length());
			}
		}
		return str;
	}
}
