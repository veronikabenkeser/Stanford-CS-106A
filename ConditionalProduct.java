
public class ConditionalProduct {
	public static void main(String[]args) {
		int lowerbound = 1, upperbound = 1000;
		int sumOdd = 0;
		int sumEven = 0;
		int number = lowerbound;
		while(number <= upperbound) {
			if (number % 2 == 0) {
				sumEven += number; //same as sumEven = sumEven + number
			} else {
				sumOdd += number; //same as sumOdd - sumOdd + number
			}
			++number;
		}
		System.out.println("The sum of odd numbers from " + lowerbound + " to " + upperbound + " is " + sumOdd);
	}
}
