package leetcode.string;

import java.util.Stack;

public class LC1047RemoveAllAdjacentDuplicate {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.append(stack.pop());

        }
        return buffer.reverse().toString();
    }

    public String removeDuplicatesSol(String S) {
        char[] array = S.toCharArray();
        int top = -1;
        int i = 0;
        while (i < array.length) {
            if (top == -1 || array[top] != array[i]) {
                top++;
                array[top] = array[i];
                i++;
            } else {
                i++;
                top--;
            }
        }
        return new String(array, 0, top + 1);
    }

}
