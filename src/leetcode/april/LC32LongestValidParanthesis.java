package leetcode.april;

import java.util.Stack;

public class LC32LongestValidParanthesis {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && charArray[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }

        }

        int result = 0;
        int end = s.length();

        while (!stack.empty()) {
            int start = stack.pop();
            result = Math.max(result, end - start - 1);
            end = start;
        }

        return Math.max(end, result);

    }

    /*
     * ((( (())))
     * (((()((()
     * 
     */

    public int longestValidParenthesesSol2(String s) {

        int left = 0, right = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        LC32LongestValidParanthesis obj = new LC32LongestValidParanthesis();

        String s = "()(()";
        System.out.println(obj.longestValidParentheses(s));
    }

}
