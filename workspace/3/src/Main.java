import java.util.Scanner;

class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {

		String string = input.nextLine();
		int length = string.length();
		String longest = "";

		for (int i = 0; i < length; i++) {

			for (int x = i + 1; x <= length; x++) {

				String strTemp = string.substring(i, x);
				
				 if (checkFor(strTemp) == true){
					 
					 if (strTemp.length() > longest.length()){
						 
						 longest = strTemp;
						 
					 }
				 }

			}
		}
		
		System.out.println(longest.length());
	}

	static boolean checkFor(String string2) {

		String reverse = "";
		boolean ret;

		for (int i = string2.length() - 1; i >= 0; i--) {

			reverse = reverse + string2.charAt(i);

		}
		if (reverse.equals(string2)) {

			ret = true;

		}

		else {

			ret = false;
		}

		return ret;

	}
}
