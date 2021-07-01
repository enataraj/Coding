package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LC1876SubStringOfSize3 {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = s.length();
        int goodStringsCount = 0;
        if (len < 3) {
            return 0;
        }
        for (; right < 3; right++) {
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
        }
        if (countMap.size() == 3) {
            goodStringsCount += 1;
        }
        while (right < len) {
            countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
            if (countMap.get(s.charAt(left)) == 0) {
                countMap.remove(s.charAt(left));
            }
            left += 1;
            countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
            right += 1;
            if (countMap.size() == 3) {
                goodStringsCount += 1;
            }
        }
        return goodStringsCount;
    }

    public int countGoodSubstringsSol(String s) {
        int answer = 0;
        for (int index = 2; index < s.length(); index++) {
            if (s.charAt(index) != s.charAt(index - 1) && s.charAt(index - 1) != s.charAt(index - 2)
                    && s.charAt(index) != s.charAt(index - 2))
                answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        LC1876SubStringOfSize3 obj = new LC1876SubStringOfSize3();
        String s = "xyzzaz";
        System.out.println(obj.countGoodSubstrings(s));

    }
}
