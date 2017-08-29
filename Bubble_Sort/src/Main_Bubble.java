import java.util.Scanner;

public class Main_Bubble {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int size = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++){
			arr[i] = scanner.nextInt();
		}
		 
		System.out.println("Array Before Bubble Sort");
		for (int i = 0; i < arr.length; i++) {
		 	System.out.print(arr[i] + " ");
		}
		System.out.println();

		bubbleSort(arr);

		System.out.println("Array After Bubble Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				} 
			}
		}
	}
}
