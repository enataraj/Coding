package leetcode.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC127WordLadder {
    /*
     * 
     * BFS Solution
     * 
     * Try All Possibility of char replacing.
     * 
     * Step 1 : Create Set and put all dictionary words into the set
     * 
     * Step 2 : Check the Set contains desitnation word
     * 
     * Step 3 : Take begin word, change each position by putting all possible char
     * from 'a' to 'z' Check the modified string is Equal to Destination string if
     * so return the result.
     * 
     * Check the modified string is there in Set, then we have possible
     * transformation , so remove it from set and add into queue, that is your one
     * of the next level transformation.
     * 
     * 
     * 
     * 
     */
    public int ladderLengthNotOpt(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> wordQueue = new LinkedList<>();

        // Base condition
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }

        // Add the begin word into Queue
        wordQueue.add(beginWord);
        int ladderLength = 1;

        while (!wordQueue.isEmpty()) {

            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                // Take out the word from queue
                String currentString = wordQueue.poll();
                char[] charArray = currentString.toCharArray();
                for (int j = 0; j < currentString.length(); j++) {
                    // Iterate through each char and see modify from 'a' to 'z' and check you can
                    // transform
                    char currentChar = charArray[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String tmpString = new String(charArray);
                        System.out.println(tmpString);

                        // Ignore adding the same word
                        if (ch == currentChar) {
                            continue;
                        }
                        // Check current modified string and desitnation is same
                        if (tmpString.equals(endWord)) {
                            return ladderLength + 1;
                        }

                        // Push into Queue for next level proccesing
                        if (wordSet.contains(tmpString)) {
                            wordQueue.add(tmpString);
                            wordSet.remove(tmpString);
                        }
                        charArray[j] = currentChar;
                    }
                }
            }
            ladderLength++;
        }

        return 0;

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<Integer, List<String>> wordListPath = new HashMap<>();

        Queue<String> wordQueue = new LinkedList<>();

        // Base condition
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 0;
        }

        // Add the begin word into Queue
        wordQueue.add(beginWord);
        int ladderLength = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                // Take out the word from queue
                String currentString = wordQueue.poll();
                for (String str : wordList) {

                    if (currentString.equals(endWord)) {
                        return ladderLength;
                    }
                    if (wordSet.contains(str) && findDiff(currentString, str)) {
                        if (wordListPath.containsKey(ladderLength)) {
                            List<String> tmpList = wordListPath.get(ladderLength);
                            tmpList.add(str);
                            wordListPath.put(ladderLength, tmpList);
                        } else {
                            List<String> tmpList = new ArrayList<String>();
                            tmpList.add(str);
                            wordListPath.put(ladderLength, tmpList);
                        }
                        System.out.println(str);
                        wordQueue.add(str);
                        wordSet.remove(str);
                    }

                }
            }
            ladderLength++;
        }

        return 0;

    }

    private boolean findDiff(String currentString, String possoibleString) {
        int count = 0;
        for (int i = 0; i < currentString.length(); i++) {
            if (currentString.charAt(i) != possoibleString.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;

    }

    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEnd;

        TrieNode() {
            map = new HashMap<>();
            isEnd = false;
        }
    }

    private class Trie {

        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                cur.map.putIfAbsent(ch, new TrieNode());
                cur = cur.map.get(ch);
            }
            cur.isEnd = true;
        }

        boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    return false;
                }
                cur = cur.map.get(ch);
            }

            return cur.isEnd;
        }
    }

    public int ladderLength_Parin(String beginWord, String endWord, List<String> wordList) {
        Trie t = new Trie();
        for (String word : wordList) {
            t.addWord(word);
        }

        if (!t.search(endWord)) {
            return 0;
        }

        int dist = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            for (int b = q.size(); b > 0; b--) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return dist;
                }
                char[] arr = cur.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != orig) {
                            arr[i] = c;
                            String next = new String(arr);
                            if (!visited.contains(next) && t.search(next)) {
                                visited.add(next);
                                q.add(next);
                            }
                        }
                    }
                    arr[i] = orig;
                }
            }

            ++dist;
        }

        return 0;

    }

    public int ladderLengthAlt(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty())
            return 0;

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return biBfs(beginSet, endSet, wordSet, 1);
    }

    public int biBfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int length) {
        if (beginSet.size() == 0 || endSet.size() == 0)
            return 0;

        if (beginSet.size() > endSet.size())
            return biBfs(endSet, beginSet, wordSet, length);

        Set<String> nextSeq = new HashSet<>();
        wordSet.removeAll(beginSet);

        for (String word : beginSet) {
            char[] charSet = word.toCharArray();
            for (int i = 0; i < charSet.length; i++) {
                char ch = charSet[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charSet[i] = j;
                    String newWord = new String(charSet);
                    if (wordSet.contains(newWord)) {
                        if (endSet.contains(newWord))
                            return length + 1;
                        nextSeq.add(newWord);
                    }
                }
                charSet[i] = ch;
            }
        }
        if (!nextSeq.isEmpty())
            return biBfs(nextSeq, endSet, wordSet, length + 1);
        return 0;
    }

    public static void main(String[] args) {
        LC127WordLadder obj = new LC127WordLadder();
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        // String[] words = { "hot", "dog" };

        List<String> wordList = Arrays.asList(words);

        String beginWord = "hit";
        String endWord = "cog";
        // String endWord = "dog";
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));

    }

}
