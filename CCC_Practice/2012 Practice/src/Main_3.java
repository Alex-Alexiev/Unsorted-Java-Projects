import java.util.Scanner;

public class Main_3 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int k = input.nextInt();
		
		char[][] icon = {
				{'*','x','*'},
				{' ','x','x'},
				{'*',' ','*'},
		};
		
		for (int a = 0; a <3; a++){
			for(int b = 0; b < k; b++){
				for(int c = 0; c < 3; c++){
					for(int d = 0; d < k; d++){
						System.out.print(icon[a][c]);
					}
				}
				System.out.println();
			}
		}
		
		
	}

}
