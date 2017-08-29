package practicing;

import java.util.Scanner;

public class Contestpractice3 {   


	static Scanner userInput = new Scanner(System.in);

	public static void main(String args[]){
		
		
		int rolls = userInput.nextInt(); 
		int[] roll1 = new int[rolls];
		int[] roll2 = new int[rolls];
		int aScore = 100;
		int bScore = 100;

		
		
		for (int n = 0; n < rolls; n++){ 		
			
			
			roll1[n] = userInput.nextInt(); 
			roll2[n] = userInput.nextInt();
					
			
		}
	
		
		
		for (int i = 0; i < rolls; i++){
			
			if (roll1[i] > roll2[i]){
				
				aScore = aScore - roll1[i];
				
			}
			
			else if (roll1[i] < roll2[i]){
				
				bScore = bScore - roll2[i];
				
			}
			
			
			
			
			
		}
		
		System.out.println(bScore);
		System.out.println(aScore);

		
		
		
	}
	
	
}
