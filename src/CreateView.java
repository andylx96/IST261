
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
    JButton genRandPass, createAccount;
    JCheckBox a,b,c,d;

    CreateView() {
        setLayout(new GridLayout(10, 1));
        userName = new JTextArea("Enter Username");
        password = new JTextArea("Enter Password");
        source = new JTextArea("Enter Source");
        a = new JCheckBox ("Lower Case");
        b = new JCheckBox ("Upper Case");
        c = new JCheckBox ("Numbers");
        d = new JCheckBox ("Special Characters");
        genRandPass = new JButton("Generate Random Password");
        createAccount = new JButton("Create Account");

        add(userName);
        add(password);
        add(source);
        add(a);
        add(b);
        add(c);
        add(d);
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
    
    public JCheckBox lower() {
        return a;
    }
    
    public JCheckBox upper() {
        return b;
    }
    
    public JCheckBox numbers() {
        return c;
    }
    
    public JCheckBox special() {
        return d;
    }
}
