package leetcode.trie.util;

import leetcode.trie.TrieNode;

public class TrieUtil {

    public TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {
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
        return root;

    }

}
