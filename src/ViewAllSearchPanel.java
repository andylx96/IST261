
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
 * @author zabuz
 */
public class ViewAllSearchPanel extends JPanel {
    
    JButton searchButton;
    JLabel usernameLabel, passwordLabel, sourceLabel, label;
    JTextArea usernameField, passwordField, sourceField;
    public ViewAllSearchPanel(){
    searchButton = new JButton("Search");
        usernameField = new JTextArea("");
        passwordField = new JTextArea("");
        sourceField = new JTextArea("");
        usernameLabel= new JLabel("Username");
       passwordLabel  = new JLabel("Password");
       sourceLabel  = new JLabel("Source");
       label = new JLabel("Please Enter The Fields You Want To Search By\nLeave Blank If Unsure");
       
       setLayout(new GridLayout(1,10));
     
       add(label);
       add(usernameLabel);
       add(usernameField);
       add(passwordLabel);
       add(passwordField);
       add(sourceLabel);
       add(sourceField);
       add(searchButton);
    }
    
    
    public void addSearchButtonListener(ActionListener al) {
        this.searchButton.addActionListener(al);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getSourceLabel() {
        return sourceLabel;
    }

    public void setSourceLabel(JLabel sourceLabel) {
        this.sourceLabel = sourceLabel;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextArea getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextArea usernameField) {
        this.usernameField = usernameField;
    }

    public JTextArea getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JTextArea passwordField) {
        this.passwordField = passwordField;
    }

    public JTextArea getSourceField() {
        return sourceField;
    }

    public void setSourceField(JTextArea sourceField) {
        this.sourceField = sourceField;
    }
    
}
