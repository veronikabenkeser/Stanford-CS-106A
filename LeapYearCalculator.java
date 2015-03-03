public class LeapYearCalculator {
	
	public static void main(String[]args) {
		int startyear = 1;
		int endyear = 2010;
		int leapyear = 0;
		int number2 = startyear;
		int count = 0;
		int lowerbound = 1, upperbound = 1000;
		int number = lowerbound;
		int sum = 0;
		
		while(number <= upperbound) {
			if ((number % 13 == 0) && (number % 15 == 0) && (number % 17 == 0) && (number % 30 !=0)) {
				sum = sum + number;
			}
			number++;
		}
		
		while(number2 <= endyear){
			if (((number2 % 4 == 0) && (number2 % 100 != 0)) || (number2 % 400 == 0)) {
				count++;
				System.out.println("What are the years?" + " The years are " +  number2 + ".");
			}
			number2++;
		}
		
		System.out.println("How many leapyears are there from AD1 to AD 2010? " + count + ".");
	}
}