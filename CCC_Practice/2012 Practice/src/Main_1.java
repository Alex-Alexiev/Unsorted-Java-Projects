import java.util.Scanner;

public class Main_1 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the speed limit: ");
		int speedLimit = input.nextInt();
		System.out.println("Please enter the recorded speed:");
		int speed = input.nextInt();
		if (speed < speedLimit){
			System.out.println("Congratulation, you are not speeding!");
		}
		if (speed > speedLimit){
			int dif = speed - speedLimit;
			if (dif <= 20){
				System.out.println("You are speeding and your fine is $100");
			}
			else if (dif <= 30){
				System.out.println("You are speeding and your fine is $270");
			}
			else {
				System.out.println("You are speeding and your fine is $500");
			}
		}
		
		
	}

}