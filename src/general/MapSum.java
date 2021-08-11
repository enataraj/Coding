package general;

import java.util.HashMap;
import java.util.Map;

class MapSum {

    public class TrieNode {
        Map<Character, TrieNode> map;
        int val;

        public TrieNode() {
            this.map = new HashMap<>();
            this.val = 0;
        }

        @Override
        public String toString() {
            return "Map : " + map;
        }
    }

    TrieNode root;
    HashMap<String, Integer> updatedStringMap;

    public MapSum() {
        root = new TrieNode();
        updatedStringMap = new HashMap<>();
    }

    public void insert(String key, int val) {      
        int diff = val-updatedStringMap.getOrDefault(key, 0);
        updatedStringMap.put(key, val);
        TrieNode node = root;
        for ( char ch : key.toCharArray()) {
            if (node.map.containsKey(ch)) {
                node.map.get(ch).val += diff;
            } else {
                TrieNode newnode = new TrieNode();
                newnode.val = diff;
                node.map.put(ch, newnode);
            }
            node = node.map.get(ch);
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

   
    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }

}
