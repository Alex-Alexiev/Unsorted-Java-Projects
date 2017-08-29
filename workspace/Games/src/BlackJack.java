import java.util.Scanner;
import java.util.Random;

public class BlackJack {

	static Scanner userInput = new Scanner(System.in);
	static Random random = new Random();
	static String answer;
	static int i;

	public static void main(String[] args) {

		boolean loop = true;

		while (loop == true) {

			System.out.println("Hi there, what is your name?");
			String name = userInput.nextLine();
			System.out.println("Hello " + name + ", I am kcajkcalB!");
			System.out.println("Would you like to play Blackjack?");
			answer = userInput.nextLine();

			if (answer.startsWith("y") || answer.startsWith("Y")) {

				playGame();

				loop = false;

			}

			else {

				loop = true;
			}

		}

	}

	static void playGame() {
		
		while (!answer.startsWith("s") || !answer.startsWith("S")){
			
		i = 2;
		System.out.println("Here are your cards:");
		int[] pCards = { random.nextInt(13) + 1, random.nextInt(13) + 1 };
		int[] cCards = { random.nextInt(13) + 1, random.nextInt(13) + 1 };
		System.out.println("Computer's cards: XX");
		System.out.println("Your cards: " + pCards[0] + " " + pCards[1]);
		System.out.println("Would you like to hit, stay, of fold?");
		answer = userInput.nextLine();
		
		if (answer.startsWith("h") || answer.startsWith("H")){
			
			System.out.println("Here are your new cards:");
			pCards[i] = random.nextInt(13) + 1;
			System.out.println(pCards[i]);
			
		}
		
		i++;
		
		}
		

	}

}