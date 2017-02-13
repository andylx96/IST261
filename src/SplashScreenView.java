
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashScreenView extends JPanel {

    JLabel splashButton;
    JLabel optionsLabel;
    JButton welcome;
    JLabel description;
   
    SplashScreenView() {
        setLayout(new BorderLayout());
        splashButton = new JLabel(new ImageIcon("src/Images/key.png"));
        welcome = new JButton("Welcome");
        description = new JLabel("Welcome");
        
        
        add(welcome, BorderLayout.NORTH);
        add(splashButton, BorderLayout.CENTER);
        add(description, BorderLayout.SOUTH);
        setSize(900, 700);
        
    }
    
    

}
