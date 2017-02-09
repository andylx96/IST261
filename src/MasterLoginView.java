
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasterLoginView extends JPanel {

    JLabel splashButton;
    JLabel optionsLabel;
    JButton welcomeButton;
    JLabel hint;
    JButton loginButton;

    MasterLoginView() {
        setLayout(new BorderLayout());
        splashButton = new JLabel(new ImageIcon("src/Images/key.png"));
        welcomeButton = new JButton("Welcome");
        hint = new JLabel("Welcome");
        loginButton = new JButton("Login");
        
        
        add(welcomeButton, BorderLayout.NORTH);
        add(splashButton, BorderLayout.CENTER);
        add(hint, BorderLayout.SOUTH);
        setSize(900, 700);
        
        add(loginButton);
    }
    
       
    public void addLoginAccountListener(ActionListener al) {
        this.loginButton.addActionListener(al);
    }
    

}
