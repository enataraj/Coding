package leetcode.july2021;

import java.util.HashMap;
import java.util.Map;

public class LC677MapSum {

    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        int val;

        public TrieNode(Map<Character, TrieNode> map, int val) {
            this.map = map;
            this.val = val;

        }

        @Override
        public String toString() {
            return "Map : " + map + "CurSum " + val;
        }
    }

    class MapSum {
        TrieNode root;

        public MapSum() {
            Map<Character, TrieNode> map = new HashMap<>();
            char ch = ' ';
            root = new TrieNode(map, 0);
        }

        public void insert(String key, int val) {
            TrieNode node = root;
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if (node.map.containsKey(ch)) {
                    node = node.map.get(ch);

                    node.val += val;
                    node.map.put(ch, node);

                } else {
                    Map<Character, TrieNode> map = new HashMap<>();
                    TrieNode newnode = new TrieNode(map, val);
                    node.map.put(ch, newnode);
                    node = newnode;
                }

            }

        }

        public int sum(String prefix) {
            int sum = 0;
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.map.containsKey(ch)) {
                    node = node.map.get(ch);
                    sum = node.val;
                } else {
                    return 0;
                }

            }
            return sum;
        }
    }

    class MapSum1 {
        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum1() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);

        }

        public int sum(String prefix) {
            int sum = 0;
            for (String key : map.keySet()) {
                if (key.startsWith(prefix)) {
                    sum += map.get(key);
                }
            }
            return sum;
        }
    }

}
