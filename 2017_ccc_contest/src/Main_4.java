import java.util.Scanner;

public class Main_4 {
	
	static Scanner scanner = new Scanner(System.in);
	static int[] time = {1,2,0,0};
	
	public static void main(String[] args) {

		int d = scanner.nextInt();
		int counter = 0;
		int loopCounter = 0;
		
		while(loopCounter <= d){
			if (check(time[0], time[1], time[2], time[3])){
				counter++;
			}
			upTime();
			loopCounter++;
		}
		
		System.out.println(counter);

	}
	
	public static boolean check(int a, int b, int c, int d){
		
		int[] input = {a, b, c, d};
		
		int dif = input[1] - input[0];
		
		for (int i = 0; i < 3; i++){
			if (input[i+1] - input[i] != dif){
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void upTime(){
		time[3]++;
		if (time[3] == 10){
			time[2]++;
			time[3] = 0;
			if (time[2] == 7){
				time[1]++; 
				time[2] = 0;
				time[3] = 0;
				if (time[1] == 10){
					time[1] = 0;
					time[2] = 0;
					time[3] = 0;
				}
			}
		}
	}

}
