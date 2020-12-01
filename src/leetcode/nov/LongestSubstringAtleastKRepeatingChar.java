package leetcode.nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringAtleastKRepeatingChar {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, List<Integer>> charMap = new HashMap<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (charMap.containsKey(ch)) {
                List<Integer> tmpList = charMap.get(ch);
                tmpList.add(i);
                charMap.put(ch, tmpList);
            } else {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                charMap.put(ch, tmpList);
            }
            i++;
        }

        System.out.println(charMap);

        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;

        for (char key : charMap.keySet()) {
            List<Integer> tmpList = charMap.get(key);

            if (tmpList.size() >= k) {
                System.out.println(tmpList);
                minIdx = Math.min(minIdx, tmpList.get(0));
                maxIdx = Math.max(maxIdx, tmpList.get(tmpList.size() - 1));
            }

        }

        if (minIdx == Integer.MAX_VALUE || maxIdx == Integer.MIN_VALUE) {
            return 0;
        }

        return (maxIdx - minIdx) + 1;

    }

    public int longestSubstringSol(String s, int k) { // "aaabb", k = 3
        int n = s.length(), // 5
                longest = 0; // 0

        for (int u = 1; u <= 26; u++) { // at most 26 unique characters can be present in the ans
            int cand = helper(s, k, u);
            longest = Math.max(longest, cand);
        }

        return longest;
    }

    private int helper(String s, int k, int numUniques) {
        int n = s.length(), longest = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < n; right++) {
            char chRight = s.charAt(right);
            map.put(chRight, map.getOrDefault(chRight, 0) + 1);

            while (map.size() > numUniques) {
                char chLeft = s.charAt(left);
                if (map.put(chLeft, map.get(chLeft) - 1) == 1) {
                    map.remove(chLeft);
                }
                ++left;
            }

            if (allCharsRepeatingAtLeastKTimes(map, k)) {
                longest = Math.max(longest, right - left + 1);
            }
        }

        return longest;
    }

    private boolean allCharsRepeatingAtLeastKTimes(Map<Character, Integer> map, int k) {
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() < k) {
                return false;
            }
        }

        return true;
    }
    
    
    
    
    
    
    // Optimized Solution
    
    
    
    String s;
    int k;
    public int longestSubstringOpt(String s, int k) {
        this.s = s;
        this.k=k;
        return helper(0, s.length());
    }
    private int helper(int start, int end) {
        if (k==1) {return end-start;}
        if (k>(end-start)) {return 0;}
        int[] arr = new int[26];
        for (int j=start;j<end;j++) {
            arr[s.charAt(j)-'a']++;
        }
        int last = -1;
        int res = 0;
        boolean higher=true;
        for (int j=start;j<end;j++) {
            if (arr[s.charAt(j) - 'a'] < k) {
                higher = false;
                res= Math.max(res, helper(last+1, j));
                last = j;
            }
        }
       
        if (higher) {res= end-start;}
        else {res= Math.max(res, helper(last+1, end));}
         // System.out.println(String.format("%s, res=%d, b=%s",s, res, arr[1]));
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringAtleastKRepeatingChar obj = new LongestSubstringAtleastKRepeatingChar();
        String s = "weitong";
        int k = 2;
        System.out.println(obj.longestSubstring(s, k));
    }

}
