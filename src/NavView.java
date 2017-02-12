
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
        nVpanel.removeSearch();
        nVpanel.addMain(m_view);
    }

    public void switchToMasterLoginViewPanel(MasterLoginView masterView) {
        nVpanel.removeSplash();
        nVpanel.removeMasterView();
        nVpanel.removeMain();
        
        nVpanel.removeSearch();
        nVpanel.addMasterView(masterView);
    }
    
    public void switchToSearchViewPanel(SearchView search_view) {
        nVpanel.removeSplash();
        nVpanel.removeMasterView();
        nVpanel.removeMain();
        nVpanel.removeSearch();
        nVpanel.addSearch(search_view);
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
        nVpanel.menu.searchButton.addActionListener(al);
    }

    public void addInstructionsButtonListener(ActionListener al) {
        nVpanel.menu.instructionsButton.addActionListener(al);
    }
      public void addSearchButtonListener(ActionListener al) {
        nVpanel.menu.searchButton.addActionListener(al);
    }
    
    

    //TODO: Add listeners to switch to other Panels

    public NavViewPanel getnVpanel() {
        return nVpanel;
    }

    public void setnVpanel(NavViewPanel nVpanel) {
        this.nVpanel = nVpanel;
    }
}
