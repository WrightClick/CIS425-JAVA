/**
 *
 * @author Matthew Wright
 * Purpose: Exercise 7 - Cube
 * Goal: Generate Cube objects using input from keyboard, print the length, surface area and volume.
 * Notes:   - The program has been heavily modified from the original exercise code.
 *          - setLength() both validates and sets values.
 */
package edu.buffalostate.cis425.fa19.exercises.wright;
import java.util.*;
import static java.lang.System.*;
public class Cube {

    // Instance variables
    private int sideLength;

    // Default constructor
    public Cube() {
        this.sideLength = 0;
    }

    // Please see setLength() for the validation
    public int getLength() {
        return this.sideLength;
    }

    /**double
     * A while(true) loop will continue testing user input in a loop
     * that 'try-catches' parsing integers from the input, and checking if it is
     * greater than 0 using 'if'. If the input is valid numeric and > 0, the 'if'
     * statement breaks through the while(true) loop since this.sideLength has been
     * assigned a valid number.
     */
    public void setLength(){
        out.print("Please enter a number greater than 0:\t");
        while (true) {
            try {
                this.sideLength = Integer.parseInt(sc.next());
                if (this.sideLength > 0) {
                    break;
                } else {
                    out.print("Please re-enter a number greater than 0!:\t");
                }// End if else
                } catch (NumberFormatException e) {
                    out.print("Please enter a number (not a letter) greater than 0!:\t");
                    //this.sideLength = 0;
                }// End try catch
        }// End running while loop
    }

    // Calculates the surface area using sideLength
    public double calculateSurfaceArea() {
        return 6 * Math.pow(this.sideLength, 2);
    }

    // Calculates the volume using sideLength
    public double calculateVolume() {
        return Math.pow(this.sideLength, 3);
    }

    // Opens a new scanner object primarily used in .setLength()
    static Scanner sc = new Scanner(System.in);


    /**
     * @param args
     * Creates three Cube objects, one initialized with a sideLength value.
     * Prints the values for the first object, then calls .setLength() for the other two
     * which will prompt the user to enter a value for sideLength checking for invalid entry
     * with exception catching. Prints object values if the entry is valid.
     */
    public static void main(String args[]) {

        // Creates three Cube objects, one initialized with a value for sideLength
        Cube cube1 = new Cube();
        Cube cube2 = new Cube();
        Cube cube3 = new Cube();

        // Prints the values for the first cube
        cube1.setLength();
        out.println("\nSide length of cube1 is:\t" + cube1.getLength());
        out.println("Surface Area of cube1 is:\t" + cube1.calculateSurfaceArea());
        out.println("Volume of cube1 is:\t\t\t" + 	cube1.calculateVolume() + "\n");

        // Prompts the user to enter the sideLength() value for the cube then prints the
        // values and calculations
        cube2.setLength();
        out.println("\nSide length of cube2 is:\t" + cube2.getLength());
        out.println("Surface Area of cube2 is:\t" + cube2.calculateSurfaceArea());
        out.println("Volume of cube2 is:\t\t\t" + 	cube2.calculateVolume() + "\n");

        // Prompts the user to enter the sideLength() value for the cube then prints the
        // values and calculations
        cube3.setLength();
        out.println("\nSide length of cube3 is:\t" + cube3.getLength());
        out.println("Surface Area of cube3 is:\t" + cube3.calculateSurfaceArea());
        out.println("Volume of cube3 is:\t\t\t" + 	cube3.calculateVolume());

        sc.close();
    } // main()

} // Cube
