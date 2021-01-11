/**
 * @author wrightm02
 * Purpose: Exercise - 7
 * Goal: To represent a person as a donor using their name, rating and address. 
 * Implementation: Use an object to store attributes for a donor, and get or set their information
 * 		as needed. Methods were updated to reprint accurate information or to set object
 * 		attributes based off of method arguments or user prompts and input.
 * Note:
 * 		Modifications were made to the original program. 'if' statements were swapped out
 * 		to switch-case, and updateRating() was updated to call a method written to print out a
 * 		string for the donor instead of having multiple calls from get*() statements, although
 * 		this can still be done if requesting only one attribute.
 */

package edu.buffalostate.cis425.fa19.exercises.wright;
import static java.lang.System.*;
import java.util.InputMismatchException;
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

	/**
	 * @param amt amount to base the rating off of
	 * Checks the value of amt and assigns a rating based off of  'if' matches.
	 */
	public void updateRating(int amt) {
		if (amt <= 0) {
			this.rating = "none";
		} else if (amt < 100) {
			this.rating = "low";
		} else if (amt >= 100 & amt < 1000) {
			this.rating = "medium";
		} else if (amt >= 1000) {
			this.rating = "high";
		} else this.rating = null;

		out.println("Updated Rating");
		out.println(this.printDonor());
	}

	/**
	 * @return donor - A string that is formatted to output the donor object attributes
	 */
	public String printDonor() {
		String donor = ( "\n" + 
				"Name:\t\t" + this.getName() +
				"\nAddress:\t" + this.getAddress() +
				"\nRating:\t\t" + this.getRating() + "\n"
				);// End print
		return donor;
	}

	/**
	 * @param argv
	 * Creates four Donor objects, initialized with values.
	 * The objects are then printed, and donorFour has its rating updated by contribution with an int,
	 * whereas donorTwo has its rating updated by prompting the user to enter a contribution.
	 *
	 * */
	public static void main(String argv[]) {
		
		// Creates three donor objects
		Donor donorOne = new Donor("Ricky Hastland", "high", "293 Richard Lane, Fairfield, New Jersey, 18274");
		Donor donorTwo = new Donor("Alice Falken", "medium", "277 Corkscrew Rd., Lancaster, New York, 13224");
		Donor donorThree = new Donor("Hagrid Wizard", "none", "932 Wizards Court, Magical City, Fairyland, 99999");
		
		// Creates a fourth donor object that will be modified
		Donor donorFour = new Donor("Guy Falken", "low", "277 Corkscrew Rd., Lancaster, New York, 13224");
		
		// Prints the initial list of donor objects and their attributes
		out.println(donorOne.printDonor());
		out.println(donorTwo.printDonor());
		out.println(donorThree.printDonor());
		out.println(donorFour.printDonor());
		
		// Updates donorFour's rating based off of their contribution then reprints
		donorFour.updateRating(150);
		
		//Prompts the user to enter the contribution to reevaluate rating


		out.println("Program Ending...");
	}// End main

}// End class