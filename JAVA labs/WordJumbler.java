import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.LinkedHashMap;

public class WordJumbler extends Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordJumbler obj = new WordJumbler();
        System.out.println("Enter a string");
        String s = sc.nextLine();
        // System.out.println(Arrays.toString(obj.jumbleString(s)));
        System.out.println(obj.removeRepeated(s));

        /*
         * if(obj.checkPanagram(s)){
         * System.out.println("panagram");
         * }
         * else{
         * System.out.println("not panagram");
         * }
         */

        sc.close();

    }
}

class SSolution {
    String[] jumbleString(String s) {
        String[] arr = s.split(" ");
        Scanner sc = new Scanner(System.in);
        int[] posarr = new int[arr.length];
        for (int i = 0; i < posarr.length; i++) {
            System.out.printf("Enter the position of %d th word", i);
            posarr[i] = sc.nextInt();
        }
        String[] newarr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[posarr[i]] = arr[i];
        }
        sc.close();

        return newarr;
    }

    String removeRepeated(String s) {
        StringBuilder str = new StringBuilder();
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        LinkedHashSet<Character> newset = new LinkedHashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i)))
                hm.replace(s.charAt(i), hm.get(s.charAt(i)), hm.get(s.charAt(i)) + 1);
            hm.putIfAbsent(s.charAt(i), 1);

        }
        for (Character key : hm.keySet()) {
            if (hm.get(key) == 1) {
                str.append(key);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            newset.add(s.charAt(i));
        }
        System.out.println(newset.toString());
        return str.toString();
    }

    boolean checkPanagram(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (s.indexOf(alpha.charAt(i)) == -1) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}