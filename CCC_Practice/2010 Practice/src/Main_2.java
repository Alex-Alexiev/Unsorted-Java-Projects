import java.util.Scanner;

public class Main_2 {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int s = scanner.nextInt();
		int abPos = 0;
		int cdPos = 0;
		boolean abDirection = true;
		boolean cdDirection = true;
		int abLastCount = 0;
		int cdLastCount = 0;
		
		for (int i = 0; i < s; i++){
			if (abDirection){
				abPos++;
				abLastCount++;
				if (abLastCount == a){
					abLastCount = 0;
					abDirection = false;
				}
			}
			else {
				abPos--;
				abLastCount ++;
				if (abLastCount == b){
					abLastCount = 0;
					abDirection = true;
				}
			}
			if (cdDirection){
				cdPos++;
				cdLastCount++;
				if (cdLastCount == c){
					cdLastCount = 0;
					cdDirection = false;
				}
			}
			else {
				cdPos--;
				cdLastCount ++;
				if (cdLastCount == d){
					cdLastCount = 0;
					cdDirection = true;
				}
			}
		}
		if (abPos > cdPos){
			System.out.println("Nikky");
		}
		if (abPos < cdPos){
			System.out.println("Byron");
		}
		if (abPos == cdPos){
			System.out.println("Tied");
		}
	}
}
