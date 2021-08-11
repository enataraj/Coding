package general;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> map;

    public TrieNode() {
        this.map = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Map : " + map;
    }
}
