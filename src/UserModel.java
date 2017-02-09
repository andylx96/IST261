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
public class UserModel {
        String masterUserName;
    String masterUserPassword;
    String websiteDomain;
    String userName;
    String userPass;
    Scanner scan = new Scanner(System.in);

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
