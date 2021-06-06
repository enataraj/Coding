package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character key = word.charAt(i);
            if (!currentNode.map.containsKey(key)) {
                currentNode.map.put(key, new TrieNode());

            }
            currentNode = currentNode.map.get(key);
        }
        currentNode.isEnd = true;
    }

    private class TrieNode {

        public Map<Character, TrieNode> map;
        public boolean isEnd;

        public TrieNode() {

            map = new HashMap<>();
            isEnd = false;

        }

    }
}
