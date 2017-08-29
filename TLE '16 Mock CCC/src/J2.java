import java.util.Arrays;
import java.util.Scanner;

public class J2 {

	public static Scanner scanner = new Scanner (System.in); 
	
	public static void main(String[] args) {
		int f = scanner.nextInt();
		int n = scanner.nextInt();
		Integer[] c = new Integer[f];
		long cost = 0;
		long power = n;
		long tempPro = 1;
		for (int i =0; i < f; i++){
			c[i] = scanner.nextInt();
		}
		Arrays.sort(c);
		
		for (int i = 0; i < n ; i++){
			//cost +=  Math.pow(c[i], power);
			for (int j = 0; j < power; j++){
				tempPro *= c[i];
			}
			cost += tempPro;
			tempPro = 1;
			power--;
		}
		System.out.println(cost %1000000007);
	}
}
