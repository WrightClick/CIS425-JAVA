/**
 * Author: Matt Wright
 * Purpose:
 */
package edu.buffalostate.cis425.fa19.assignments.wright;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CIS425_Course {

    private CIS425_Student roster[];
    private int capacity;
    private int numEnrolled;

    /**
     * @param capacity The capacity of the array, maximum students.
     */
    public CIS425_Course (int capacity) {
        this.roster = new CIS425_Student[capacity];
        this.capacity = capacity;
        this.numEnrolled = 0;
    }

    /**
     * @param id Student ID, used in findStudent(String id)
     * @param name Student name, used in obj.getName();
     * @param numExams Number of exams for student, used here
     * @return
     */
    public boolean addStudent (String id, String name, int numExams) {

        //Check if the number of enrolled students is the size of the roster capacity
        if (this.numEnrolled == this.roster.length) {
            System.out.println("Cannot add " + name + " to course, course is at capacity!");
            return false;
        } else {
            //Create student, add into roster array and return
            CIS425_Student student = new CIS425_Student(id, name, numExams);
            this.roster[this.numEnrolled] = student;
            this.numEnrolled++;
            return true;
        }
    }

    /**
     * @param id Used to search the array of CIS425_Student objects for a match.
     * @return Object if found, otherwise return null
     */
    public CIS425_Student findStudent(String id) {
        for (int i = 0; i < roster.length; i++) {
            if (roster[i].getID().equalsIgnoreCase(id)) {
                return roster[i];
            }
        }
        System.out.println("Student could not be found by the provided ID! Returning null.");
        return null;
    }


    /**
     * @param exam The exam number to serve as an index to the array of exams
     * @return The average of all grades that are not 0.
     */
    public double computeAverage (int exam) {
        double avg = 0;
        double sum = 0;
        int count = 0;
        for (int i = 0; i < this.numEnrolled; i++) {
            //Checks for divide by zero error / unassigned initialization value
            if (roster[i].getGrade(exam) == 0) {
                continue;
            } else {
                sum += roster[i].getGrade(exam);
                count++;
            }
        }
        avg = sum / count;
        return avg;
    }

    /**
     * @param args
     * @throws NullPointerException If accessing method from a null object
     */
    public static void main(String[] args) throws NullPointerException {
        try {
            CIS425_Course java = new CIS425_Course(30);

            //Add Sally Smarty and Phil Phailure to the class
            java.addStudent("B0000001", "Sally Smarty", 3);
            java.addStudent("B0000002", "Phil Phailure", 3);

            //use fineStudent to return a student object, then adding grades for each CIS425_Student object
            java.findStudent("B0000001").addGrade(1, 100);
            java.findStudent("B0000002").addGrade(1, 60);

            //Print out the name and grades for the two CIS425_Student objects using the findStudent method of the class.
            System.out.println( "\n" +
                    java.findStudent("B0000001").getName() + " has a grade of " + java.findStudent("B0000001").getGrade(1) +
                    " on exam 1.\n"
                    + java.findStudent("B0000002").getName() + " has a grade of " + java.findStudent("B0000002").getGrade(1) +
                    " on exam 1.\n"
            );

            //Outputs the computed average for the specific exam for all CIS425_Student objects
            System.out.println("Exam 1 Average:\t" + java.computeAverage(1));

        } catch (NullPointerException e) {
            System.out.println("Error: A NullPointerException was encountered.\nThis occurs when a student cant be found and" +
                    " its methods or fields are called / accessed.");
            e.printStackTrace();

        }

    }

}
