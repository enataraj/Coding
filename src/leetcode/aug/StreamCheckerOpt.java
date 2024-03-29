package leetcode.aug;

public class StreamCheckerOpt {

    // Idea: to check word reversely from the back, use Trie
    class Trie {
        // mark the end of the word
        boolean isWord;
        Trie[] next = new Trie[26];
    }

    Trie root = new Trie();
    StringBuilder sb = new StringBuilder();

    // create Trie
    public StreamCheckerOpt(String[] words) {
        for (String s : words) {
            Trie node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        Trie node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

}
