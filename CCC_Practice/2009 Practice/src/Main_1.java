import java.util.Scanner;

public class Main_1 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){
		int[] digit = new int[3];
		System.out.println("Digit 11?");
		digit[0] = scanner.nextInt();
		System.out.println("Digit 12?");
		digit[1] = scanner.nextInt();
		System.out.println("Digit 13?");
		digit[2] = scanner.nextInt();
		
		System.out.println("The 1-3-sum is "+(91+digit[0]+digit[2]+(digit[1]*3)));
	}
	
}