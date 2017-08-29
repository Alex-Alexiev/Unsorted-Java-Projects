import java.util.Scanner;

public class Main_2 {

	static Scanner input = new Scanner(System.in);
	static int[] reading = new int[4];
	static boolean temp = false;
	
	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			reading[i] = input.nextInt();
		}
		if (greater()){
			System.out.println("Fish Rising");
		}
		else if (less()){
			System.out.println("Fish Diving");
		}
		else if (same()){
			System.out.println("Fish At Constant Depth");
		}
		else {
			System.out.println("No Fish");
		}
	}
	
	public static boolean greater(){
		for (int i = 0; i< 3; i++){
			if (reading[i] < reading[i+1]){
				temp = true;
			}
			else {
				temp = false;
				break;
			}
		}
		return temp;
	}
	public static boolean less(){
		for (int i = 0; i< 3; i++){
			if (reading[i] > reading[i+1]){
				temp = true;
			}
			else {
				temp = false;
				break;
			}
		}
		return temp;
	}
	public static boolean same(){
		for (int i = 0; i< 3; i++){
			if (reading[i] == reading[i+1]){
				temp = true;
			}
			else {
				temp = false;
				break;
			}
		}
		return temp;
	}

}