import java.util.Scanner;

public class Main_2 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int ret = n;
		
		for (int i = 0; i < k; i++){
			n+=ret*10;
			ret = ret*10;
			System.out.println(n);
		}
		
		System.out.println(n);
		
	}
}