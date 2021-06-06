package leetcode.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1048LongestString {
    public int longestStrChain(String[] words) {
        Arrays.sort(words);
        int longestString = 0;
        Map<String, Integer> wordLengthMap = new HashMap<>();
        for (String str : words) {

            int length = 1;
            for (int i = 0; i < str.length(); i++) {
                StringBuffer buf = new StringBuffer(str);
                char ch = buf.charAt(i);
                buf.deleteCharAt(i);
                length = Math.max(length, wordLengthMap.getOrDefault(buf.toString(), 0) + 1);
                longestString = Math.max(length, longestString);
                buf.insert(i, ch);
            }
            wordLengthMap.put(str, length);
        }
        return longestString;
    }
    
    public int longestStrChainSol(String[] words) {
        int longest = 1;
        HashMap<String, Integer> word_max = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; ++i)
            longest = Math.max(longest, findLonger(word_max, words[i]));
        return longest;
    }

    private int findLonger(HashMap<String, Integer> word_max, String word) {
        int longer = 1;
        for (int j = 0; j < word.length(); ++j) {
            String last = new StringBuilder(word).deleteCharAt(j).toString();
            longer = Math.max(longer, word_max.getOrDefault(last, 0) + 1);
        }
        word_max.put(word, longer);
        return longer;
    }
}
