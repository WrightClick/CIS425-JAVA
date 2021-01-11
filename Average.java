package edu.buffalostate.cis425.fa19.exercises.wright;
import java.util.Scanner;

/**
 * @author Matt Wright 
 * Class: CIS425
 * Exercise: One (Average.java)
 * Goal: Fill in the blanks following desiered program functions
 */

import java.util.Scanner;

public class Average {
	
  public static void main( String args[] ) {
	  
	//Initializes some vars for use in the program
    double ave = 0.0, num = 0.0, sum = 0.0;
    int cnt = 0;
    
    //Creates a scanner object for reading input and prompts / welcomes the user
    Scanner sc = new Scanner(System.in);
    System.out.println( "\nInteger Averaging Program\n--------------------" ); 
    System.out.println( "Enter 10 Integers\n--------------------" );
    System.out.println("Enter '9999' to exit\n--------------------\n");
    
    for (int i = 1; i <= 10; i++) {
      System.out.print("Enter Integer " + i + ": ");
      
      // check if the user entered a non-integer
      if (!sc.hasNextInt()) {
        // System.err will print the message in RED, skip the line and decrement the count
        System.err.println("Sorry, please enter an integer");
        sc.nextLine();
        i--;
        continue;
      }
      
      //Reads the next int and either breaks or increments cnt and adds to the sum
      num = sc.nextInt();
      if (num == 9999) {
        break;
      }
      cnt++; 
      sum = sum + num;
   }
    
    //Checks to see if the program was term'd with numbers entered or not
   if (cnt >= 1) {
     ave = sum / cnt;
   } else {
     ave = 0;
   }
   
   sc.close();
   //Final output of the averaged numbers
   System.out.println("\nThe average of the " + cnt + " numbers is " + ave );
   
 }//end main
  
}
