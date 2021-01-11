package edu.buffalostate.cis425.fa19.exercises.wright;
import javax.swing.*;

/**
 * Author: Matthew Wright (Modification of previous program)
 */
public class MeFirstApp extends JFrame {

    private static final long serialVersionUID = 1L;

    public MeFirstApp() {
        setSize(400,100);
        getContentPane().add(new MeFirstPanel());
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    } // End MeFirstApp

    public static void main(String args[]) {
        MeFirstApp b = new MeFirstApp();
        b.setVisible(true);
    } // End main()

} // End MeFirstApp class
