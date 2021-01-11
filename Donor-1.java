/**
 * @author wrightm02
 * Purpose: Exercise - 7
 * Goal: To represent a person as a donor using their name, rating and address. 
 * Implementation: Use an object to store attributes for a donor, and get or set their information
 * 	as needed.
 */

package edu.buffalostate.cis425.fal19.exercises.wright;
import static java.lang.System.*;
import java.util.Scanner;

public class Donor {
	private String name = "No Name";
	private String rating = "None";
	private String address = "No Address";
	
	// Parameterized constructor
	public Donor(String name, String rating, String address) {
		this.name = name;
		this.rating = rating;
		this.address = address;
	}
	
	// Returns donor name
	public String getName() {
		return this.name;
	}
	
	// Returns donor rating based off of matching cases
	public String getRating() {
		switch (rating) {
		case "high":
			return "high";
		case "medium":
			return "medium";
		case "low":
			return "low";
		default: return "none";
		}
	}
	
	// Returns donor address
	public String getAddress() {
		return this.address;
	}
	
	public void updateRating() {
		Scanner sc = new Scanner(System.in);
		out.print("Please enter an amount for " + this.name + ":\t");
		int amt = sc.nextInt();
		
		if (amt == 0) {
			this.rating = "none";
		} else if (amt < 100) {
			this.rating = "low";
		} else if (amt >= 100 & amt < 1000) {
			this.rating = "medium";
		} else if (amt > 1000) {
			this.rating = "high";
		} else this.rating = null;
		
		sc.close();
	}
	
	// Overloaded updateRating method to allow manual amount entry on call
	public void updateRating(int amt) {
		
		if (amt == 0) {
			this.rating = "none";
		} else if (amt < 100) {
			this.rating = "low";
		} else if (amt >= 100 & amt < 1000) {
			this.rating = "medium";
		} else if (amt > 1000) {
			this.rating = "high";
		} else this.rating = null;
		
		out.println("Updated rating:\t\t" + this.printDonor());
	}
	
	public String printDonor() {
		String donor = ( "\n" + 
				"Name:\t\t" + this.name + 
				"\nAddress:\t" + this.address + 
				"\nRating:\t\t" + this.rating + "\n"
				);// End print
		return donor;
	}
	
	public static void main(String argv[]) {
		
		// Creates three donor objects
		Donor donorOne = new Donor("Ricky Hastland", "high", "293 Richard Lane, Fairfield, New Jersey, 18274");
		Donor donorTwo = new Donor("Alice Falken", "medium", "277 Corkscrew Rd., Lancaster, New York, 13224");
		Donor donorThree = new Donor("Hagrid Wizard", "low", "932 Wizards Court, Magical City, Fairyland, 99999");
		
		// Creates a fourth donor object that will be modified
		Donor donorFour = new Donor("Guy Falken", "low", "277 Corkscrew Rd., Lancaster, New York, 13224");
		
		// Prints the initial list of donor objects and their attributes
		out.println(donorOne.printDonor());
		out.println(donorTwo.printDonor());
		out.println(donorThree.printDonor());
		out.println(donorFour.printDonor());
		
		// Updates donorFour's rating based off of their contribution then reprints
		donorFour.updateRating(155);
		
		//Prompts the user to enter the contribution to reevaluate rating
		donorTwo.updateRating();
		
	}// End main
	
}// End class