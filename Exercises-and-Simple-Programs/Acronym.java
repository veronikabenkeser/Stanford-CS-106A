import acm.program.ConsoleProgram;

public class Acronym extends ConsoleProgram {
	public void run() {
		println("This program translates full names of objects into acronyms.");
		while(true){ 
			String original = readLine("Enter the thing's full name: ");
			String acronym = makeAcronym(original);
			println("The acronym is: " + acronym);
		}
	}
	
	private String makeAcronym(String original){
		String result = "" + original.charAt(0);
		
		for( int i = 0; i < original.length(); i++){
			char ch = original.charAt(i);
			
			if (Character.isWhitespace(ch)){				
				if(!Character.isLowerCase(original.charAt(i+1))){
					result += original.charAt(i+1);
				}
			}
		}
		return result;
	}
}

/*
OR 
private String acronym(String str) {
	String result = str.substring(0, 1);
	int pos = str.indexOf(' ');
	while (pos != -1) {
		result += str.substring(pos + 1, pos + 2);
		pos = str.indexOf(' ', pos + 1);
	}
	return result;
}
*/
