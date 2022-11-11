/*-----------------------------------------------------------
Program to check if a given string is anagram or panagram
@Author - Shashank
-------------------------------------------------------------*/

package Printable_java;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Scanner;

public class AnaPanaGram {

    static boolean PanagramCheck(String s1) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        s1 = s1.toLowerCase();

        // checking if all letters if alpha exists in s1
        for (char c : alpha.toCharArray()) {
            if (s1.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    static boolean AnagramCheck(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        // if unequal length then no need to perform any operations
        if (s1.length() != s2.length())
            return false;

        // Coverting to char array and sorting to compare
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        Arrays.sort(s1arr);
        Arrays.sort(s2arr);

        if (Arrays.equals(s1arr, s2arr)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2 strings");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (AnagramCheck(s1, s2))
            System.out.println("The given Strings are anagrams");
        else
            System.out.println("The given strings arent anagarams");

        System.out.println("Enter a string to check if panagram");
        String s3 = sc.nextLine();
        if (PanagramCheck(s3)) {
            System.out.println(s3 + " \nis a panagram");
        } else {
            System.out.println(s3 + " \nis a not panagram");
        }

    }
}
