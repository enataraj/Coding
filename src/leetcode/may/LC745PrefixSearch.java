package leetcode.may;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LC745PrefixSearch {

    public class WordFilterSol {

        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        public WordFilterSol(String[] words) {
            for (int idx = 0; idx < words.length; idx++) {
                for (int i = 0; i < words[idx].length(); i++) {
                    for (int j = 0; j < words[idx].length(); j++) {
                        String key = words[idx].substring(0, i) + "#" + words[idx].substring(words[idx].length() - j);
                        wordsMap.put(key, idx);
                    }

                }
            }
            // System.out.println(wordsMap);
        }

        public int f(String prefix, String suffix) {
            String key = prefix + "#" + suffix;
            Integer idx = wordsMap.get(key);
            if (idx == null) {
                return -1;
            }
            return idx;

        }

    }

    class WordFilter {
        Trie forward;
        Trie backward;

        public WordFilter(String[] words) {
            forward = new Trie(true);
            backward = new Trie(false);

            for (int i = 0; i < words.length; i++) {
                forward.addWord(words[i], i);
                backward.addWord(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            List<Integer> l1 = forward.startsWith(prefix);
            List<Integer> l2 = backward.startsWith(suffix);

            int i1 = l1.size() - 1;
            int i2 = l2.size() - 1;
            while (i1 >= 0 && i2 >= 0) {
                int a = l1.get(i1);
                int b = l2.get(i2);

                if (a > b) {
                    i1--;
                } else if (a < b) {
                    i2--;
                } else {
                    return a;
                }
            }
            return -1;
        }
    }

    class Trie {
        TrieNode root;
        boolean forward;

        public Trie(boolean fwd) {
            root = new TrieNode();
            forward = fwd;
        }

        public void addWord(String word, int idx) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = this.forward ? word.charAt(i) : word.charAt(word.length() - i - 1);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                cur.indices.add(idx);
            }
        }

        public List<Integer> startsWith(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = this.forward ? word.charAt(i) : word.charAt(word.length() - i - 1);
                if (cur.children[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                cur = cur.children[c - 'a'];
            }
            return cur.indices;
        }
    }

    class TrieNode {
        TrieNode[] children;
        List<Integer> indices;

        public TrieNode() {
            children = new TrieNode[26];
            indices = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        LC745PrefixSearch obj = new LC745PrefixSearch();
    }

}
