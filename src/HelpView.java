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
                + "\nII.");
        add(label);
        label.setBackground(Color.YELLOW);
        setBackground(Color.YELLOW);
    }

}
