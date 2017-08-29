import java.util.Scanner;

public class Main_2 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int bt = 1;
		int np = 2;
		int yp = 3;
		int max = 1000;
		int ways = 0;
		
		for (int i = 0; i <= max/yp + 1; i++){
			for (int j = 0; j < max/np + 1; j++){
				for (int l = 0; l < max/bt + 1; l++){
					if (i*yp+j*np+l*bt <= max && i*yp+j*np+l*bt != 0){
						//System.out.println(l+":"+j+":"+i);
						ways++;
					}
				}
			}
		}
		
		System.out.println(ways);
	}

}
