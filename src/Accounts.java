/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class Accounts {

    JTextArea textbox;
    ArrayList<ArrayList> accountsArray;
    ArrayList<String> accountsArrayUsername;
    ArrayList<String> accountsArrayPassword;
    ArrayList<String> accountsArraySource;

    public Accounts() {
 
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

  
}
