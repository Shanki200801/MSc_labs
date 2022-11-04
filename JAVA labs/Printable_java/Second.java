package Printable_java;

import java.util.Arrays;
import java.util.Scanner;

public class Second {
    
    static boolean PanagramCheck(String s1){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        s1 = s1.toLowerCase();
        for (char c : alpha.toCharArray()) {
            if(s1.indexOf(c)==-1){
                return false;
            }
        }
        return true;
    }
    static boolean AnagramCheck(String s1,String s2){
        
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        if(s1.length()!=s2.length())
            return false;

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s1arr);
        Arrays.sort(s2arr);

        if(Arrays.equals(s1arr,s2arr)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2 strings");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(AnagramCheck(s1, s2))
            System.out.println("The given Strings are anagrams");
        else
            System.out.println("The given strings arent anagarams");

            
    }
}
