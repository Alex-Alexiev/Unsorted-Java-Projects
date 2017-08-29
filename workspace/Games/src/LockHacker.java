import java.util.Scanner;

public class LockHacker {

	static Scanner userInput = new Scanner(System.in);
	static int[] thirdpos;

	public static void main(String[] args) {
		
		System.out.println("**THIS PROGRAM ONLY WORKS ON MASTER BRAND LOCKS**");
		
		System.out.println("Input the friction digit");
		int none = userInput.nextInt();
		int done = none+5;
		System.out.println("What is the first number it goes around?");
		int ntwo = userInput.nextInt();
		System.out.println("What is the second number it goes around?");
		int nthree = userInput.nextInt();
		int mod = done%4;

		
		if (done > 5){
			
			//thirdpos[0] = done;
			thirdpos[1] = done+10;
			thirdpos[2] = done+20;
			
		}
		
		else {
			
			//thirdpos[0] = done;
			thirdpos[1] = done+10;
			thirdpos[2] = done+20;
			thirdpos[3] = done+30;
			
		}
			
		System.out.println(done);
		

	}

}
