import java.util.Scanner;

public class Main_3 {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int t = scanner.nextInt();

		int total = Math.abs(a-b) + Math.abs(c-d);
		
		String result = (((t-total) >= 0) && ((t-total)%2 == 0))? "Y": "N";
		System.out.println(result);
	}
}


