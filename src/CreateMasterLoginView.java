
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CreateMasterLoginView extends JPanel {

    JTextArea userName;
    JTextArea password;

    JButton createButton;
    JLabel createStatus;
    GridBagConstraints gbc = new GridBagConstraints();

    JLabel usernameLabel, passwordLabel;

    CreateMasterLoginView() {

        setLayout(new GridBagLayout());

        
        
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userName = new JTextArea("UserName");
        password = new JTextArea("Password");
        createButton = new JButton("Create Account");
        createStatus = new JLabel("This Account Will Be Used To Login To The Application", SwingConstants.CENTER);
        
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);

        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
//       
        
        gbc.weighty = 0.0;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        gbc.weightx = 0.3;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userName, gbc);

        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.weightx = 0.3;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(password, gbc);

        gbc.weightx = 0.0;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(createStatus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
         gbc.ipady = 40;
        add(createButton, gbc);

        setBackground(Color.WHITE);
                Border border = BorderFactory.createLineBorder(Color.BLACK);
userName.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
password.setBorder(BorderFactory.createCompoundBorder(border, 
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        
        
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
