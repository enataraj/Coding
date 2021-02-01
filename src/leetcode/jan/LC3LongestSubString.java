package leetcode.jan;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LC3LongestSubString {
    
    public int lengthOfLongestSubstringParin(String s) {
    int n = s.length(),
            longest = 0;
        Set<Character> set = new HashSet<>();
        
        for (int left = 0, right = 0 ; right < n; right++) {
            char chRight = s.charAt(right);
            if (!set.contains(chRight)) {
                longest = Math.max(longest, right - left + 1);
                
            } else {
                while (left < right && s.charAt(left) != chRight) {
                    set.remove(s.charAt(left));
                    ++left;
                }
                
                ++left;
                
            }
            
            set.add(chRight);
            longest = Math.max(longest, right - left + 1);
        }
        
        return longest;
}

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int length = 0;

        Set<Character> chrSet = new HashSet<>();
        int i = 0, j = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            
            if(!chrSet.contains(ch)) {
                chrSet.add(ch);
                length = Math.max(length, i - j+1);
            }
            if (chrSet.contains(ch)) {
                while (j < i && s.charAt(j) != ch) {
                    j++;
                    chrSet.remove(ch);
                }
                j++;
                i++;
                chrSet.remove(ch);
                chrSet.add(ch);
                length = Math.max(length, i - j);
                

            } else {
                System.out.println(ch);
                chrSet.add(ch);
                i++;
                length = Math.max(length, i - j);
                System.out.println(length);
            }

        }

        return length;

    }

    public int lengthOfLongestSubstringNotOpt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int length = 0;

        Set<Character> chrSet = new HashSet<>();
        Deque<Character> queue = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chrSet.contains(ch)) {
                while (!queue.isEmpty() && queue.peekFirst() != ch) {
                    chrSet.remove(queue.pollFirst());
                }
                if (!queue.isEmpty() && queue.peekFirst() == ch) {

                    chrSet.remove(queue.pollFirst());
                    queue.addLast(ch);
                    chrSet.add(ch);
                    length = Math.max(length, queue.size());

                }

            } else {
                chrSet.add(ch);
                queue.addLast(ch);
                length = Math.max(length, queue.size());
            }
           // System.out.println(queue);

        }

        return length;

    }

    public static void main(String[] args) {
        LC3LongestSubString obj = new LC3LongestSubString();
        //String s = "abba";
         //String s = "aaabb";
        // String s ="dvdf";
        String s="tmmzuxt";
        System.out.println(obj.lengthOfLongestSubstring(s));

    }

}
