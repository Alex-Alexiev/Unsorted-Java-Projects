import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static String path = "C:/Users/aalexiev/Google Drive/Programming/Eclipse Projects/CapitalFinder/Data/capitals.txt";

	public static void main(String[] args) throws Exception {

		List<String> readAll = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		List<String> readAllLines = new ArrayList<String>();
		List<String> capitals = new ArrayList<String>();
		List<String> countries = new ArrayList<String>();
		
		for(String s : readAll){
			readAllLines.add((s.toLowerCase()).trim());
		}

		for (int i = 0; i < readAllLines.size(); i++) {

			if (i % 2 == 0) {
				capitals.add(readAllLines.get(i));
			} else {
				countries.add(readAllLines.get(i));
			}

		}
		
		boolean loop = true;
		String userInput = "";
		int index = 0;
		boolean country = true;

		while (loop) {
			System.out.println("Enter the name of the country in all lowercase");
			userInput = input.nextLine();
			for(int i = 0; i < countries.size(); i++){
				String s = countries.get(i);
				if (userInput.equals(s)){
					index = i;
					country = true;
					break;
				} 
				else{
					country = false;
				}

			}
			if(country == true){
				System.out.println("The capital of "+userInput+" is "+capitals.get(index));
				System.out.println(" ");
			}
			else{
				System.out.println("You did not enter the name of a real country");
			}
		}

	}
	
}
