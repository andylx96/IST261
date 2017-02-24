
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavViewBottomMenuPanel extends JPanel {
    
    JButton createButton, loginButton, deleteButton, searchButton, viewButton, createMaster, saveButton;
    public NavViewBottomMenuPanel() {
        super();
        loginButton = new JButton("LOGIN");
        createButton = new JButton("Create Account");
        deleteButton = new JButton("Delete Account");
        searchButton = new JButton("Search Account");
        saveButton = new JButton("Save Accounts");
        viewButton = new JButton("View All");
        createMaster = new JButton("Create New Master Account");
        
        createButton.setVisible(false);
        deleteButton.setVisible(false);
        viewButton.setVisible(false);
        searchButton.setVisible(false);
        saveButton.setVisible(false);
        
        
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
