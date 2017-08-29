import java.util.Scanner;

public class Main_3 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int input = 15;
		
		System.out.println(input);
		System.out.println(loopCheck(input-300));
		System.out.println(loopCheck(input-200));
		System.out.println(loopCheck(input-100));
		System.out.println(input);
		System.out.println(loopCheck(input+100));
		System.out.println(loopCheck(halfCheck(input+130)));
	}
	
	public static int loopCheck(int input){
		if (input < 0){
			return 2400+input;
		}
		else if(input > 2400) {
			return input-2400;
		}
		else {
			return input;
		}
	}
	
	public static int halfCheck(int input){
		int h = input/100;
		int m = input %100;
		
		if (m > 60){
			return ((h+1)*100)+(m-60);
		}
		else {
			return input;
		}
	}

}
