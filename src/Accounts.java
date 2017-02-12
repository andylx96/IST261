/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
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
//        accountsArray = new ArrayList();
//        accountsArrayUsername = new ArrayList();
//        accountsArrayPassword = new ArrayList();
//        accountsArraySource = new ArrayList();
//
//        accountsArrayUsername.add("TesterUserName1");
//        accountsArrayPassword.add("TestPassword1");
//        accountsArraySource.add("TestSource1");
//
//        accountsArrayUsername.add("TesterUserName2");
//        accountsArrayPassword.add("TestPassword2");
//        accountsArraySource.add("TestSource2");
//
//        accountsArrayUsername.add("TesterUserName3");
//        accountsArrayPassword.add("TestPassword3");
//        accountsArraySource.add("TestSource3");
//
//        accountsArray.add(accountsArrayUsername);
//        accountsArray.add(accountsArrayPassword);
//        accountsArray.add(accountsArraySource);

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
