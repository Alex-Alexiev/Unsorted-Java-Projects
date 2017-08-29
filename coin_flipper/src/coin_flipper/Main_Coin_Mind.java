package coin_flipper;

import java.util.Scanner;

public class Main_Coin_Mind {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int space = 2;
		int coins = 10;
		int[] states = new int[coins];

		for (int n : states) {
			n = 0;
		}

		while (space <= coins) {
			for (int i = 0; i < coins; i++) {
				if (states[i] % space == 0) {
					if (states[i] == 0) {
						states[i] = 1;
					} else if (states[i] == 1) {
						states[i] = 0;
					}
				}
			}
			space++;
		}

		for (int n : states) {
			System.out.println(n);
		}
	}

}
