/**
 * Author: Matt Wright
 * Purpose: Emulate a student that can be either sleeping (dreaming / snoring)
 *          or awake (eating / working)
 */
package edu.buffalostate.cis425.fa19.exercises.wright;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Creates a "student" that can be either sleeping or awake.
 *      Sleeping: can have substates of 2 (dreaming) or 3 (snoring).
 *      Awake: can have substates of 0 (eating) or 1 (working).
 *
 * Standard calls in main allow for setting and getting the states.
 *
 * Main Menu: A main menu is available when uncommented in which the object is able to
 *      be fully managed in all states, including halfway-states such as
 *      waking up or falling asleep instead of the concrete awake or asleep states.
 *
 *      Catches:
 */
public class CyberStudent {

    //default init value = false
    private boolean awake;
    private boolean sleeping;

    private int substate;
    private String name;

    /**
     * @param name - name for the student
     */
    public CyberStudent (String name) {
        this.name = name;
        sleeping = true;
        substate = 2;
    }

    /**
     * @return - name of CyberStudent
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return - string containing name of CyberStudent object, state and substate
     */
    public String getState() {
        String state = "";
        String substate = "";
        if (awake && !sleeping) {
            state = "awake";
        } else if (sleeping && !awake) {
            state = "sleeping";
        } else state = "INVALID";
        switch (this.substate) {
            case 0: substate = "eating"; break;
            case 1: substate = "working"; break;
            case 2: substate = "dreaming"; break;
            case 3: substate = "snoring"; break;
            case 99: state = "waking up"; return this.name + " is " + state + "\nSet a substate to fully wake up!\n";
            case -99: state = "falling asleep"; return this.name + " is " + state + "\nSet a substate to fully fall asleep!\n";
            default: state = "INVALID"; substate = "INVALID"; break;
        }
        return this.name + " is " + state + " and " + substate + ".\n";
    }

    /**
     * @param substate - substate code for the object
     * @return - true if substate was valid and set, false otherwise
     */
    public boolean Awake (int substate) {
        if (substate == 0 || substate == 1) {
            sleeping = false;
            awake = true;
            this.substate = substate;
        }   else {
            switch (substate) {
                case 2:
                    System.out.println(this.name + " cannot be awake and dreaming.");
                    return false;
                case 3:
                    System.out.println(this.name + " cannot be awake and snoring.");
                    return false;
                default: return false;
            }
        }
        return true;
    }

    /**
     * @param substate - substate code for the object
     * @return - true if substate was valid and set, false otherwise
     */
    public boolean Sleeping (int substate) {
        if (substate == 2 || substate == 3) {
            sleeping = true;
            awake = false;
            this.substate = substate;
        }   else {
            switch (substate) {
                case 0:
                    System.out.println(this.name + " cannot be sleeping and eating.");
                    return false;
                case 1:
                    System.out.println(this.name + " cannot be sleeping and working.");
                    return false;
                default: return false;
            }
        }
        return true;
    }

    /**
     * A temporary state of Awake() without a valid substate (0,1,2,3)
     * value for substate -> 99
     */
    public void wakeUp() {
        if (!awake && sleeping) {
            awake = true;
            sleeping = false;
            substate = 99;
        } else if (substate == 99) {
            System.out.println("\n" + this.name + " is already waking.");
            System.out.println("Set a substate to fully wake up!");
        } else System.out.println("\n" + this.name + " is already awake.");

    }

    /**
     * A temporary state of Sleeping() without a valid substate (0,1,2,3)
     * value for substate -> -99
     */
    public void fallAsleep() {
        if (awake && !sleeping) {
            sleeping = true;
            awake = false;
            substate = -99;
        } else if (substate == -99) {
            System.out.println("\n" + this.name + " is already falling asleep.");
            System.out.println("Set a substate to fully fall asleep!");
        } else System.out.println("\n" + this.name + " is already asleep.");

    }

    /**
     * @return - true if substate was valid and set, alert user and return false if otherwise
     * Attempts to set the substate given the current state of the object
     */
    public boolean Eat () {
        if (awake && !sleeping) {
            this.substate = 0;
            return true;
        } else {
            System.out.println("\n" + this.name + " cannot eat while sleeping.");
            return false;
        }
    }

    /**
     * @return - true if substate was valid and set, alert user and return false if otherwise
     * Attempts to set the substate given the current state of the object
     */
    public boolean Work () {
        if (awake && !sleeping) {
            this.substate = 1;
            return true;
        } else {
            System.out.println("\n" + this.name + " cannot work while sleeping.");
            return false;
        }
    }

    /**
     * @return - true if substate was valid and set, alert user and return false if otherwise
     * Attempts to set the substate given the current state of the object
     */
    public boolean Dream () {
        if (sleeping && !awake) {
            this.substate = 2;
            return true;
        } else {
            System.out.println("\n" + this.name + " cannot be awake and dreaming.");
            return false;
        }
    }

    /**
     * @return - true if substate was valid and set, alert user and return false if otherwise
     * Attempts to set the substate given the current state of the object
     */
    public boolean Snore () {
        if (sleeping && !awake) {
            this.substate = 3;
            return true;
        } else {
            System.out.println("\n" + this.name + " cannot be awake and snoring.");
            return false;
        }
    }

    /**
     * @throws InputMismatchException - if a character is entered instead of an integer
     * Loops, displaying a menu for user to select actions to be applied to the object
     * that called the menu.
     *
     * Allows for full selection of states and substates, when halfway-point states such as
     * waking up and falling asleep.
     */
    public void displayMenu () throws InputMismatchException {

        _loop:
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int choice;
                System.out.println("Please select an option:\t");
                System.out.println("1. Get State");
                System.out.println("2. Change State");
                System.out.println("3. Change Substate");
                System.out.println("99. EXIT");
                System.out.print("Choice:\t");
                choice = sc.nextInt();
                System.out.print("\n");
                switch (choice) {
                    case 1:
                        System.out.println(this.getState()); break;
                    case 2:
                        System.out.println("Choose a state:\t");
                        System.out.println("1. Awake");
                        System.out.println("2. Sleeping");
                        System.out.println("99. Go Back");
                        System.out.print("Choice:\t");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1: this.wakeUp(); break;
                            case 2: this.fallAsleep(); break;
                            case 99:
                            default: break;
                        }
                        System.out.print("\n");
                        break;
                    case 3:
                        System.out.println("Choose a substate:\t");
                        System.out.println("0. eating");
                        System.out.println("1. working");
                        System.out.println("2. dreaming");
                        System.out.println("3. snoring");
                        System.out.println("99. Go Back");
                        System.out.print("Choice:\t");
                        choice = sc.nextInt();
                        switch (choice) {
                            case 0: this.Eat(); break;
                            case 1: this.Work(); break;
                            case 2: this.Dream(); break;
                            case 3: this.Snore(); break;
                            case 99:
                            default: break;
                        }
                        System.out.print("\n");
                        break;
                    case 99: System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a number!\n");
                continue;
            }
            }


    }

    public static void main(String[] args) {

        //creates a object with initial state of sleeping and dreaming
        CyberStudent sally = new CyberStudent("Sleepy Sally");

        //--------------------------------------------
        //BEGIN REGULAR ACTIONS
        System.out.println(sally.getState());
        sally.Eat();

        System.out.println("\n");
        sally.Snore();

        System.out.println(sally.getState());
        System.out.print("\n");

        sally.Awake(0);
        System.out.println(sally.getState());

        sally.Dream();

        sally.Work();
        System.out.println("\n\n" + sally.getState());

        //END REGULAR ACTIONS
        //UNCOMMENT THE .displayMenu() and .Sleeping(2) LINE(S) BELOW TO ALLOW MENU TO LAUNCH
        //--------------------------------------------

        //Sets the CyberStudent state to the state of the constructor and launches menu
        sally.Sleeping(2);
        System.out.println("\n\n\n\n");
        sally.displayMenu();

    }

}
