/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class HelpPanel extends JPanel {

    HelpView contact_view;

    public HelpPanel() {
        setLayout(new BorderLayout());
        contact_view = new HelpView();
        add(contact_view, BorderLayout.CENTER);
        
        
        
    }

    public void addContactView(HelpView contact_view) {
        this.contact_view = contact_view;
        add(contact_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeContactView() {
        if (this.contact_view != null) {
            this.remove(contact_view);
        }
    }
}
