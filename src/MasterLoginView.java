
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
public class MasterLoginView extends JPanel {

    JTextArea userName; 
    JPasswordField password;
    JButton loginButton;
    JLabel loginStatus;

    MasterLoginView() {
        setLayout(new GridLayout(10, 1));
        userName = new JTextArea("UserName");
        password = new JPasswordField("Password");
        loginButton = new JButton("Login");
        loginStatus = new JLabel("Not Logged In");

        add(userName);
        add(password);
        add(loginButton);
        add(loginStatus);

    }

    public JTextArea getUserName() {
        return userName;
    }

    public void setUserName(JTextArea userName) {
        this.userName = userName;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JLabel getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(JLabel loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void addMasterLoginListener(ActionListener al) {
        this.loginButton.addActionListener(al);
    }

}
