
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MasterLoginView extends JPanel {

    JTextArea userName;
    JPasswordField password;
    JButton loginButton, signup;
    JLabel loginStatus, usernameLabel, passwordLabel, userHint;

    GridBagConstraints gbc = new GridBagConstraints();
    MasterLoginView() {
        
        signup = new JButton("SignUp");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userHint = new JLabel("Please Enter Your Username and Password for the Application\nThis is your master password");
        
        setLayout(new GridBagLayout());
        userName = new JTextArea("UserName");
        password = new JPasswordField("Password");
        loginButton = new JButton("Login");
        loginStatus = new JLabel("Not Logged In", SwingConstants.CENTER);
        
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);
        
        setBackground(Color.WHITE);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
userName.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
password.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
      gbc.anchor = GridBagConstraints.LAST_LINE_END;  
        gbc.insets = new Insets(1,1,1,1);
      
//        gbc.ipady = 20;
        gbc.weighty = 0.0;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
     //   add(userHint, gbc);
        
        gbc.weighty = 0.0;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(usernameLabel, gbc);
        
        gbc.weightx = 1.0;
        gbc.gridx = 1;
        add(userName, gbc);
        
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel,gbc);
     
        gbc.weightx = 1.0;
        gbc.gridx = 1;
        add(password, gbc);
        
        gbc.weightx = 0.0;
                
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(loginButton, gbc);
        gbc.gridy = 2;
        add(signup, gbc);
        
        
        
        gbc.ipady = 40;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        add(loginStatus, gbc);
        
        


    }

    public JButton getSignup() {
        return signup;
    }

    public void setSignup(JButton signup) {
        this.signup = signup;
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
