import java.util.Scanner;

public class Main_4 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int k = input.nextInt();

		String word = input.next();

		char[] letter = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			letter[i] = word.charAt(i);
		}
		for (int p = 1; p < letter.length + 1; p++) {
			letter[p - 1] -= (3 * p) + k;
			while (letter[p - 1] < 'A') {
				letter[p - 1] += 26;
			}
		}
		System.out.println();
		for (int i = 0; i < word.length(); i++) {
			System.out.print(letter[i]);
		}

	}

}
