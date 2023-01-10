import java.util.Arrays;
import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        int maxlen = 0, currlen = 0;
        char[] s_array = s.toCharArray();
        for (int i = 0; i < s_array.length; i++) {
            if (!set.containsKey(s_array[i])) {
                currlen++;
                set.put(s_array[i], i);
            } else {
                currlen = i - set.get(s_array[i]);
                set.clear();
                set.put(s_array[i], i);

            }
            maxlen = Math.max(currlen, maxlen);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
