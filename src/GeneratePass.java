
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
        
    final String chara = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
    int n = chara.length();
    Random r = new Random();
    char c = 'a';
    
    public String GenPass(int q)
    {
        String newPass = "";
        int i = 0;
        while (i < q)
        {
            c = chara.charAt(r.nextInt(n));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }
    
    
    
}
