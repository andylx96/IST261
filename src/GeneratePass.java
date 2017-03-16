
import java.util.Random;

public class GeneratePass {

    final String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
    final String lowerAlpha = "abcdefghijklmnopqrstuvwxyz";
    final String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String nums = "1234567890";
    final String special = "!@#$";
    final String lowerupper = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String lowernums = "abcdefghijklmnopqrstuvwxyz1234567890";
    final String lowerspecial = "abcdefghijklmnopqrstuvwxyz!@#$";
    final String uppernums = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    final String upperspecial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$";
    final String numsspecial = "1234567890!@#$";
    final String loweruppernums = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    final String lowerupperspecial = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$";
    final String lowernumsspecial = "abcdefghijklmnopqrstuvwxyz1234567890!@#$";
    final String uppernumsspecial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
    int a = all.length();
    int l = lowerAlpha.length();
    int u = upperAlpha.length();
    int n = nums.length();
    int s = special.length();
    int lu = lowerupper.length();
    int ln = lowernums.length();
    int ls = lowerspecial.length();
    int un = uppernums.length();
    int us = upperspecial.length();
    int ns = numsspecial.length();
    int lun = loweruppernums.length();
    int lus = lowerupperspecial.length();
    int lns = lowernumsspecial.length();
    int uns = uppernumsspecial.length();
    Random r = new Random();
    char c = 'a';

    public GeneratePass() {
    }

    public String GenPass(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = all.charAt(r.nextInt(a));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLower(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowerAlpha.charAt(r.nextInt(l));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenUpper(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = upperAlpha.charAt(r.nextInt(u));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenNum(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = nums.charAt(r.nextInt(n));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = special.charAt(r.nextInt(s));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerUpper(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowerupper.charAt(r.nextInt(lu));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerNums(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowernums.charAt(r.nextInt(ln));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowerspecial.charAt(r.nextInt(ls));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenUpperNums(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = uppernums.charAt(r.nextInt(un));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenUpperSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = upperspecial.charAt(r.nextInt(us));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenNumsSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = numsspecial.charAt(r.nextInt(ns));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerUpperNums(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = loweruppernums.charAt(r.nextInt(lun));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerUpperSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowerupperspecial.charAt(r.nextInt(lus));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenLowerNumsSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = lowernumsspecial.charAt(r.nextInt(lns));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }

    public String GenUpperNumsSpecial(int q) {
        String newPass = "";
        int i = 0;
        while (i < q) {
            c = uppernumsspecial.charAt(r.nextInt(uns));
            newPass = newPass.concat(String.valueOf(c));
            i++;
        }
        return newPass;
    }
}
