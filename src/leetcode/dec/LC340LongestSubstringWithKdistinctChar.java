package leetcode.dec;

import java.util.HashMap;
import java.util.Map;

public class LC340LongestSubstringWithKdistinctChar {
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longest = 0,
            n = s.length(),
            left = 0,
            right = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (; right < n; right++) {
            char chRight = s.charAt(right);
            map.put(chRight, map.getOrDefault(chRight, 0) + 1);
            
            while (map.size() > k) {
                char chLeft = s.charAt(left);
                if (map.put(chLeft, map.getOrDefault(chLeft, 0) - 1) == 1) {
                    map.remove(chLeft);
                }
                ++left;
            }
            
            longest = Math.max(longest, right - left + 1);
        }
        
        return longest;
    }

}
