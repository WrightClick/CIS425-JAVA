package edu.buffalostate.cis425.fa19.exercises.wright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardReader {

    private BufferedReader reader;

    public KeyboardReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getKeyboardInput() {
        return readKeyboard();
    }

    /**
     * @return num read in if it is a number
     * @Catches NumberFormatException
     */
    public int getKeyboardInteger() {
        int num = 0;
        while (true) {
            try {
                num = Integer.parseInt(readKeyboard());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number, not a character:\t");
            }
        }
        return num;
    }

    /**
     * @param min minimum number of columns or rows
     * @param max maximum number of columns or rows
     * @return num if within range
     * @Catches NumberFormatException
     */
    // HINT: add new method that limits input in range from Min to Max
    public int getKeyboardIntegerRange(int min, int max) {
        int num = 0;
        while (true) {
            try {
                num = getKeyboardInteger();
                if (num >= min && num <= max) {
                    break;
                } else System.out.print("Please enter a number within the range!:\t");
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number!:\t");
            }
        } //end while loop

        return num;
    } //end getKeyboardIntegerRange

    public double getKeyboardDouble() {
        return Double.parseDouble(readKeyboard());
    }

    public String getUserInput() {
        return getKeyboardInput();
    }

    public void prompt(String s) {
        System.out.print(s);
    }

    public void report(String s) {
        System.out.print(s);
    }

    public void display(String s) {
        System.out.print(s);
    }

    private String readKeyboard() {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
