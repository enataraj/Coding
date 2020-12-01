package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC387FindFirstUniqueChar {
    // Frequ Map one first pass
    // Second pass see the fre is 1.
    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.containsKey(s.charAt(i))) {
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);

            } else {
                freqMap.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }
    
    // Get the first Index and last Index , If both are not same we have duplicate 
    // else unique.
    // From the Unique find min unique.

    public int firstUniqCharSol(String s) {

        int min = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);

            if (i != -1 && i == s.lastIndexOf(c))
                min = Math.min(min, i);
        }

        if (min == Integer.MAX_VALUE)
            return -1;

        return min;
    }

    public static void main(String[] args) {
        LC387FindFirstUniqueChar obj = new LC387FindFirstUniqueChar();
        String s = "leetcolde";

        System.out.println(obj.firstUniqChar(s));

    }

}
