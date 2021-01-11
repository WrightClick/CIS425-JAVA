/**
 * Author: Matt Wright
 * Purpose: Extends the Student class, providing for a list of exams and their respective grades.
 *          Allows for getting and adding a grade to an array of exam grades as int.
 */
package edu.buffalostate.cis425.fa19.assignments.wright;

import java.util.Arrays;

public class CIS425_Student extends Student {

    /**
     * The following is available from inheritance:
     * Methods:             getName(), setName(), getID(), setID()
     * Instance vars:       name, id
     */

    private int numExams;
    private int exams[];

    public CIS425_Student (String id, String name, int numExams) {
        super(id, name);
        this.numExams = numExams;
        this.exams = new int[numExams];
        Arrays.fill(this.exams, 0);
    }

    /**
     * @param exam The exam number (1, 2, 3...). -1 to assign to proper array element
     * @param grade The integer grade to store in the array element
     * @return true if array element specified was in range and grade was saved successfully.
     *         false if the student does not have the exam available and alert user.
     */
    public boolean addGrade (int exam, int grade) {
        try {
            this.exams[exam - 1] = grade;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The student " + this.getName() + " does not have exam " + exam + " available!");
            return false;
        }
    }

    /**
     * @param exam Is decremented to access array element associated with exam number
     * @return The value at exam index or if the exam is out of bounds return -1.
     */
    public int getGrade (int exam) {
        while (true) {
            try {
                return this.exams[exam - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Invalid exam number! Returning -1.");
                return -1;
            }
        }
    }
    
    public void setNumExams(int numExams) {
        this.numExams = numExams;
    }


}
