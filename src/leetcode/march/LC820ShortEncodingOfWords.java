package leetcode.march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC820ShortEncodingOfWords {

    public int minimumLengthEncodingBF(String[] words) {

        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        StringBuffer resultBuffer = new StringBuffer();

        for (String str : words) {
            String tmp = str + "#";
            if (resultBuffer.indexOf(tmp) == -1) {
                resultBuffer.append(tmp);
            }
        }
        return resultBuffer.length();
    }
    
    /*
     * time#bell# 
     * 
     * #
     */

    public int minimumLengthEncodingSet(String[] words) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        for (String str : words) {
            for (int i = 1; i < str.length(); i++) {
                wordsSet.remove(str.substring(i));
            }

        }
        int length = 0;
        
       
        for (String str : wordsSet) {
            length += str.length() + 1;
        }
        return length;
    }

    class Trie {
        Trie[] next = null;
    }
    

    private int visit(String s, Trie node) {
        boolean newBranch = false;
        int created = 0, length = s.length();
        for (int i = length - 1; i >= 0; i--) {   
            boolean newLevel = false;
            int idx = s.charAt(i) - 'a';
            if (null == node.next) {
                newLevel = true;
                node.next = new Trie[26];
            }

            if (null == node.next[idx])  {
                if (!newLevel) newBranch = true;
                node.next[idx] = new Trie();
                created++;
            }            
            node = node.next[idx];
        }

        return newBranch ? length + 1 : created;
    }
    
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        root.next = new Trie[26];
        int ret = 0;
        for (String s:words) {
            ret += visit(s, root);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        LC820ShortEncodingOfWords obj = new LC820ShortEncodingOfWords();

    }

}
