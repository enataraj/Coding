package leetcode.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC336PalindromePairs {
    
    /*
     * 
     * 
     *    lls s
     *    
     *    aaabc      cb
     *    a aabc
     *    aa abc
     *     cb aaa bc
     *    aaab c
     *    
     *    
     *    
     *    dcaba  cd
     *    
     *    
     * 
     * 1) 
     * "" 
     * if other word 
     * 
     * 2) word and reverse  --> 
     * 
     * 3)
     * 
     * 
     * 
     */

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        // If words contains empty String
        if (wordMap.containsKey("")) {
            int blankIdx = wordMap.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != blankIdx && isPalindrome(words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(blankIdx);
                    result.add(list);
                    list = new ArrayList<>();
                    list.add(blankIdx);
                    list.add(i);
                    result.add(list);
                }
            }
        }

        // Reflection case        
        for (int i = 0; i < words.length; i++) {
            String reverseWord = new StringBuffer(words[i]).reverse().toString();
            if (wordMap.containsKey(reverseWord) && wordMap.get(reverseWord) != i) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(wordMap.get(reverseWord));
                result.add(list);

            }
        }

        // Substring and Verify existence Map
     
        for (int i = 0; i < words.length; i++) {
            String curStr = words[i];
            for (int j = 1; j < curStr.length(); j++) {
                String leftSubString = curStr.substring(0, j);
                String rightSubString = curStr.substring(j);
                if (isPalindrome(leftSubString)) {
                    String reverseOfRight = new StringBuffer(rightSubString).reverse().toString();
                    if (wordMap.containsKey(reverseOfRight)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(wordMap.get(reverseOfRight));
                        result.add(list);

                    }
                }

                if (isPalindrome(rightSubString)) {

                    String reverseOfLeft = new StringBuffer(leftSubString).reverse().toString();
                    if (wordMap.containsKey(reverseOfLeft)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(wordMap.get(reverseOfLeft));
                        result.add(list);

                    }

                }
            }

        }

        return result;

    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public List<List<Integer>> palindromePairsTLE(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                StringBuffer buffer1 = new StringBuffer(words[i] + words[j]);
                StringBuffer buffer2 = new StringBuffer(words[j] + words[i]);
                if (isPalindrome(buffer1)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
                if (isPalindrome(buffer2)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    result.add(list);
                }
            }
        }
        return result;

    }

    private boolean isPalindrome(StringBuffer str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

}
