import java.util.Scanner;

public class Main_4 {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean works = false;
		int n = 4;
		int[] temp = {3,4,6,7};
		
		for (int i = 1; i < n+1; i++){
			int[] hypo = new int[i];
			for (int j = 0; j < i; j++){
				hypo[j] = temp[j+1]-temp[j];
			}
			works = true;
			for(int k = 0; k < n-1; k++){
				if (!(temp[k+1]-temp[k] == hypo[k%i])){
					works = false;
					break;
				}
			}
			if (works){
				System.out.println(i);
				i = n;
			}
		}
	}

}
