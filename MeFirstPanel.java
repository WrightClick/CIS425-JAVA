package edu.buffalostate.cis425.fa19.exercises.wright;
import javax.swing.*;
import java.awt.event.*;

/**
 * Author: Matthew Wright (Modification of previous program)
 *
 */
public class MeFirstPanel extends JPanel implements ActionListener {

    //Three buttons
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;

    //The three text labels for the buttons
    String aText = "first";
    String bText = "second";
    String cText = "third";

    String tempText; // To exchange labels
    String tempText2; //To exchange labels

    /**
     * Creates three buttons, with text and adds to the pane
     */
    public MeFirstPanel() {

        //Create three new buttons with the text provided, and add event handles
        aButton = new JButton(aText);
        aButton.addActionListener(this);
        bButton = new JButton(bText);
        bButton.addActionListener(this);
        cButton = new JButton(cText);
        cButton.addActionListener(this);

        add(aButton);
        add(bButton);
        add(cButton);
    } // End MeFirstPanel()

    /**
     * actionPerformed
     * @param e button clicked
     */
    public void actionPerformed(ActionEvent e) {

        //Exchanges the text values with the button text to the right
        tempText = aText;
        aText = cText;
        tempText2 = bText;
        bText = tempText;
        cText = tempText2;

        //Set the text for the buttons after exchanging
        aButton.setText(aText);
        bButton.setText(bText);
        cButton.setText(cText);

    } // End actionPerformed()
} // End MeFirstPanel class