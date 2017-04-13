
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavViewBottomMenuPanel extends JPanel {
    
    JButton createButton, loginButton, deleteButton, searchButton, viewButton, createMaster, saveButton;
    public NavViewBottomMenuPanel() {
        super();
        
        //icon soruce https://www.iconfinder.com/icons/1902269/contact_directory_icon#size=128

 
        loginButton = new JButton("LOGIN");
        createButton = new JButton("Create Account");
        createButton.setIcon(new ImageIcon("src/Images/create.png"));
        
        deleteButton = new JButton("Delete Account");
        deleteButton.setIcon(new ImageIcon("src/Images/delete.png"));
        searchButton = new JButton("Help");
        searchButton.setIcon(new ImageIcon("src/Images/help.png"));
        saveButton = new JButton("Save Accounts");
        saveButton.setIcon(new ImageIcon("src/Images/save.png"));
        viewButton = new JButton("View All");
        viewButton.setIcon(new ImageIcon("src/Images/search.png"));
        createMaster = new JButton("Sign Up");
        
        createButton.setVisible(false);
        deleteButton.setVisible(false);
        viewButton.setVisible(false);
        searchButton.setVisible(false);
        saveButton.setVisible(false);
        createMaster.setVisible(false);
        
        
        add(loginButton);
        add(createButton);
        add(deleteButton);
        add(viewButton);
        add(searchButton);
        add(saveButton);
        add(createMaster);
    }
    
    public JButton getSaveButton(){
        return saveButton;
    }
    
    public void setSaveButton(JButton saveButton){
        this.saveButton = saveButton;
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

    public JButton getCreateMaster() {
        return createMaster;
    }

    public void setCreateMaster(JButton createMaster) {
        this.createMaster = createMaster;
    }


}
