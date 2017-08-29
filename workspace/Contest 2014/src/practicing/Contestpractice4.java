package practicing;

import java.util.Scanner;

public class Contestpractice4 {  


	static Scanner userInput = new Scanner(System.in);

	public static void main(String args[]){
		
		
		int invities = userInput.nextInt();
		int rounds = userInput.nextInt();
		int[] multiples = new int[rounds];
		int[] invitie = new int[invities]; 
		int[] leftover = new int[invities];
					
		for (int i = 0; i < invities; i++ ){
			
			invitie[i] = i + 1;
		
			
			
		}
		
		
		for (int n = 0; n < rounds; n++){
			
			multiples[n] = userInput.nextInt(); 
			
		}
		
		
		for (int r = 0; r < rounds; r++){
			
			
			for (int in = 0; in < invities; in++){
				
				
				if (invitie[in] % multiples[r] == 0){
					
								
					
					
					
				}
			}
			
			
		}
		
	}
	
	
}