/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;

/**
 *
 * @author ajl5735
 */
public class HelpFrame extends JFrame {
   HelpModel model;
    HelpPanel panel;
    
    public HelpFrame(HelpModel model){
    super("Help");
    this.model = model;
    
       setSize(700, 500);
        panel = new HelpPanel();
        setLocationRelativeTo(null);
        add(panel);
    
    }

    public HelpPanel getPanel() {
        return panel;
    }

    public void setPanel(HelpPanel panel) {
        this.panel = panel;
    }
        public void switchToContacts(HelpView contact_view) {
   panel.removeContactView();
   panel.addContactView(contact_view);
    }
}
