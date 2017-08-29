import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;

public class Main{
	
	static Random rand = new Random();
	
	static int left;
	static int lSpace;
	static int xPos = 15;
	static int rSpace;
	static int right;
	static char person = '+';
	static int total = 30;

	public static void main(String[] args) {
		while(true){
			printTrack();
		}
	}
	
	static void printTrack(){
		left = randInt(2,10);
		lSpace = xPos-left;
		right = randInt(2, 10);
		rSpace = (total-xPos)-right;
		
		for (int i = 0; i < left; i++){
			System.out.print("|");
		} 
		for (int i = 0; i < lSpace; i++){
			System.out.print(" ");
		}
		System.out.print(person);
		for (int i = 0; i < rSpace; i++){
			System.out.print(" ");
		}

		for (int i = 0; i < right; i++){
			System.out.print("|");
		}
		System.out.println();
	}
	
	static void keyStroke(KeyEvent e){
 
		
	}
	static int randInt(int min, int max){
		return rand.nextInt((max-min)+1)+min;
	}
}