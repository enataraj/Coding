package leetcode.feb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(S);

        for (int i = 0; i < S.length(); i++) {
            int size = queue.size();
            if (Character.isAlphabetic(S.charAt(i))) {
                for (int j = 0; j < size; j++) {
                    StringBuffer str = new StringBuffer(queue.poll());
                    char ch = str.charAt(i);
                    str.setCharAt(i, Character.toUpperCase(ch));
                    queue.add(str.toString());
                    str.setCharAt(i, Character.toLowerCase(ch));
                    queue.add(str.toString());
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    public List<String> letterCasePermutationIterative(String S) {
        List<String> result = new ArrayList<>();
        result.add(S);
        for (int i = 0; i < S.length(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                StringBuffer str = new StringBuffer(result.get(j));
                char ch = str.charAt(i);
                if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
                    str.setCharAt(i, Character.toUpperCase(ch));
                    result.add(str.toString());
                }
                if (Character.isAlphabetic(ch) && Character.isUpperCase(ch)) {
                    str.setCharAt(i, Character.toLowerCase(ch));
                    result.add(str.toString());
                }

            }
        }
        return result;
    }

    public List<String> letterCasePermutationBFS(String S) {
        List<String> result = new ArrayList<>();
        Set<String> tmpSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(S);
        tmpSet.add(S);

        while (!queue.isEmpty()) {

            StringBuffer str = new StringBuffer(queue.poll());

            for (int idx = 0; idx < S.length(); idx++) {
                char ch = str.charAt(idx);
                if (Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
                    str.setCharAt(idx, Character.toUpperCase(ch));
                    String tmpString = str.toString();
                    if (!tmpSet.contains(tmpString)) {
                        tmpSet.add(tmpString);
                        queue.add(tmpString);
                    }
                } else if (Character.isAlphabetic(ch) && Character.isUpperCase(ch)) {
                    str.setCharAt(idx, Character.toLowerCase(ch));
                    String tmpString = str.toString();
                    if (!tmpSet.contains(tmpString)) {
                        tmpSet.add(tmpString);
                        queue.add(tmpString);
                    }
                }

            }
        }

        for (String str : tmpSet) {
            result.add(str);
        }

        return result;

    }

    public List<String> letterCasePermutationDFS(String S) {
        List<String> list = new LinkedList<>();
        dfsHelpher(S.toCharArray(), 0, list);
        return list;
    }

    private void dfsHelpher(char[] charArray, int pos, List<String> list) {
        if (pos == charArray.length) {
            list.add(new String(charArray));
            return;
        }

        if (charArray[pos] >= '0' && charArray[pos] <= '9') {
            dfsHelpher(charArray, pos + 1, list);
            return;
        }

        charArray[pos] = Character.toUpperCase(charArray[pos]);
        dfsHelpher(charArray, pos + 1, list);

        charArray[pos] = Character.toLowerCase(charArray[pos]);
        dfsHelpher(charArray, pos + 1, list);

    }

    public static void main(String[] args) {
        LC784LetterCasePermutation obj = new LC784LetterCasePermutation();
        System.out.println(obj.letterCasePermutationDFS("a1b2c3"));
    }

}
