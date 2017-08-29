import java.util.Scanner;

public class Main_4 {

	static int w = 10;

	public static void main(String[] args) {

		String message = "WELCOME TO CCC GOOD LUCK TODAY";
		String[] all = message.split(" ");
		int lineBegin = 0;
		String currentLine = "";
		int lineIndex = 0;

		while (lineIndex < all.length) {
			if (currentLine.length() + all[lineIndex].length() <= w) {
				if (lineIndex != lineBegin) {
					currentLine += "-";
				}
				currentLine += all[lineIndex];
				lineIndex++;
			} else {
				System.out.println(insertSpaces(currentLine));
				currentLine = "";
				lineBegin = lineIndex;
			}
		}
		if (currentLine.length() != 0) {
			System.out.println(insertSpaces(currentLine));
		}

	}

	public static String insertSpaces(String input) {
		String[] words = input.split("-");
		if (words.length == 1){
			return input+generateSpaces(w-input.length());
		}
		int totalSpaces = (w - input.length()) + ((words.length) - 1);
		int spacesPer = totalSpaces / (words.length -1);
		int leftSpaces = totalSpaces - (spacesPer * (words.length - 1));
		String ret = words[0];

		for (int i = 1; i < words.length; i++) {
			int toAdd = (leftSpaces < i) ? spacesPer: spacesPer + 1 ;
			ret += generateSpaces(toAdd) + words[i];
		}
		return ret;
	}

	public static String generateSpaces(int spaces) {
		String ret = "";
		for (int i = 0; i < spaces; i++) {
			ret += ".";
		}
		return ret;
	}
}
