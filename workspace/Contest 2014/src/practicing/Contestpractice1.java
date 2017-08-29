package practicing;
import java.util.Scanner;

public class Contestpractice1 {

	static Scanner userInput = new Scanner(System.in);

	public static void main(String args[]) {

			int angle1 = userInput.nextInt();
			int angle2 = userInput.nextInt();
			int angle3 = userInput.nextInt();
			
			if(angle1 + angle2 + angle3 == 180){
			
				if ((angle1 == 60) && (angle2 == 60) && (angle3 == 60)){
					
					System.out.println("Equilateral");
					
				}
				
				if ((angle1 != angle2) && (angle2 != angle3) && (angle3 != angle1)){
					
					System.out.println("Scalene");
				}
				
				if ((angle1 == angle2) || (angle2 == angle3) || (angle3 == angle1)){
					
					System.out.println("Isosceles");
				}
	
			}
			
			else{
				
				System.out.println("Error"); 
				
		
			
			}
			
	}
	
	
}
			
			
	
