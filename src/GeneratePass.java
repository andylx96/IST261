
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pxk5145
 */
public class GeneratePass {
    
    public GeneratePass()
    {
    }
        
    final String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
    final String lowerAlpha = "abcdefghijklmnopqrstuvwxyz";
    final String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String nums = "1234567890";
    final String special = "!@#$";
    int a = all.length();
    int l = lowerAlpha.length();
    int u = upperAlpha.length();
    int n = nums.length();
    int s = special.length();
    Random r = new Random();
    char c = 'a';
    
    public String GenPass(int q)
    {
        String newPass = "";
        int i = 0;
        while (i < q)
        {
            c = all.charAt(r.nextInt(a));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }
    
    public String GenLower()
    {
        String newPass = "";
        c = lowerAlpha.charAt(r.nextInt(l));
        return newPass;
    }
    
    public String GenUpper()
    {
        String newPass = "";
        c = upperAlpha.charAt(r.nextInt(u));
        return newPass;
    }
    
    public String GenNum()
    {
        String newPass = "";
        c = nums.charAt(r.nextInt(n));
        return newPass;
    }
    
    public String GenSpecial()
    {
        String newPass = "";
        c = special.charAt(r.nextInt(s));
        return newPass;
    }
    
}
