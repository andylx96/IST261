
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavViewBottomMenuPanel extends JPanel{

    JButton mainButton;
    JButton optionsButton;
    JButton instructionsButton;
    JButton creditsButton;
    JButton highScoreButton;
    
    public NavViewBottomMenuPanel() {
        super();
        mainButton = new JButton("Create Account");
        optionsButton = new JButton("n/a");
        instructionsButton = new JButton("n/a");
        creditsButton = new JButton("n/a");
        highScoreButton = new JButton("n/a");

        
        
        add(mainButton);
        add(optionsButton);
        add(instructionsButton);
        add(highScoreButton);
        add(creditsButton);

    }
}
