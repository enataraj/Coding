package leetcode.june;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class LC792NumberOfMatchingSubSequences {

    public int numMatchingSubseq(String s, String[] words) {
        Queue<String>[] queue = new LinkedList[26];

        for (int i = 0; i < 26; i++) { // Creating 26 Queue.
            queue[i] = new LinkedList<>();
        }

        for (String word : words) { // Putting the word into queue based on fist char idx.
            queue[word.charAt(0) - 'a'].add(word);
        }

        // Go over each char in source string, Get the words in queue , 
        // substing it based on first char and put back into queue. If the string lenth is 1 count into result.

        int result = 0;
        for (char ch : s.toCharArray()) {
            int size = queue[ch - 'a'].size();
            for (int i = 0; i < size; i++) {
                String str = queue[ch - 'a'].poll();
                if (str.length() == 1) {
                    result++;
                } else {
                    str = str.substring(1);
                    queue[str.charAt(0) - 'a'].add(str);
                }
            }
        }
        return result;
    }

    public int numMatchingSubseqBF(String s, String[] words) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            TreeSet<Integer> idxSet = map.getOrDefault(ch, new TreeSet<>());
            idxSet.add(i);
            map.put(ch, idxSet);
        }

        for (String str : words) {
            int curIdx = 0;
            boolean flag = true;
            for (char ch : str.toCharArray()) {
                if (!map.containsKey(ch)) {
                    flag = false;
                    break;
                }
                TreeSet<Integer> idxSet = map.get(ch);
                if (idxSet.ceiling(curIdx) == null) {
                    flag = false;
                    break;
                }
                curIdx = idxSet.ceiling(curIdx) + 1;

            }

            if (flag) {

                result++;
            }
        }
        return result;
    }

    public int numMatchingSubseqAlt(String s, String[] words) {
        int answer = 0;
        Deque<String>[] waiting = new ArrayDeque[26];
        for (int index = 0; index < 26; index++)
            waiting[index] = new ArrayDeque<String>();

        for (String word : words)
            waiting[word.charAt(0) - 'a'].addLast(word);

        for (char ch : s.toCharArray()) {
            int size = waiting[ch - 'a'].size();
            for (int index = 0; index < size; index++) {
                String str = waiting[ch - 'a'].pollFirst();
                if (str.length() == 1)
                    answer += 1;
                else
                    waiting[str.charAt(1) - 'a'].addLast(str.substring(1));
            }
        }
        return answer;
    }

    class Solution {

        class Word {
            char[] c;
            int index;

            public Word(String w) {
                this.c = w.toCharArray();
                this.index = 0;
            }
        }

        public int numMatchingSubseq(String s, String[] words) {

            Queue<Word>[] queue = new LinkedList[26];

            for (int i = 0; i < 26; i++)
                queue[i] = new LinkedList<>();

            for (String w : words) {
                int i = w.charAt(0) - 'a';
                queue[i].add(new Word(w));
            }

            int ans = 0;

            for (char c : s.toCharArray()) {
                int j = c - 'a';

                Queue<Word> q = queue[j];
                int size = q.size();
                for (int i = 0; i < size; i++) {

                    Word w = q.poll();
                    w.index++;

                    if (w.index == w.c.length)
                        ans++;
                    else
                        queue[w.c[w.index] - 'a'].offer(w);

                    //Max answer possible
                    if (ans == words.length)
                        return ans;

                }

            }

            return ans;

        }

        public int numMatchingSubseqBinarySearch(String s, String[] words) {

            Map<Character, List<Integer>> charMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);
                if (charMap.containsKey(c)) {
                    charMap.get(c).add(i);
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    charMap.put(c, l);
                }
            }

            int ans = 0;
            for (String word : words) {

                if (isSubsequence(word, charMap))
                    ans++;
            }

            return ans;
        }

        public boolean isSubsequence(String s, Map<Character, List<Integer>> map) {

            int prev = 0;
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if (!map.containsKey(c))
                    return false;

                List<Integer> charList = map.get(c);
                int j = Collections.binarySearch(charList, prev);
                if (j < 0)
                    j = -j - 1;

                if (j == charList.size())
                    return false;

                prev = charList.get(j) + 1;
            }

            return true;
        }

    }

    public static void main(String[] args) {
        LC792NumberOfMatchingSubSequences obj = new LC792NumberOfMatchingSubSequences();
        String s = "abcdez";
        String[] words = { "a", "bb", "acd", "ace", "zzzz" };
        // String[] words = {"zzzz"};
        System.out.println(obj.numMatchingSubseq(s, words));

    }

}
