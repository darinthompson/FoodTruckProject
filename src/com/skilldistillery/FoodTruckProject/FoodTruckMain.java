package com.skilldistillery.FoodTruckProject;

import java.util.Scanner;

public class FoodTruckMain {
	private final static int MAX_FOOD_TRUCKS = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FoodTruck[] foodCaravan = new FoodTruck[MAX_FOOD_TRUCKS];
		String bordernl = ("***************************************************\n");
		String border = ("***************************************************");
		String spacing = ("**\t                                         **\n");
		double rating;
		FoodTruck ft;
		String truckName;
		String foodType;
        
		System.out.println("Welcome to the great food truck cook off!");
		for (int i = 0; i < MAX_FOOD_TRUCKS; i++) {
			System.out.print("Name of Truck (type 'quit' to stop adding trucks): ");
			truckName = sc.nextLine();
			if (!truckName.toLowerCase().equals("quit")) {
				System.out.print("Food Style: ");
				foodType = sc.nextLine();
				while (true) {
					System.out.print("Rating: (1 - 5)");
					System.out.flush();
					rating = sc.nextDouble();
					if (rating < 0 || rating > 5) {
						System.err.println("\nNOT A VALID RATING!");
						System.err.flush();
					} else {
						break;
					}
				}
				ft = new FoodTruck(truckName, foodType, rating);
				foodCaravan[i] = ft;
				sc.nextLine();
			} else {
				break;
			}
		}

		while (true) {
			System.out.print(bordernl);
			System.out.print("**\t                                         **\n");
			System.out.print("**\t1. Show all food trucks and data         **\n");
			System.out.print("**\t2. Show average rating of food trucks    **\n");
			System.out.print("**\t3. Show highest rated food truck         **\n");
			System.out.print("**\t4. quit                                  **\n");
			System.out.print("**\t                                         **\n");
			System.out.print(bordernl);
			System.out.print("  \tChoice: ");
			int userChoice = sc.nextInt();
			System.out.println();
			
			
			switch (userChoice) {
			case 1:
				System.out.println("\t\tTHE TRUCKS");
				System.out.println(border);
				for (FoodTruck truck : foodCaravan) {
					if (truck != null) {
						System.out.println("##");
						System.out.println(truck.toString());
						System.out.println("##");
						System.out.println(border);
					} else {
						break;
					}
				}
				System.out.println();
				break;
			case 2:
				double sum = 0;
				int numOfTrucks = 0;
				for (int i = 0; i < foodCaravan.length; i++) {
					if (foodCaravan[i] != null) {
						sum += foodCaravan[i].getRating();
						numOfTrucks++;
					} else {
						break;
					}
				}
				System.out.print(bordernl);
				System.out.print(spacing);
				System.out.printf("**\tAverage rating: " + String.format("%.1f", (sum / numOfTrucks)) + "/ 5.0 stars\t         **\n");
				System.out.print(spacing);
				System.out.print(bordernl);
				System.out.println();
				break;
			case 3:
				FoodTruck[] highestRated = new FoodTruck[MAX_FOOD_TRUCKS];
				double maxRating = 0;
				
				// Get's the highest rated rating of all the food trucks
				for (int i = 0; i < foodCaravan.length; i++) {
					if (foodCaravan[i] != null) {
						if (foodCaravan[i].getRating() > maxRating) {
							maxRating = foodCaravan[i].getRating();
						}
					} else {
						break;
					}
				}
				
				// Adds and all Food Trucks that have the highest ratings
				for (int i = 0; i < foodCaravan.length; i++) {
					if (foodCaravan[i] != null) {
						if (foodCaravan[i].getRating() == maxRating) {
							highestRated[i] = foodCaravan[i];
						} 
					} else {
						break;
					}
				}
				
				//Loops through and prints out all food that have the highest rating
				System.out.println("\t\tTHE HIGHEST RATED TRUCK(S)");
				System.out.println(border);
				for (FoodTruck truck : highestRated) {
					if (truck != null) {
						System.out.println("##");
						System.out.println(truck.toString());
						System.out.println("##");
						System.out.println(border);
					} else {
						break;
					}
				}
				System.out.println();
				break;
			case 4:
				System.out.println("  Hope you had enough food truck food. Cheers!");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("\t*****NOT A VALID CHOICE!*****\n");
				break;
			}
		}

	}
}
