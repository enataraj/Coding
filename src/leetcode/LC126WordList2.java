package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC126WordList2 {
    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<Integer, List<String>> wordListPath = new HashMap<>();

        Queue<String> wordQueue = new LinkedList<>();

        // Base condition
        if (!wordSet.contains(endWord)) {
            return Collections.EMPTY_LIST;
        }
        if (beginWord.equals(endWord)) {
            return Collections.EMPTY_LIST;
        }

        // Add the begin word into Queue
        wordQueue.add(beginWord);
        List<String> tmpList = new ArrayList<>();
        tmpList.add(beginWord);
        wordListPath.put(0, tmpList);
        int ladderLength = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                // Take out the word from queue
                String currentString = wordQueue.poll();
                for (String str : wordList) {

                    if (currentString.equals(endWord)) {
                        System.out.println(wordListPath);
                        return Collections.EMPTY_LIST;
                    }
                    if (wordSet.contains(str) && findDiff(currentString, str)) {
                        if (wordListPath.containsKey(ladderLength)) {
                            tmpList = wordListPath.get(ladderLength);
                            tmpList.add(str);
                            wordListPath.put(ladderLength, tmpList);
                        } else {
                            tmpList = new ArrayList<String>();
                            tmpList.add(str);
                            wordListPath.put(ladderLength, tmpList);
                        }
                        wordQueue.add(str);
                        wordSet.remove(str);
                    }

                }
            }
            ladderLength++;
        }

        return Collections.EMPTY_LIST;

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

    public static void main(String[] args) {
        LC126WordList2 obj = new LC126WordList2();
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        List<String> wordList = Arrays.asList(words);
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(obj.ladderLength(beginWord, endWord, wordList));

    }

}
