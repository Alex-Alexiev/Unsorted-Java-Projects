package practicing;

import java.util.Scanner;

public class Contestpractice2 {
	
	static int as = 0; 
	static int bs = 0;  

	static Scanner userInput = new Scanner(System.in);

	public static void main(String args[]) {
		
		
		int length = userInput.nextInt();
		userInput.nextLine();
		String string = userInput.nextLine();
		
		
		for (int n = 0; n < length; n++){
			
			char letter = string.charAt(n);
			
			
			if (letter == 'A'){	
			
				
				as++;
				 
			}
			
			else if (letter == 'B'){ 
				
				bs++;
			}
			 
			
			
		}
		
		if (as == bs){
			
			System.out.println("Tie");
		}
		
		else if (as > bs){
			 
			System.out.println("A");
		}
		
		else if (as < bs){
			
			System.out.println("B");  
		} 		
		
		
		
	}
	
	
	
}
	
