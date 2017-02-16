
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class NavView extends JFrame {

    NavModel model;
    NavViewPanel nVpanel;

    NavView(NavModel model) {
        super("Account Manager");
        this.model = model;

        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nVpanel = new NavViewPanel();

        add(nVpanel);
    }

    public void switchToCreateViewPanel(CreateView create_view) {
        nVpanel.removeSplash();
        nVpanel.removeMaster();
        nVpanel.removeCreate();
        nVpanel.removeSearch();
        nVpanel.addCreate(create_view);
    }

    public void switchToMasterLoginViewPanel(MasterLoginView masterView) {
        nVpanel.removeSplash();
        nVpanel.removeMaster();
        nVpanel.removeCreate(); 
        nVpanel.removeSearch();
        nVpanel.addMasterView(masterView);
    }
    
    public void switchToSearchViewPanel(SearchView search_view) {
        nVpanel.removeSplash();
        nVpanel.removeMaster();
        nVpanel.removeCreate();
        nVpanel.removeSearch();
        nVpanel.addSearch(search_view);
    }

    public void addMasterButtonListener(ActionListener al) {
        nVpanel.menu.loginButton.addActionListener(al);
    }
    
    public void addViewButtonListener(ActionListener al) {
        nVpanel.menu.viewButton.addActionListener(al);
    }

    public void addCreateButtonListener(ActionListener al) {
        nVpanel.menu.createButton.addActionListener(al);
    }

    public void addDeleteButtonLIstener(ActionListener al) {
        nVpanel.menu.searchButton.addActionListener(al);
    }

      public void addSearchButtonListener(ActionListener al) {
        nVpanel.menu.searchButton.addActionListener(al);
    }
      
         public void addCreateMasterButtonListener(ActionListener al) {
        nVpanel.menu.createMaster.addActionListener(al);
    }

    public NavViewPanel getnVpanel() {
        return nVpanel;
    }

    public void setnVpanel(NavViewPanel nVpanel) {
        this.nVpanel = nVpanel;
    }
}
