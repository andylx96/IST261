
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SplashScreenView extends JPanel {

    JLabel splashLabel;
    JButton welcomeButton;
    JLabel descriptionLabel;
   
    SplashScreenView() {
        setLayout(new BorderLayout());
        splashLabel = new JLabel(new ImageIcon("src/Images/key.png"));
//        welcomeButton = new JButton("Click Here For");
        descriptionLabel = new JLabel("Welcome to our Credential Manager Application.", SwingConstants.CENTER);
        
        
//        add(welcomeButton, BorderLayout.NORTH);
        add(splashLabel, BorderLayout.CENTER);
        add(descriptionLabel, BorderLayout.NORTH);
        setSize(900, 700);
        
    }

    public JLabel getSplashLabel() {
        return splashLabel;
    }

    public void setSplashLabel(JLabel splashLabel) {
        this.splashLabel = splashLabel;
    }

    public JButton getWelcomeButton() {
        return welcomeButton;
    }

    public void setWelcomeButton(JButton welcomeButton) {
        this.welcomeButton = welcomeButton;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }
    
    

}
