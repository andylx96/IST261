/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author ajl5735
 */
public class AccountModel {
        String masterUserName;
    String masterUserPassword;
    String domainName;
    String userName;
    String userPass;
    Scanner scan = new Scanner(System.in);

    public AccountModel(String userName, String userPass, String domainName){
    this.userName = userName;
    this.userPass = userPass;
    this.domainName = domainName;
    
    }

    public String getMasterUserName() {
        return masterUserName;
    }

    public void setMasterUserName(String masterUserName) {
        this.masterUserName = masterUserName;
    }

    public String getMasterUserPassword() {
        return masterUserPassword;
    }

    public void setMasterUserPassword(String masterUserPassword) {
        this.masterUserPassword = masterUserPassword;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
    
    public void DoStuff() {
        
        System.out.println("Enter user master password");
        masterUserName = scan.nextLine();
        System.out.println("Enter user password");
        masterUserPassword = scan.nextLine();
        System.out.println("Enter UserName");
        userName = scan.nextLine();
        System.out.println("Enter Password");
        userPass = scan.nextLine();
        System.out.println("Name Of Site");
        userPass = scan.nextLine();
        
        
        System.out.println(masterUserName);
        System.out.println(masterUserPassword);
        System.out.println(userName);
        System.out.println(userPass);
    }
}
