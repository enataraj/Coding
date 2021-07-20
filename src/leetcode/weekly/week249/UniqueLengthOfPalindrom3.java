package leetcode.weekly.week249;

import java.util.ArrayList;
import java.util.List;

public class UniqueLengthOfPalindrom3 {

    public int countPalindromicSubsequence(String s) {
        int result = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int firstIdx = s.indexOf(ch);
            int lastIdx = s.lastIndexOf(ch);
            if (firstIdx != -1 && lastIdx != -1 && firstIdx != lastIdx) {
                int[] freq = new int[26];
                for (int i = firstIdx + 1; i < lastIdx; i++) {
                    freq[s.charAt(i) - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

    public int countPalindromicSubsequenceNW(String s) {
        char[] input = s.toCharArray();
        List<String> palindrom = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    if (input[i] == input[k]) {
                        StringBuffer buff = new StringBuffer();
                        buff.append(input[i] + input[j] + input[k]);
                        palindrom.add(buff.toString());
                    }
                }
            }
        }

        return palindrom.size();

    }

    public static void main(String[] args) {
        UniqueLengthOfPalindrom3 obj = new UniqueLengthOfPalindrom3();
        String s = "tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp";
        // String s = "aaaa";
        System.out.println(obj.countPalindromicSubsequence(s));

    }

}
