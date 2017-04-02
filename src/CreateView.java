
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreateView extends JPanel {

    JTextArea userName, password, source;
    JButton genRandPass, createAccount, genRandUser;
    JCheckBox lower, upper, number, special;
    JLabel usernameLabel, passwordLabel, sourceLabel, instruLabel;
    GridBagConstraints gbc = new GridBagConstraints();

    CreateView() {
        
        setLayout(new GridBagLayout());
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        sourceLabel = new JLabel("Source");
        instruLabel = new JLabel("Please Select Password Requirements");
        userName = new JTextArea("Enter Username");
        password = new JTextArea("Enter Password");
        source = new JTextArea("Enter Source");
        lower = new JCheckBox("Lower Case");
        lower.setSelected(true);
        upper = new JCheckBox("Upper Case");
        upper.setSelected(true);
        number = new JCheckBox("Numbers");
        number.setSelected(true);
        special = new JCheckBox("Special Characters");
        special.setSelected(true);
        genRandPass = new JButton("Generate Random Password");
        genRandUser = new JButton("Generate Random Username");
        createAccount = new JButton("Create Account");
        usernameLabel.setForeground(Color.BLUE);
        passwordLabel.setForeground(Color.BLUE);
        sourceLabel.setForeground(Color.BLUE);
        instruLabel.setForeground(Color.red);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1,1,1,1);

        gbc.weighty = 0.0;
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(usernameLabel, gbc);
        
        gbc.weightx = 1.0;
        gbc.gridx = 1;
        add(userName, gbc);
        
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(passwordLabel,gbc);
        
        gbc.weightx = 1.0;
        gbc.gridx = 1;
        add(password, gbc);
        
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(sourceLabel,gbc);
        
        gbc.weightx = 1.0;
        gbc.gridx = 1;
        add(source, gbc);
        
        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(instruLabel,gbc);
        
        gbc.gridy = 1;
        add(lower, gbc);
        
        gbc.gridx = 1;
        add(upper, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(number, gbc);
        
        gbc.gridx = 1;
        add(special, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(genRandUser,gbc);
        
        gbc.gridy = 4;
        add(genRandPass,gbc);

        gbc.gridy = 8;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        add(createAccount,gbc);

    }

    public JButton getGenRandPass() {
        return genRandPass;
    }

    public void setGenRandPass(JButton genRandPass) {
        this.genRandPass = genRandPass;
    }
    
    public JButton getGenRandUser(){
        return genRandUser;
    }
    
    public void setGenRandUser(JButton genRandUser){
        this.genRandUser = genRandUser;
    }

    public JCheckBox getLower() {
        return lower;
    }

    public void setLower(JCheckBox lower) {
        this.lower = lower;
    }

    public JCheckBox getUpper() {
        return upper;
    }

    public void setUpper(JCheckBox upper) {
        this.upper = upper;
    }

    public JCheckBox getNumber() {
        return number;
    }

    public void setNumber(JCheckBox number) {
        this.number = number;
    }

    public JCheckBox getSpecial() {
        return special;
    }

    public void setSpecial(JCheckBox special) {
        this.special = special;
    }

    public void addCreateAccountListener(ActionListener al) {
        this.createAccount.addActionListener(al);
    }

    public void addgenRandPassAccountListener(ActionListener al) {
        this.genRandPass.addActionListener(al);
    }
    
    public void addgenRandUserAccountListener(ActionListener al) {
        this.genRandUser.addActionListener(al);
    }

    public JTextArea getUserName() {
        return userName;
    }

    public void setUserName(JTextArea userName) {
        this.userName = userName;
    }

    public JTextArea getPassword() {
        return password;
    }

    public void setPassword(JTextArea password) {
        this.password = password;
    }

    public JTextArea getSource() {
        return source;
    }

    public void setSource(JTextArea source) {
        this.source = source;
    }

    public JButton getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(JButton createAccount) {
        this.createAccount = createAccount;
    }

    public JLabel getInstruLabel() {
        return instruLabel;
    }

    public void setInstruLabel(JLabel instruLabel) {
        this.instruLabel = instruLabel;
    }

}
