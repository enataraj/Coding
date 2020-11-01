package leetcode.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordBreak1 {

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            String curr = queue.poll();
            if (set.contains(curr))
                continue;
            if (curr.equals(""))
                return true;
            set.add(curr);
            for (String edge : wordDict) {
                if (curr.length() < edge.length())
                    continue;
                if (curr.substring(0, edge.length()).equals(edge)) {
                    String next = curr.substring(edge.length(), curr.length());
                    // if(next.equals(""))return true;
                    queue.add(next);

                }
            }

        }
        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && dp[j] && isMatch(s, j, word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean isMatch(String s, int start, String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != s.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean wordBreakDP2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    
    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;
        
        TrieNode() {
            map = new HashMap();
            isEnd = false;
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                cur.map.putIfAbsent(ch, new TrieNode());
                cur = cur.map.get(ch);
            }
            
            cur.isEnd = true;
        }
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for (String word : wordDict) {
            t.addWord(word);
        }
        
        Set<Integer> visited = new HashSet<>();
        return helper(s, 0, t.root, visited);
    }
    
    private boolean helper(String word, int idx, TrieNode root, Set<Integer> visited) {
        TrieNode cur = root;
        if (word.isEmpty()) {
            return cur.isEnd;

        } else if (idx == word.length()) {
            return true;

        }
        
        if (visited.contains(idx)) {
            return false;
        }
        
        for (int i = idx; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.map.containsKey(ch)) {
                visited.add(i);
                return false;
            }

            cur = cur.map.get(ch);

            if (cur.isEnd && helper(word, i+1, root, visited)) {
                return true;
            }
        }

        if (!cur.isEnd) {
            visited.add(idx);
        }
        return cur.isEnd;
    }
    

    public static void main(String[] args) {
        WordBreak1 obj = new WordBreak1();
        // String s = "leetcode";
        String s = "catscatanddog";
        List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        // wordDict.add("code");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(obj.wordBreak(s, wordDict));

    }

}
