
import java.awt.BorderLayout;
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
    ViewAllView viewAll_view;
    CreateMasterLoginView createMasterLogin_view;
    InstructionView instruction_view;

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
    
    public void addViewAllView(ViewAllView viewAllView) {
        this.viewAll_view = viewAllView;
        add(viewAllView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
     public void addCreateMasterLoginView(CreateMasterLoginView createMasterLogin_view) {
        this.createMasterLogin_view = createMasterLogin_view;
        add(createMasterLogin_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

         
     public void addInstructionView(InstructionView instruction_view) {
        this.instruction_view = instruction_view;
        add(instruction_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeSucessfulLogin() {
        if (this.instruction_view != null) {
            remove(this.instruction_view);
        }
    }
     
    public void removeCreate() {
        if (this.create_view != null) {
            remove(this.create_view);
        }
    }

    
        public void removeViewAll() {
        if (this.viewAll_view != null) {
            remove(this.viewAll_view);
        }
    }

              public void removeCreateMasterLoginView() {
        if (this.createMasterLogin_view != null) {
            remove(this.createMasterLogin_view);
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
