package leetcode.feb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC584LongestWordInDictonary {

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,
                (s1, s2) -> s1.length() != s2.length() ? Integer.compare(s2.length(), s1.length()) : s1.compareTo(s2));

        for (String word : d) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }

        return "";

    }

    private boolean isSubsequence(String s, String word) {
        int sIdx = 0, wIdx = 0;

        while (sIdx < s.length() && wIdx < word.length()) {
            if (s.charAt(sIdx) == word.charAt(wIdx)) {
                ++wIdx;
            }

            ++sIdx;
        }

        return wIdx == word.length();
    }

    public String findLongestWordIterative(String s, List<String> d) {
        int len = s.length();

        int[][] indexes = new int[len + 1][26];

        Arrays.fill(indexes[len], Integer.MAX_VALUE);

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                indexes[i][j] = indexes[i + 1][j];
            }
            indexes[i][s.charAt(i) - 'a'] = i + 1;
        }

        String res = "";

        for (String word : d) {
            if (word.length() > s.length() || word.length() < res.length())
                continue;
            int i = 0;
            int j = 0;

            while (j < word.length()) {
                char c = word.charAt(j);
                if (indexes[i][c - 'a'] == Integer.MAX_VALUE)
                    break;
                i = indexes[i][c - 'a'];
                j++;
            }

            if (j == word.length()) {
                if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }

        return res;
    }

    public String findLongestWordwith(String s, List<String> d) {
        String max_str = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }

    public static void main(String[] args) {
        LC584LongestWordInDictonary obj = new LC584LongestWordInDictonary();
    }

}
