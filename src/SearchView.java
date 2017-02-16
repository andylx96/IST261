/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class SearchView extends JPanel  {
    JTextArea textbox;
        ArrayList<ArrayList> accountsArray;
        ArrayList<String> accountsArrayUsername;
        ArrayList<String> accountsArrayPassword;
        ArrayList<String> accountsArraySource;
        
        
        
        JComboBox<String> accounts;
        JLabel passwords, source;
        JButton findButton;
        
        JTable table;
        SearchView(){
        
            
            setLayout(new GridLayout(10,1));
        
               table = new JTable();
               
            accountsArray = new ArrayList();
            accountsArrayUsername = new ArrayList();
            accountsArrayPassword = new ArrayList();
            accountsArraySource = new ArrayList();
            
            accountsArray.add(accountsArrayUsername);
            accountsArray.add(accountsArrayPassword);
            accountsArray.add(accountsArraySource);
            
            accounts = new JComboBox(accountsArray.get(0).toArray());
            
            passwords = new JLabel();
            source = new JLabel();
            findButton = new JButton("Search");
            
            add(accounts);
            add(passwords);
            add(source);
            add(findButton);
            add(table);
            
            
            
            
            
        }

    public JButton getFindButton() {
        return findButton;
    }

    public void setFindButton(JButton findButton) {
        this.findButton = findButton;
    }
           public void addfindButtonListener(ActionListener al) {
        this.findButton.addActionListener(al);
    }

    public JTextArea getTextbox() {
        return textbox;
    }

    public void setTextbox(JTextArea textbox) {
        this.textbox = textbox;
    }

    public ArrayList<ArrayList> getAccountsArray() {
        return accountsArray;
    }

    public void setAccountsArray(ArrayList<ArrayList> accountsArray) {
        this.accountsArray = accountsArray;
    }

    public ArrayList<String> getAccountsArrayUsername() {
        return accountsArrayUsername;
    }

    public void setAccountsArrayUsername(ArrayList<String> accountsArrayUsername) {
        this.accountsArrayUsername = accountsArrayUsername;
    }

    public ArrayList<String> getAccountsArrayPassword() {
        return accountsArrayPassword;
    }

    public void setAccountsArrayPassword(ArrayList<String> accountsArrayPassword) {
        this.accountsArrayPassword = accountsArrayPassword;
    }

    public ArrayList<String> getAccountsArraySource() {
        return accountsArraySource;
    }

    public void setAccountsArraySource(ArrayList<String> accountsArraySource) {
        this.accountsArraySource = accountsArraySource;
    }

    public JComboBox<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(JComboBox<String> accounts) {
        this.accounts = accounts;
    }

    public JLabel getPasswords() {
        return passwords;
    }

    public void setPasswords(JLabel passwords) {
        this.passwords = passwords;
    }

    public JLabel getSource() {
        return source;
    }

    public void setSource(JLabel source) {
        this.source = source;
    }
    
                
                
}
