
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ajl5735
 */
public class InstructionView extends JPanel {

    JTextArea textArea, menu;
    JButton clickHere;

    public InstructionView() {
        setLayout(new BorderLayout(10, 1));
        textArea = new JTextArea("You Have Sucessfully Logged In\n Please Choice And Option Below");
        menu = new JTextArea("1. Create Account\n   Create a New Account to store into your library."
                + "\n2 .ViewAll\n   To View, Search, Edit, and Deleted Saved Accounts in your library"
                + "\n3 . Save\n  You Must Press This Button before Exiting, \n   Otherwise all progress will be deleted\n\n\n\n"
                + "Remeber, YOU MUST SAVE before exiting the program!"
                + "\n   Or you WILL LOSE all your changes!");
        clickHere = new JButton("Need More Help? Click Here");
        textArea.setBackground(Color.green);
        menu.setBackground(Color.YELLOW);

        add(textArea, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
        add(clickHere, BorderLayout.SOUTH);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JTextArea getMenu() {
        return menu;
    }

    public void setMenu(JTextArea menu) {
        this.menu = menu;
    }

    public JButton getClickHere() {
        return clickHere;
    }

    public void setClickHere(JButton clickHere) {
        this.clickHere = clickHere;
    }

}
