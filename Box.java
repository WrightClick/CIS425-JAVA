/**
 * Author: Matt Wright
 * Purpose: Read a min and max range from the user keyboard and use it to
 *  draw a box with asterisks given the dimensions
 */
package edu.buffalostate.cis425.fa19.exercises.wright;

import java.io.*;
public class Box {

    /**
     * @param row number of rows to print
     * @param col number of columns to print
     */
    public static void drawBox (int row, int col) {
        for (int k = 0; k < row; k++) {
            for (int j = 0;j < col; j++)
                System.out.print('*');
            System.out.println();
        }
    }

    /**
     * @param args
     * @throws IOException
     * Reads in a minimum and a maximum from getKeyboardInteger() then gets the number of rows and columns
     *  to print using getKeyboardIntegerRange() provided the minimum and maximum.
     */
    public static void main(String args[]) throws IOException {

        KeyboardReader input = new KeyboardReader();

        //Assigns values to the minimum and maximum range for the box
        System.out.print("Enter the minimum range:\t");
        int min = input.getKeyboardInteger();
        System.out.print("Enter the maximum range:\t");
        int max = input.getKeyboardInteger();

        //Prompts the user to enter a number within the range provided
        System.out.print("Enter the number of rows you want in your box: ");
        int nRows = input.getKeyboardIntegerRange(min, max);

        //Prompts the user to enter a number within the range provided
        System.out.print("Enter the number of columns you want in your box: ");
        int nColumns =  input.getKeyboardIntegerRange(min, max);

        System.out.println("\nThis is what your box looks like\n");
        Box.drawBox(nRows, nColumns);

    }

}
