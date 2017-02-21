
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
public class CreateMasterLoginView extends JPanel {

    JTextArea userName; 
    JTextArea password;
    
    JButton createButton;
    JLabel createStatus;

    CreateMasterLoginView() {
        setLayout(new GridLayout(10, 1));
        userName = new JTextArea("UserName");
        password = new JTextArea("Password");
        createButton = new JButton("Create Account");
        createStatus = new JLabel("Account Not Created");

        add(userName);
        add(password);
        add(createButton);
        add(createStatus);

    }

    public JTextArea getUserName() {
        return userName;
    }

    public void setUserName(JTextArea userName) {
        this.userName = userName;
    }

   
    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JLabel getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(JLabel createStatus) {
        this.createStatus = createStatus;
    }

    public JTextArea getPassword() {
        return password;
    }

    public void setPassword(JTextArea password) {
        this.password = password;
    }

    

    
   
    public void addCreateMasterLoginListener(ActionListener al) {
        this.createButton.addActionListener(al);
    }

}
