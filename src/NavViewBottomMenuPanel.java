
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavViewBottomMenuPanel extends JPanel {
    
    JButton mainButton;
    JButton optionsButton;
    JButton instructionsButton;
    JButton creditsButton;
    JButton highScoreButton;
    
    public NavViewBottomMenuPanel() {
        super();
        
        optionsButton = new JButton("LOGIN");
        mainButton = new JButton("Create Account");
        instructionsButton = new JButton("Delete Account");
        creditsButton = new JButton("Search Account");
        highScoreButton = new JButton("View All");
        
        mainButton.setVisible(false);
        instructionsButton.setVisible(false);
        highScoreButton.setVisible(false);
        creditsButton.setVisible(false);
        
        add(optionsButton);
        add(mainButton);
        add(instructionsButton);
        add(highScoreButton);
        add(creditsButton);
        
    }

    public JButton getMainButton() {
        return mainButton;
    }

    public void setMainButton(JButton mainButton) {
        this.mainButton = mainButton;
    }

    public JButton getOptionsButton() {
        return optionsButton;
    }

    public void setOptionsButton(JButton optionsButton) {
        this.optionsButton = optionsButton;
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    public void setInstructionsButton(JButton instructionsButton) {
        this.instructionsButton = instructionsButton;
    }

    public JButton getCreditsButton() {
        return creditsButton;
    }

    public void setCreditsButton(JButton creditsButton) {
        this.creditsButton = creditsButton;
    }

    public JButton getHighScoreButton() {
        return highScoreButton;
    }

    public void setHighScoreButton(JButton highScoreButton) {
        this.highScoreButton = highScoreButton;
    }
}
