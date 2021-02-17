package leetcode.feb;

import java.util.Arrays;

public class LC242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0)
                return false;
        }

        return true;
    }
    
    public boolean isAnagram3pass(String s, String t) {
        int[] chars = new int[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            chars[ch - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0)
                return false;
        }

        return true;
    }
    
    public boolean isAnagramSort(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        return Arrays.equals(S,T);
    }

    public static void main(String[] args) {
        LC242ValidAnagram obj = new LC242ValidAnagram();
        String s = "anagrsm";
        String t = "nagaram";
        System.out.println(obj.isAnagram(s, t));

    }

}
