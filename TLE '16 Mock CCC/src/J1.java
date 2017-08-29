import java.util.Scanner;

public class J1 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int paper = scanner.nextInt();
		int maxPaper = scanner.nextInt();
		int a = scanner.nextInt();
		int[][] A = new int[a][2];
		boolean printing = true;
		int time  = 1;
		int pointer = 0;
		
		for (int i = 0; i < a; i++){
			A[i][0] = scanner.nextInt();
			A[i][1] = scanner.nextInt();
		}
		
		while(printing){
			paper--;
			if (time == A[pointer][0]){
				paper += A[pointer][1];
				pointer++;
			}
			if (paper > maxPaper){
				System.out.println("The printer jams at "+time+" second(s).");
				printing = false;
			}
			else if (paper <= 0){
				time++;
				System.out.println("The printer melts at "+time+" second(s).");
				printing = false;
			}			
			time++;
		}
	}
}

