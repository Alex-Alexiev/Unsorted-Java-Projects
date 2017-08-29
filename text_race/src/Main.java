import java.util.Scanner;
import java.util.Random;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	
	public static void main(String[] args) {
		
		printTrack(10, 5, 10);
	}
	
	public static void printTrack(int left, int space, int right){
		
		for (int i = 0; i < left; i++){
			System.out.print("|");
		}
		
		for (int i = 0; i < space; i++){
			System.out.print(" ");
		}
		
		for (int i = 0; i < right; i++){
			System.out.print("|");
		}
		
	}

}
