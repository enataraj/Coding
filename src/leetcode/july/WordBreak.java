package leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    
    public List<String> wordBreak(String s, List<String> wordDict) {

        TrieNode root = buildTrie(wordDict);
        int[] dp = new int[s.length() + 1];
        List<List<Integer>> words = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            words.add(new ArrayList<>());
        }

        dfs(s, s.length(), words, dp, root);
        List<String> result = new ArrayList<>();
        if (dp[0] == -1) {
            return result;
        }

        printPath(result, words, s, new ArrayList<>(), 0);
        return result;
    }

    private void printPath(List<String> result, List<List<Integer>> words, String s, List<Integer> path, int index) {

        if (index == s.length()) {

            StringBuilder sb = new StringBuilder();
            int left = 0;
            for (int i = 0; i < path.size(); i++) {
                int right = path.get(i);
                for (int j = left; j < right; j++) {
                    sb.append(s.charAt(j));
                }

                if (i != path.size() - 1) {
                    sb.append(" ");
                }
                left = right;
            }

            result.add(sb.toString());
            return;
        }

        for (Integer next : words.get(index)) {
            path.add(next);
            printPath(result, words, s, path, next);
            path.remove(path.size() - 1);
        }

    }

    private int dfs(String s, int index, List<List<Integer>> words, int[] dp, TrieNode root) {

        if (index == 0) {
            dp[0] = 1;
            return 1;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        dp[index] = -1;
        for (int i = index; i >= 0; i--) {
            if (search(root, s, i, index)) {
                words.get(i).add(index);
                int current = dfs(s, i, words, dp, root);
                if (current == 1) {
                    dp[index] = 1;
                }
            }
        }

        return dp[index];
    }
    
    static class TrieNode {
        
        boolean isWord;
        TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private TrieNode buildTrie(List<String> wordDict) {
        
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            add(root, word);
        }
        
        return root;
    }
    
    private void add(TrieNode root, String word) {
        
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            
            char cur = word.charAt(i);
            TrieNode next = current.children[cur - 'a'];
            if (next == null) {
                next = new TrieNode();
                current.children[cur - 'a'] = next;
            }
            current = next;
        }
        
        current.isWord = true;
    }
    
    private boolean search(TrieNode root, String word, int left, int right) {
        
        TrieNode current = root;
        for (int i = left; i < right; i++) {
            
            char cur = word.charAt(i);
            TrieNode next = current.children[cur - 'a'];
            if (next == null) {
                return false;
            }
            current = next;
        }
        
        return current.isWord;
    }
    
    
    
    
    
    
    public List<String> wordBreak_Parin(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        Map<String, List<String>> cache = new HashMap<>();
        Set<String> impossibles = new HashSet<>();
        return helper(s, dict, cache, impossibles);
    }
    
    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> cache, Set<String> impossibles) {
        if (s.isEmpty()) {
            return Arrays.asList("");
            
        } else if (impossibles.contains(s)) {
            return Collections.emptyList();
            
        } else if (cache.containsKey(s)) {
            return cache.get(s);
            
        }
        
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {
                List<String> res2 = helper(s.substring(i), dict, cache, impossibles);
                for (String p : res2) {
                    res.add((sub + " " + p).trim());
                }
            }
        }
        
        if (!res.isEmpty()) {
            cache.put(s, res);
        } else {
            impossibles.add(s);
        }
        
        return res;
    }
    
    
    
    
    
    
    

}
