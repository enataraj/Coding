package leetcode.march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC423ReconstructOriginalString {
    public String originalDigits(String s) {

        if (s == null || s.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cache.containsKey(ch)) {
                cache.put(ch, cache.get(ch) + 1);
            } else {
                cache.put(ch, 1);
            }
        }
        
        /*
         * twonine 
         * 
         * one 
         */

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("zero", 0);
        map.put("two", 2);
        map.put("four", 4);
        map.put("six", 6);
        map.put("eight", 8);
        map.put("one", 1);
        map.put("three", 3);
        map.put("five", 5);
        map.put("seven", 7);
        map.put("nine", 9);

        for (String key : map.keySet()) {
            boolean flag = true;
            while (flag) {
                Map<Character, Integer> tmpCache = new HashMap<>(cache);
                for (int j = 0; j < key.length(); j++) {
                    char ch = key.charAt(j);
                    if (tmpCache.containsKey(ch)) {
                        int cnt = tmpCache.get(ch);
                        if (cnt == 1) {
                            tmpCache.remove(ch);
                        } else {
                            tmpCache.put(ch, cnt - 1);
                        }
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.append(map.get(key));
                    cache = new HashMap<>(tmpCache);
                }
            }
        }
        char[] chArray = result.toString().toCharArray();
        Arrays.sort(chArray);
        return new String(chArray);
    }

    public String originalDigitsBF(String s) {
        if (s == null || s.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cache.containsKey(ch)) {
                cache.put(ch, cache.get(ch) + 1);
            } else {
                cache.put(ch, 1);
            }
        }

        String[] numArray = { "zero", "two", "four", "six", "eight", "one", "three", "five", "seven", "nine" };
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("two", 2);
        map.put("four", 4);
        map.put("six", 6);
        map.put("eight", 8);
        map.put("one", 1);
        map.put("three", 3);
        map.put("five", 5);
        map.put("seven", 7);
        map.put("nine", 9);

        for (int i = 0; i < numArray.length; i++) {
            boolean flag = true;
            Map<Character, Integer> tmpCache = new HashMap<>(cache);
            for (int j = 0; j < numArray[i].length(); j++) {
                char ch = numArray[i].charAt(j);
                if (tmpCache.containsKey(ch)) {
                    int cnt = tmpCache.get(ch);
                    if (cnt == 1) {
                        tmpCache.remove(ch);
                    } else {
                        tmpCache.put(ch, cnt - 1);
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.append(map.get(numArray[i]));
                cache = new HashMap<>(tmpCache);
                i = i - 1;
            }

        }
        char[] chArray = result.toString().toCharArray();
        Arrays.sort(chArray);

        return new String(chArray);
    }

    public String originalDigitsSol(String s) {
        //      one two three four five six seven eight nine zero
        //          z only for zero
        //          x only for six
        //          u only for four
        //          w only for two
        //          g only eight
        //          five f - four
        //          one o - two - four - zero
        //          three t - eight - two
        //          seven s -six
        //          nine i - five - six - eight
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int[] digits = new int[10];
        digits[0] = chars['z' - 'a'];
        digits[6] = chars['x' - 'a'];
        digits[4] = chars['u' - 'a'];
        digits[2] = chars['w' - 'a'];
        digits[8] = chars['g' - 'a'];
        digits[5] = chars['f' - 'a'] - digits[4];
        digits[1] = chars['o' - 'a'] - digits[2] - digits[4] - digits[0];
        digits[3] = chars['t' - 'a'] - digits[2] - digits[8];
        digits[7] = chars['s' - 'a'] - digits[6];
        digits[9] = chars['i' - 'a'] - digits[5] - digits[6] - digits[8];
        System.out.println(Arrays.toString(digits));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                res.append(i);
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        LC423ReconstructOriginalString obj = new LC423ReconstructOriginalString();
        System.out.println(obj.originalDigitsSol("zeroonetwothreefourfivesixseveneightnine"));
    }

}
