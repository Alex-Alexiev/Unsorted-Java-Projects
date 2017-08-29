
import java.util.Scanner;

public class Main {

	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {

		int win = 0;
		int counter = 0;
		int group = 0;

		while (counter <= 5) {

			String status = userInput.nextLine();

			if (status.startsWith("W")) {

				win++;

			}
			counter++;
		}

		if (win == 5 || win == 6) {

			group = 1;

		}

		else if (win == 3 || win == 4) {

			group = 2;
		} else if (win == 1 || win == 2) {

			group = 3;
		} else if (win == 0) {

			group = -1;
		}

		System.out.println(group);

	}

}
