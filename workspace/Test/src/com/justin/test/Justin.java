package com.justin.test;

import java.util.Scanner;

public class Justin {

	static Scanner input = new Scanner(System.in);
	static String suffix;

	public static void main(String[] args) {
		
		System.out.println("This program will add the suffix to the date, st, rd, of th\n");
		
		while (true){
			dateCalculator();
			System.out.println("Do you want to enter a new date?(yes/no)\n");
			
			String again = input.nextLine();
			
			if (!again.startsWith("y")){
				
				return; 
			}
				

		}


	}

	static void dateCalculator() {

		System.out.println("Enter the number of today's date");

		int date = input.nextInt();
		input.nextLine();

		System.out.println("What month is it?");

		String month = input.nextLine();

		switch (date) {

		case 1:
			suffix = "st";
			break;

		case 2:
			suffix = "nd";
			break;

		case 3:
			suffix = "rd";
			break;

		default:
			suffix = "th";
			break;
		}

		System.out.println("Today is the " + date + suffix + " of " + month + "\n");

	}

}
