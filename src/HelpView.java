/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class HelpView extends JPanel {

    JTextArea label;

    public HelpView() {
        label = new JTextArea("I. Create New Accounts "
                + "\n   This section allows the user to create accounts to match with their source"
                + "\n   i. user has the option to generate a random username of 10 characters composed of letters and numbers"
                + "\n   ii. user has the option to generate a random password of 10 characters and these options include"
                + "\n       a. lower case letters"
                + "\n       b. upper case letters"
                + "\n       c. numbers"
                + "\n       d. special characters"
                + "\nII. View All"
                + "\n   This section is where the user can see all their stored usernames and passwords."
                + "\n   The user can also make edits to their account information by double clicking on the desire text field"
                + "\n   After making changes, be sure to press enter to confirm changes and then pressing the 'Save Edits' button"
                + "\n   The user is also allowed to delete existing creditials by highlightning the row they want to delete"
                + "\n   Then pressing the 'delete' Button"
                + "\nIII. Save Accounts"
                + "\n   This section is the most important section."
                + "\n   The user should click on this button after saving all changes or creating accounts"
                + "\n   Because if the user were to exit the program, any unsaved changes will be discarded.");
        add(label);
        label.setBackground(Color.YELLOW);
        setBackground(Color.YELLOW);
    }

}
