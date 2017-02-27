
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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

    CreateView() {
        setLayout(new GridLayout(10, 1));
        userName = new JTextArea("Enter Username");
        password = new JTextArea("Enter Password");
        source = new JTextArea("Enter Source");
        lower = new JCheckBox("Lower Case");
        upper = new JCheckBox("Upper Case");
        number = new JCheckBox("Numbers");
        special = new JCheckBox("Special Characters");
        genRandPass = new JButton("Generate Random Password");
        genRandUser = new JButton("Generate Random Username");
        createAccount = new JButton("Create Account");

        add(userName);
        add(password);
        add(source);
        add(lower);
        add(upper);
        add(number);
        add(special);
        add(genRandUser);
        add(genRandPass);
        add(createAccount);

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

}
