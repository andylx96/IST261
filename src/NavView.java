
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class NavView extends JFrame {

    NavModel model;
    NavViewPanel nVpanel;

    NavView(NavModel model) {
        super("Welcome to TRIvia Home Page");
        this.model = model;

        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nVpanel = new NavViewPanel();

        add(nVpanel);
    }

    public void switchToMainPanel(CreateView m_view) {
        nVpanel.removeSplash();
        nVpanel.removeMasterView();
        nVpanel.removeMain();
        nVpanel.addMain(m_view);
    }

    public void switchToMasterLoginViewPanel(MasterLoginView masterView) {
        nVpanel.removeSplash();
        nVpanel.removeMasterView();
        nVpanel.removeMain();
        nVpanel.addMasterView(masterView);
    }

    
    
    public void addOptionsButtonListener(ActionListener al) {
        nVpanel.menu.optionsButton.addActionListener(al);
    }
    
    
    public void addHighScoreButtonListener(ActionListener al) {
        nVpanel.menu.highScoreButton.addActionListener(al);
    }

    public void addMainButtonListener(ActionListener al) {
        nVpanel.menu.mainButton.addActionListener(al);
    }

    public void addCreditsButtonLIstener(ActionListener al) {
        nVpanel.menu.creditsButton.addActionListener(al);
    }

    public void addInstructionsButtonListener(ActionListener al) {
        nVpanel.menu.instructionsButton.addActionListener(al);
    }
    
    
    

    //TODO: Add listeners to switch to other Panels
}
