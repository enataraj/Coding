package leetcode.topint;

import java.util.HashMap;
import java.util.Map;

public class LC208TrieImpl {

    class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                    node = node.children.get(ch);
                }
                /* if (node.children.get(ch) == null) {
                    TrieNode tmpNode = new TrieNode();
                    tmpNode.isEnd = false;
                    tmpNode.children = new HashMap<>();
                    node.children.put(ch, tmpNode);
                    node = tmpNode;
                }*/ else {
                    node = node.children.get(ch);
                }
            }
            node.isEnd = true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    return false;
                }
            }
            if (node.isEnd) {
                return true;
            }
            return false;

        }

        /**
         * Returns if there is any word in the trie that starts with the given
         * prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;
    }

}
