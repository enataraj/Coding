package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LC890FindReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<List<Integer>> pattenList = getPatternArray(pattern);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            List<List<Integer>> wordIdxList = getPatternArray(word);
            if (isPatternMatched(pattenList, wordIdxList)) {
                result.add(word);
            }

        }
        return result;
    }

    private List<List<Integer>> getPatternArray(String word) {
        Map<Character, List<Integer>> patternMap = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (patternMap.containsKey(ch)) {
                List<Integer> idxList = patternMap.get(ch);
                idxList.add(i);
                patternMap.put(ch, idxList);

            } else {

                List<Integer> idxList = new ArrayList<>();
                idxList.add(i);
                patternMap.put(ch, idxList);

            }

        }

        List<List<Integer>> pattenList = new ArrayList<>();
        for (List<Integer> list : patternMap.values()) {
            pattenList.add(list);
        }
        return pattenList;
    }

    private boolean isPatternMatched(List<List<Integer>> pattenList, List<List<Integer>> wordIdxList) {
        if (pattenList.size() != wordIdxList.size()) {
            return false;
        }

        for (int i = 0; i < pattenList.size(); i++) {
            if (pattenList.get(i).size() != wordIdxList.get(i).size()) {
                return false;
            }
            for (int j = 0; j < pattenList.get(i).size(); j++) {
                if (pattenList.get(i).get(j) != wordIdxList.get(i).get(j)) {
                    return false;
                }
            }

        }
        return true;
    }

    public List<String> findAndReplacePatternNW(String[] words, String pattern) {
        int[] patternArray = getPatternArrayNW(pattern);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int[] wordArray = getPatternArrayNW(word);
            if (Arrays.equals(patternArray, wordArray)) {
                result.add(word);
            }

        }
        return result;
    }

    private int[] getPatternArrayNW(String word) {
        Map<Character, Integer> patternMap = new LinkedHashMap<>();
        for (char ch : word.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        int patternArray[] = new int[patternMap.size()];
        int idx = 0;
        for (int val : patternMap.values()) {
            patternArray[idx++] = val;
        }
        return patternArray;
    }

    public static void main(String[] args) {
        LC890FindReplacePattern obj = new LC890FindReplacePattern();
        //String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        // String pattern = "abb";

        String[] words = { "badc", "abab", "dddd", "dede", "yyxx" };
        String pattern = "baba";
        System.out.println(obj.findAndReplacePattern(words, pattern));
    }

}
