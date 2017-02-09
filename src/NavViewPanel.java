
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class NavViewPanel extends JPanel {

    NavViewBottomMenuPanel menu;
    SplashScreenPanel splash;

   
    CreateView m_view;
   
    public NavViewPanel() {
        super();
        setLayout(new BorderLayout());
        menu = new NavViewBottomMenuPanel();
        splash = new SplashScreenPanel();
        add(menu, BorderLayout.SOUTH);
        add(splash, BorderLayout.CENTER);
    }

    //Note: Splash scrren is only shown on startup.  No need to navigate back to it.
   
    public void addMain(CreateView m_view) {
        this.m_view = m_view;  //maintain handle to this view so we can remove it
        add(m_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void addSplash(NavView n_view) {
        add(n_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public void removeMain() {
        if (this.m_view != null) {
            remove(this.m_view);
        }
    }

    public void removeSplash() {
        remove(splash);
    }

}
