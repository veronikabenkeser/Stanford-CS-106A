import acm.program.ConsoleProgram;


public class RemoveCharacter extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter a sentence: ");
		String  letterToRemove = readLine("Enter the letter you want to remove from the sentence above: ");
		
		char ch = letterToRemove.charAt(0);
		 println(removeAllOccurances(str, ch));
	}
	
	public String removeAllOccurances(String str, char ch){
		String result="";
		
		for (int i =0; i<str.length(); i++){
			if(str.charAt(i) != ch){			
				result = result + str.charAt(i);
			}		
		}
		return result;
	}
}
	