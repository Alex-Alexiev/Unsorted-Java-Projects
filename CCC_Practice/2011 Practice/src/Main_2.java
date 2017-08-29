import java.util.Scanner;

public class Main_2 {
	
	static Scanner scanner = new Scanner(System.in);

	static int tee = 1;
	
	public static void main(String[] args) {
		
		int h = 30;
		int m = 10;
		
		for (int t = 1; t < m ; t++){
			int a = -6*(t*t*t*t)+(h*(t*t*t))+2*(t*t)+t;
			if (a <= 0){
				tee = t;
				break;
			}
		}
		
		System.out.println(tee);
	}
}
