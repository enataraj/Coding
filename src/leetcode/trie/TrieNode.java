package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Map<Character, TrieNode> map;
    public boolean isEnd;

    public TrieNode() {

        map = new HashMap<>();
        isEnd = false;

    }

}
