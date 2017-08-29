import java.util.Scanner;

public class Main_3 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int A = 0;
		int B = 0;

		while (true) {
			String input = scanner.nextLine();
			String[] token = input.split(" ");
			int command = Integer.parseInt(token[0]);

			switch (command) {
			case 1:
				if (token[1].equals("A")) {
					A = Integer.parseInt(token[2]);
				} else {
					B = Integer.parseInt(token[2]);
				}
				break;
			case 2:
				if (token[1].equals("A")) {
					System.out.println(A);
				} else {
					System.out.println(B);
				}
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				int op1 = (token[1].equals("A")) ? A : B;
				int op2 = (token[2].equals("A")) ? A : B;

				if (command == 3) {
					op1 = op1 + op2;
				} else if (command == 4) {
					op1 = op1 * op2;
				} else if (command == 5) {
					op1 = op1 - op2;
				} else if (command == 6) {
					op1 = op1 / op2;
				}
				
				if (token[1].equals("A")){
					A = op1;
				}
				else {
					B = op1;
				}
				break;
			case 7: return;
			}

		}
	}
}
