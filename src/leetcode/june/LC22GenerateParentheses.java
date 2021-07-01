package leetcode.june;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC22GenerateParentheses {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        dfsHelper(list, 0, 0, n);
        return result;

    }

    private void dfsHelper(List<Character> chList, int openCnt, int closeCnt, int n) {
        if (openCnt == n && closeCnt == n) {
            char[] tmp = new char[2 * n];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = chList.get(i);
            }

            result.add(new String(tmp));
            return;
        }

        if (openCnt < n) {
            chList.add('(');
            dfsHelper(chList, openCnt + 1, closeCnt, n);
            chList.remove(chList.size() - 1);
        }
        if (closeCnt < openCnt) {
            chList.add(')');
            dfsHelper(chList, openCnt, closeCnt + 1, n);
            chList.remove(chList.size() - 1);
        }
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            helper(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
            if (open == n && close == n) {
                res.add(sb.toString());
                return;
            }

            if (open < n) {
                sb.append("(");
                helper(res, sb, open + 1, close, n);
                sb.setLength(sb.length() - 1);
            }
            if (close < open) {
                sb.append(")");
                helper(res, sb, open, close + 1, n);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    Set<String> permuationSet;

    public List<String> generateParenthesisTLE(int n) {
        permuationSet = new HashSet<>();
        char[] chArray = new char[2 * n];
        for (int i = 0; i < n; i++) {
            chArray[i] = '(';
        }
        for (int i = n; i < 2 * n; i++) {
            chArray[i] = ')';
        }
        generatePermution(chArray, 0, chArray.length - 1);
        List<String> result = new ArrayList<>();
        for (String str : permuationSet) {
            // if (isValid(str)) {
            result.add(str);
            // }
        }
        return result;

    }

    private void generatePermution(char[] charArray, int left, int right) {
        if (left == right) {
            permuationSet.add(new String(charArray));
            return;
        }
        for (int i = left; i <= right; i++) {

            swap(charArray, left, i);
            if (isValid(new String(charArray))) {
                generatePermution(charArray, left + 1, right);
            }
            swap(charArray, left, i);

        }

    }

    private void swap(char[] charArray, int left, int right) {
        char ch = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = ch;
    }

    public boolean isValid(String s) {

        char[] ch = new char[s.length()];
        int idx = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                ch[++idx] = c;
            } else if (c == ')') {
                if (idx == -1 || ch[idx--] != '(') {
                    return false;
                }
            }
        }
        if (idx != -1)
            return false;
        return true;

    }

    public static void main(String[] args) {
        LC22GenerateParentheses obj = new LC22GenerateParentheses();
        System.out.println(obj.generateParenthesis(8));
    }

}
