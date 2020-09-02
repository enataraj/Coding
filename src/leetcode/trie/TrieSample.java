package leetcode.trie;

public class TrieSample {

    public static void main(String[] args) {
        String[] words = { "Elumalai", "Nishanth", "Krish" };
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

    }

}
