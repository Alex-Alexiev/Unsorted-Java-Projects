package war;

import java.util.Scanner;
import java.util.Random;

public class warMain {

	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();

	static int human = 0;
	static int comp = 0;
	static int humanScore = 0;
	static int compScore = 0;
	static boolean loop = true;

	public static void main(String[] args) {
		System.out.println("Type draw to draw your cards.");
		System.out.println("Type score to show the scores.");
		System.out.println("Type reset to reset the scores.");
		while (loop) {
			String word = input.nextLine();
			if (word.equals("draw")) {
				draw();
				System.out.println("Your card: " + human);
				System.out.println("My card: " + comp);
				if (human < comp) {
					compScore++;
					System.out.println("Looks like I won this round!!!");
				} else if (comp < human) {
					humanScore++;
					System.out.println("You might have won this round, but not yet the war!!!");
				}
			} else if (word.equals("score")) {
				System.out.println("Your score: " + humanScore);
				System.out.println("My score: " + compScore);
				continue;
			} else if (word.equals("reset")) {
				humanScore = 0;
				compScore = 0;
				System.out.println("The scores have been reset. We shall meet again soon!!!");
				continue;
			}
		}
	}

	public static void draw() {
		comp = rand.nextInt(15);
		human = rand.nextInt(15);
	}

}
