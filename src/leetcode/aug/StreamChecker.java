package leetcode.aug;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StreamChecker {

    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;

        TrieNode() {
            map = new HashMap<>();
            isEnd = false;
        }
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void addReversedWord(String word) {
            TrieNode cur = root;

            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                cur.map.putIfAbsent(ch, new TrieNode());
                cur = cur.map.get(ch);
            }

            cur.isEnd = true;
        }

        boolean search(Deque<Character> dq) {
            TrieNode cur = root;
            for (char ch : dq) {
                if (!cur.map.containsKey(ch)) {
                    return false;
                }
                cur = cur.map.get(ch);
                if (cur.isEnd) {
                    return true;
                }
            }

            return cur.isEnd;
        }
    }

    private int maxLen = 0;
    private Trie t;
    Deque<Character> dq;

    public StreamChecker(String[] words) {
        t = new Trie();
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            t.addReversedWord(word);
        }
        dq = new ArrayDeque<>();
    }

    public boolean query(char letter) {
        dq.addFirst(letter);
        if (dq.size() > maxLen) {
            dq.removeLast();
        }

        return t.search(dq);
    }
    
    
    
    
    
    
}
