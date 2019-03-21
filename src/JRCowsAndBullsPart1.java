import java.util.ArrayList;
import java.util.Scanner;

public class JRCowsAndBullsPart1 {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<Integer>(4);
		Boolean solved = false;
		for (int i = 0; i < 4; i++) {
			int temp = 0;
			do {
				temp = (int) (Math.random() * 9) + 1;
			} while (num.contains(temp));
			num.add(i, temp);
		}
		
		//loop while secret number is not found
		while(!solved) {
			//get input
			String input;
			System.out.println("Please enter a guess:");
			do {
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();
			}while(!valid(input));
			
			//calculate cows and bulls from guess
			int cows = 0;
			int bulls = 0;
			for (int i = 0; i < 4; i++) {
				int numInput = Character.getNumericValue(input.charAt(i));
				if (num.contains(numInput)) {
					if (num.get(i) == numInput) {
						bulls++;
					} else {
						cows++;
					}
				}
			}
			System.out.println("Bulls = " + bulls + ", Cows = " + cows);
			if (bulls == 4) {solved = true;}
		}
		System.out.println("Game Over");
	}
	
	//function to check the validity of input
	private static boolean valid(String input) {
		boolean valid = true;
		if (input.length() != 4) {valid = false;}
		try {
			int val = Integer.parseInt(input);
		}catch (NumberFormatException e) {
		    valid = false;
		}
		for (int i = 0; i < 4 && valid; i++)
		{
			char c = input.charAt(i);
			if (c == '0') {
				valid = false;
				break;
			}
			for (int j = 0; j < 4; j++) {
				if (input.charAt(j) == c && j != i) {
					valid = false;
				}
			}
		}
		if (!valid) {
			System.out.println("Error: invalid input. Please try again:");
		}
		return valid;
	}
	
	//function to print the guess arrayList
	static void print(ArrayList<Integer> num) {
		for (int i = 0; i < 4; i++) {
			System.out.println(num.get(i));
		}
	}
}

