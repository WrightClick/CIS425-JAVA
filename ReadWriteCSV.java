/**
 * This class will process an CSV-format input file
 * @methods processInFile($infile), displayTable(), writeOutfile()
 */
package edu.buffalostate.cis425.fa19.assignments.wright;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReadWriteCSV {

    //Array to store record numbers and their fields
    private String recordArray[][] = new String[12][3];

    /**
     * @param path is a string to a filepath
     * @throws IOException if there was an error loading or reading the file
     * @return
     */
    public boolean processInfile(String path) throws IOException {
        try (BufferedReader input = new BufferedReader(new FileReader(path))) {

            String record = input.readLine();

            //Reads each line and assigns the field values to an array based off of the delimiter
            //then stores the fields in the second dimension of a two dimensional array of records so that
            //each record / line can be linked to the individual fields. Then the next line is read.
            int row = 0;
            while (record != null) {
                String fields[] = record.split(",");
                for (int i = 0; i < 3; i++) {
                    recordArray[row][i] = fields[i];
                }
                record = input.readLine();
                row++;
            }

            //Looks to catch FileNotFound and IOException and alert the user returning false
        } catch (FileNotFoundException e) {
            System.out.println("The file at the path provided was not found!\n" + e.toString());
            return false;
        } catch (IOException e) {
            System.out.println("IO Exception occurred!\n" + e.toString());
            return false;
        }


        //Returns true if the file was processed successfully
        return true;
    }


    /**
     * Prints out a header for the table, then loops through the array of records using foreach and prints
     * each record to the table
     */
    public void displayTable() {

        //Prints out the header for the table
        System.out.println("------------------------------------------");
        System.out.println("| No \t|\t Month name \t|\t Days");
        System.out.println("------------------------------------------");

        //Loops through the array of records and prints it in a table format
        int row = 0;
        for (String arr[] : recordArray) {
            System.out.printf("|\t%-4s|\t%-16s|\t  %-7s|\n", recordArray[row][0], recordArray[row][1], recordArray[row][2]);
            row++;
        }

        System.out.println("------------------------------------------");

    }

    /**
     * @param path The filepath the user wants the reversed file to be written to, will be automatically created with
     *             try block
     * @return false if an exception occurred, otherwise returns true at the end of function signaling that the
     *              operation to create the file was successful.
     * -----------------------------------------------------------------------------------------------------------------
     * NOTE: This function relies on creation of a FileWriter with path given as a path to write the file to. FileWriter(path)
     *              will automatically create a file as well as automatically overwrite the file at the path given. Do make
     *              sure that if you have a file named 'cis425_ior.txt' in the src/ directory and do not want to overwrite the
     *              contents, backup your copy of the file to a different directory.
     *
     */
    public boolean writeOutfile(String path) {
        try (PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(path)))){

            //Creates a local copy of the record array and reverses the array in a list form
            String reversedArr[][] = this.recordArray;
            Collections.reverse(Arrays.asList(reversedArr));

            //Loops through the array of records and prints out each to the file in CSV format
            //checking if the file exists
            int row = 0;
            for (String arr[] : this.recordArray) {
                write.println(reversedArr[row][0] + "," + reversedArr[row][1] + "," + reversedArr[row][2]);
                row++;
            }

        } catch (IOException e) {
            System.out.println("IO Exception occurred!\t" + e.toString());
            return false;
        }

        return true;
    }

    /**
     * @param args
     * @throws IOException if a method call throws the exception
     * 1. Creates a new ReadWriteCSV object
     * 2. Processes the file. If it fails, alert the user and exit main.
     *      2a. If the processing is successful (true), call displayTable().
     *      2b. Open and create new Scanner object using System.in.
     *      2c. Warn the user of the impending write operation
     *      2d. Loop until choice == 'n' || 'y', ignore case. Ignore all other input.
     *          2d1. If 'y', write file and exit function.
     *          2d2. If 'n' skip writing and exit function.
     */
    public static void main(String[] args) throws IOException {

        //Declares a new ReadWriteCSV object named months
        ReadWriteCSV months = new ReadWriteCSV();

        //Processes the file located at the path, and then calls the method to display the private instance array
        if (months.processInfile("src/cis425_io.txt")) {
            months.displayTable();
            String choice;
            Scanner sc = new Scanner(System.in);
                System.out.print("\nWarning: The function to write the reversed file will create as well as automatically" +
                        " overwrite the contents of any file \nnamed the same as the string passed to months.writeOutfile(path)" +
                        ". Make sure if you have an existing file in the directory \nby the same file name that you backup a local" +
                        "copy.\n\nIf the file already exists choose 'n' or 'N'.\n\nContinue?: (y) (n) -- \t");

                //Loops, asking the user for a choice of whether to write the file. If the choice is 'y' or 'n'
                //case insensitive, it calls the output write function and exits, or if 'n', it alerts the user
                //that the writing was skipped and exits.
                while (true) {
                    choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("n")) {
                        System.out.println("Exiting and disregarding write!");
                        System.exit(0);
                    } else if (choice.equalsIgnoreCase("y")) {
                        Boolean written = months.writeOutfile("src/cis425_ior.txt");
                        if (written) {
                            System.out.println("File written successfully!");
                            System.exit(0);
                        }
                    } else System.out.print("Please enter either 'n' or 'y', case insensitive:\t");
                }

                //Prompts the user when original file could not be found or an IO error occurred
        } else System.out.println("The table could not be printed from the processed file!\n");

    }


}
