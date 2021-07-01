package leetcode.weekly.week247;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WonderfulSubString {

    public long wonderfulSubstringsSol(String word) {
        long res = 0, count[] = new long[1024];
        int cur = 0;
        count[0] = 1L;
        for (int i = 0; i < word.length(); ++i) {
            cur ^= 1 << (word.charAt(i) - 'a');
            res += count[cur]++;
            for (int j = 0; j < 10; ++j)
                res += count[cur ^ (1 << j)];
        }
        return res;
    }

    public long wonderfulSubstrings(String word) {
        long result = 0;
        Set<String> goodString = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String str = word.substring(i, j);
                if (goodString.contains(str)) {
                    result++;
                    continue;
                }
                Map<Character, Integer> map = new HashMap<>();
                for (char ch : str.toCharArray()) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
                int cnt = 0;
                for (int val : map.values()) {
                    if (val % 2 == 1) {
                        cnt++;
                    }
                    if (cnt > 1) {
                        break;
                    }
                }
                if (cnt <= 1) {
                    goodString.add(str);
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WonderfulSubString obj = new WonderfulSubString();
        System.out.println(obj.wonderfulSubstrings("aba"));
    }
}
