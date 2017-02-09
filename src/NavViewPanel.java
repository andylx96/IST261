
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class NavViewPanel extends JPanel {

    NavViewBottomMenuPanel menu;
    MasterLoginView masterLogin_view;

   
    CreateView m_view;
   
    public NavViewPanel() {
        super();
        setLayout(new BorderLayout());
        menu = new NavViewBottomMenuPanel();
        masterLogin_view = new MasterLoginView();
        
        masterLogin_view.addLoginAccountListener(new masterLoginButtonListener());
        
        add(menu, BorderLayout.SOUTH);
        add(masterLogin_view, BorderLayout.CENTER);
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
        remove(masterLogin_view);
    }
    
    
        class masterLoginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Pass a Main View object to our Navigation View
            //DO SOME SORT OF VALIDATE
            
        }
    }

}
