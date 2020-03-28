package com.skilldistillery.FoodTruckProject;

import java.util.Scanner;

public class FoodTruckMain {
	private static int MAX_FOOD_TRUCKS = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FoodTruck[] foodCaravan = new FoodTruck[MAX_FOOD_TRUCKS];
		String spacing = "\n**************************\n";
		double rating;

		for (int i = 0; i < MAX_FOOD_TRUCKS; i++) {
			FoodTruck ft;
			String truckName;
			String foodType;
			System.out.print("Name of Truck (type 'quit' to stop adding trucks): ");
			truckName = sc.nextLine();
			if (!truckName.toLowerCase().equals("quit")) {
				System.out.print("Food Style: ");
				foodType = sc.nextLine();
				System.out.print("Rating: (1 - 5)");
				rating = sc.nextDouble();
				ft = new FoodTruck(truckName, foodType, rating);
				foodCaravan[i] = ft;
				sc.nextLine();
			} else {
				break;
			}
		}
		System.out.println(spacing);

		while (true) {
			System.out.println("1. Show all food trucks and data");
			System.out.println("2. Show average rating of food trucks");
			System.out.println("3. Show highest rated food truck");
			System.out.println("4. quit");
			System.out.print("Choice: ");
			int userChoice = sc.nextInt();
			
			switch(userChoice) {
			case 1: 
				System.out.println(spacing);
				for (FoodTruck truck : foodCaravan) {
					if (truck != null) {
						System.out.println(truck.toString());
						System.out.println(spacing);
					} else {
						break;
					}
				}
				System.out.println(spacing);
				break;
			case 2: 
				double sum = 0;
				int numOfTrucks = 0;
				System.out.println(spacing);
				for (int i = 0; i < foodCaravan.length; i++) {
					if(foodCaravan[i] != null) {
						sum += foodCaravan[i].getRating();
						numOfTrucks++;
					} else {
						break;
					}
				}				
				System.out.printf("Average rating: " + String.format("%.1f", (sum/numOfTrucks)) + "/5 stars");
				System.out.println(spacing);
				break;
			case 3: 
				double maxRating = 0;
				FoodTruck winningTruck = null;
				for (int i = 0; i < foodCaravan.length; i++) {
					if(foodCaravan[i] != null) {
						if(foodCaravan[i].getRating() > maxRating) {
							maxRating = foodCaravan[i].getRating();
							winningTruck = foodCaravan[i];
						}
					} else {
						break;
					}
				}
				System.out.println(winningTruck.toString());
				System.out.println(spacing);
				break;
			case 4:
				System.out.println("Hope you had enough food truck food. Cheers!");
				sc.close();
				System.exit(0);
			}
		}

	}
}

			