/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ajl5735
 */
public class HelpView extends JPanel {

    JLabel label;

    public HelpView() {
        label = new JLabel("Help Stuff");
        add(label);
    }

}
