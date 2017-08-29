import java.util.Scanner;

public class Main {

	static Scanner userInput = new Scanner(System.in);
	static boolean magic;

	public static void main(String[] args) {

		int[] lineone = { userInput.nextInt(), userInput.nextInt(), userInput.nextInt(), userInput.nextInt() };
		int[] linetwo = { userInput.nextInt(), userInput.nextInt(), userInput.nextInt(), userInput.nextInt() };
		int[] linethree = { userInput.nextInt(), userInput.nextInt(), userInput.nextInt(), userInput.nextInt() };
		int[] linefour = { userInput.nextInt(), userInput.nextInt(), userInput.nextInt(), userInput.nextInt() };

		int lineOneSum = lineone[0] + lineone[1] + lineone[2] + lineone[3];
		int lineTwoSum = linetwo[0] + linetwo[1] + linetwo[2] + linetwo[3];
		int lineThreeSum = linethree[0] + linethree[1] + linethree[2] + linethree[3];
		int lineFourSum = linefour[0] + linefour[1] + linefour[2] + linefour[3];

		int rowOneSum = lineone[0] + linetwo[0] + linethree[0] + linefour[0];
		int rowTwoSum = lineone[1] + linetwo[1] + linethree[1] + linefour[1];
		int rowThreeSum = lineone[2] + linetwo[2] + linethree[2] + linefour[2];
		int rowFourSum = lineone[3] + linetwo[3] + linethree[3] + linefour[3];

		if (rowOneSum == rowTwoSum) {

			if (rowTwoSum == rowThreeSum) {

				if (rowThreeSum == rowFourSum) {

					if (rowFourSum == lineOneSum) {

						if (lineOneSum == lineTwoSum) {

							if (lineThreeSum == lineFourSum) {
								
								magic = true;

								System.out.println("magic");
							
							}
						}
					}
				}
			}

		}
		
		if (magic != true)
		
System.out.println("not magic");

	}

}