
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavViewBottomMenuPanel extends JPanel {
    
    JButton createButton;
    JButton loginButton;
    JButton deleteButton;
    JButton searchButton;
    JButton viewButton;
    
    public NavViewBottomMenuPanel() {
        super();
        
        loginButton = new JButton("LOGIN");
        createButton = new JButton("Create Account");
        deleteButton = new JButton("Delete Account");
        searchButton = new JButton("Search Account");
        viewButton = new JButton("View All");
        
        createButton.setVisible(false);
        deleteButton.setVisible(false);
        viewButton.setVisible(false);
        searchButton.setVisible(false);
        
        add(loginButton);
        add(createButton);
        add(deleteButton);
        add(viewButton);
        add(searchButton);
        
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public void setViewButton(JButton viewButton) {
        this.viewButton = viewButton;
    }


}
