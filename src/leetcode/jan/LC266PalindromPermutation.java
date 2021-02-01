package leetcode.jan;

import java.util.HashMap;
import java.util.Map;

public class LC266PalindromPermutation {
    public boolean palindromePermutation(String str) {
        if (str == null || str.length() == 0)
            return false;
        if (str.length() == 1)
            return true;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int cnt = 0;
        for (int val : map.values()) {
            if (val % 2 == 1) {
                cnt++;
            }
        }

        if (cnt > 1) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        LC266PalindromPermutation obj = new LC266PalindromPermutation();
        System.out.println(obj.palindromePermutation("aaba"));
    }

}
