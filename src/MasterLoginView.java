
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class MasterLoginView extends JPanel {
    JTextArea userName, password;
    JButton loginButton;
    MasterLoginView(){
    setLayout(new GridLayout(10,1));
        userName = new JTextArea("UserName");
    password = new JTextArea("Password");
    loginButton = new JButton("Login");
    
    add(userName);
    add(password);
    add(loginButton);
    
    
    }
    
    public void addMasterLoginListener(ActionListener al) {
        this.loginButton.addActionListener(al);
    }
    
    
    
    
}
