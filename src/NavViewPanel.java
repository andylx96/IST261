
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class NavViewPanel extends JPanel {

    NavViewBottomMenuPanel menu;

    public NavViewBottomMenuPanel getMenu() {
        return menu;
    }

    public void setMenu(NavViewBottomMenuPanel menu) {
        this.menu = menu;
    }
    SplashScreenView splashScreen_view;
    MasterLoginView masterLogin_view;

    CreateView create_view;
    SearchView search_view;

    public NavViewPanel() {
        super();
        setLayout(new BorderLayout());
        menu = new NavViewBottomMenuPanel();
        splashScreen_view = new SplashScreenView();

        add(menu, BorderLayout.SOUTH);
        add(splashScreen_view, BorderLayout.CENTER);
    }

    public void addCreate(CreateView create_view) {
        this.create_view = create_view;  //maintain handle to this view so we can remove it
        add(create_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void addSearch(SearchView search_view) {

        this.search_view = search_view;  //maintain handle to this view so we can remove it
        add(search_view, BorderLayout.CENTER);
        revalidate();
        repaint();

    }

    public void addSplash(NavView n_view) {
        add(n_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void addMasterView(MasterLoginView masterView) {
        this.masterLogin_view = masterView;
        add(masterView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeCreate() {
        if (this.create_view != null) {
            remove(this.create_view);
        }
    }

    public void removeSearch() {
        if (this.search_view != null) {
            remove(this.search_view);
        }
    }

    public void removeMaster() {
        if (this.masterLogin_view != null) {
            remove(this.masterLogin_view);
        }
    }

    public void removeSplash() {
        if (this.splashScreen_view != null) {
            remove(this.splashScreen_view);
        }
    }

}
