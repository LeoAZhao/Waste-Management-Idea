package Hack49;

import java.util.Scanner;
import java.util.Random;


public class WasteManagement {

	public static void main(String[] args) {
		
		double totalWaste = 0, wasteAmount = 0;
		double totalPeople = 1, expectedWaste = 0;
		int overTracker = 0, day = 1;
		int guess= 0,  numGuess = 0, answer = 0;
		boolean correct = false;
		
		String[] foodCompany = {"Costco", "Food Basics", "Walmart", "T&T", "Nofrills", "Canadian Superstore"};
		String[] motivationTips = {"Purchase wisely and recycle","Compost food waste!", "Avoid single-use food and drink containers and utensils", "Buy secondhand items and donate used goods", "Shop local farmers markets and buy in bulk to reduce packaging", "Ditch tea bags!", "Reduce plastic wrap with bees wrap!"};
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many people are in your household? ");
		totalPeople = sc.nextDouble();
		
		while (true) {
			wasteAmount = 0;
			expectedWaste = totalPeople*1.5;
			System.out.print("================================================================================\nDay "+ day+ "\n");
			System.out.print("How much waste in kilograms have your household produced so far? ");
			wasteAmount = sc.nextDouble();
			if (wasteAmount < expectedWaste) {
				System.out.printf("You are currently producing %.2f kg less waste than expected! Good job!\n\n", expectedWaste-wasteAmount);
			} else if (wasteAmount == expectedWaste) {
				System.out.print("You are still reach sustainable levels of garbage! Keep it up!\n\n");
			} else if (wasteAmount-expectedWaste <= 1.0) {
				System.out.print("Ooo, you are a little off the sustainable level. Try to reduce your waste!\n\n");
				overTracker++;
			} else if (wasteAmount-expectedWaste >= 50.0){
				System.out.print("You have made way too much garbage today! The world is disappointed in you.\n\nYou will regret it.\n\n");
				overTracker += 1000;
			} else {
				System.out.print("You are quite a bit above what is sustainable. The Earth is feeling bad :(.\n\n");
				System.out.print("Here's a tip for tomorrow: "+motivationTips[rand.nextInt(0, 7)]);
				System.out.print("\n");
				overTracker+=2;
			}
			day++;
			
			if (day > 7) {
				numGuess = 3;
				correct = false;
				answer = rand.nextInt(0,overTracker*2)+1;
				day = 1;
				if (overTracker == 0) {
					System.out.print("Congrats on being sustainable this week! You get a coupon for shopping!");
					correct = true;
				} else {
					System.out.print("Time for a game! Everytime you went over the sustainable level, your guessing number increased.\n This week's is " + overTracker*2 + ". Good luck!\n");
					while (numGuess >= 1) {
						System.out.print("You have " + numGuess+ " guess(es).\nNext Guess: ");
						guess = sc.nextInt();
						if (guess < answer) {
							System.out.print("Too low!\n");
							numGuess--;
						} else if (guess > answer) {
							System.out.print("Too high!\n");
							numGuess--;
						} else {
							System.out.print("You got it!\n");
							correct = true;
							numGuess = 0;
						}
					}
					if (correct) {
						System.out.print("Here is your prize! A 15% discount at "+ foodCompany[rand.nextInt(0,6)]+"!\n");
					}
				}
			}
		}
		
	}

}
