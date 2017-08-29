import java.util.Scanner;

public class Main_3 {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int t1 = 120;
		int t2 = 71;
		System.out.println(sumac(t1, t2));
				
	}
	
	public static int sumac(int t1, int t2){
		if ((t1-t2) > t2){
			return 3;
		}
		else {
			return (1+sumac(t2, (t1-t2)));
		}
	}

}
