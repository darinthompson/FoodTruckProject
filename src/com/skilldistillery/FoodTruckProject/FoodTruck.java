package com.skilldistillery.FoodTruckProject;

public class FoodTruck {
	private static int ID = 1;
	private final static double MAX_RATING = 5.0;
	private int uniqueID;
	private String name;
	private String foodType;
	private double rating;
	
	public FoodTruck(String _name, String _foodtype, double _rating) {
		uniqueID = ID;
		name = _name;
		foodType = _foodtype;
		rating = _rating;
		ID++;
	}
	
	public int getID() {
		return uniqueID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setFoodType(String _foodtype) {
		foodType = _foodtype;
	}
	
	public void setRating(double _rating) {
		rating = _rating;
	}
	
	public String toString() {
		return ("##\tID: " + uniqueID + "\n" +
			"##\tName: " + name + "\n" +
			"##\tFood Type: " + foodType + "\n" +
			"##\tRating: " + String.format("%.1f", rating) + " / " + MAX_RATING + " stars");
	}
	
	
}
