/**
 * @author matthewwright
 * Class: CIS425
 * Assignment: One (create a box class)
 * Goal: Create a Box object and use class methods to perform
 * 		 certain arithmetic operations on its instance variables.
 */
package edu.buffalostate.cis425.fa19.assignments.wright;
import static java.lang.System.out;

public class Box {
	
	private int L1, W1, H1;
	private double Weight;

	//Default constructor
	public Box() {
		L1 = 0;
		W1 = 0;
		H1 = 0;
		Weight = 0;
	}
	
	//Constructor with param. for each instance var.
	public Box(int L, int W, int H, int Weight) {
		L1 = L;
		W1 = W;
		H1 = H;
		this.Weight = Weight;
	}
	
	public double calculateVolume() {
		return L1 * H1 * W1;
	}
	
	/**
	 * @param vol is the func. calculateVolume()'s return passed as an argument during calling of calculateDensity()
	 * @return Weight divided by the return value of calculateVolume()
	 */
	public double calculateDensity(double vol) {
		if (Weight == 0 || vol == 0) {
			out.println("\nError: Divided by 0.\n");
			return 0;
		} else {
			return Weight / vol;
		}//end if-else
	}
	
	/**
	 * @param args
	 * Creates Box objects and calculates the density, volume
	 * then outputs it.
	 */
	//--------------------------------------------------------------
	// MAIN
	//--------------------------------------------------------------
	public static void main(String[] args) {
		
		out.println("\n\nWelcome to the box program.\n-------------------------\n");
		Box theBox = new Box(10, 5, 5, 2600);
		out.println("Volume:\t\t" + theBox.calculateVolume());
		//outputs density by passing the returned double value from .calculateVolume
		out.println("Density:\t" + (theBox.calculateDensity(theBox.calculateVolume())) + "\n");
		
	}//end main
	
}//end class
