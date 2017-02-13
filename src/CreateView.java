
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreateView extends JPanel {

    JTextArea userName, password, source;
    JButton genRandPass, createAccount;

    CreateView() {
        setLayout(new GridLayout(10, 1));
        userName = new JTextArea("Enter Username");
        password = new JTextArea("Enter Password");
        source = new JTextArea("Enter Source");
        genRandPass = new JButton("Generate Random Password");
        createAccount = new JButton("Create Account");

        add(userName);
        add(password);
        add(source);
        add(genRandPass);
        add(createAccount);

    }

    public void addCreateAccountListener(ActionListener al) {
        this.createAccount.addActionListener(al);
    }

    public void addgenRandPassAccountListener(ActionListener al) {
        this.genRandPass.addActionListener(al);
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
