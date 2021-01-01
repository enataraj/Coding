package leetcode;

import java.util.Stack;

public class LC402RemoveKDigits {

    // In order to make smallest number, we need to remove all big numbers from left
    // side.
    // So on the movement from left to right keep see previous number is bigger than
    // current number keep remove it until to reach the K value 0;

    public String removeKdigits(String num, int k) {

        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }
            if (ch == '0' && stack.isEmpty()) {
                continue;
            } else {
                stack.push(ch);
            }
        }

        if (stack.size() <= k) {
            return "0";
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuffer buff = new StringBuffer();

        while (!stack.isEmpty()) {
            buff.append(stack.pop());
        }

        return buff.reverse().toString();

    }

    public String removeKdigitsSol(String num, int k) {

        int length = num.length(), top = 0, start = 0;

        if (k == length)
            return "0";
        char[] arr = num.toCharArray(), stack = new char[length];

        for (int i = 0; i < length; ++i) {

            while (k > 0 && top > 0 && stack[top - 1] > arr[i]) {

                top--;

                k--;

            }

            stack[top++] = arr[i];

        }

        while (k > 0) {

            top--;

            k--;
        }

        while (start < top && stack[start] == '0')
            start++;

        if (start == top)
            return "0";

        return new String(stack, start, top - start);

    }

    public static void main(String[] args) {
        LC402RemoveKDigits obj = new LC402RemoveKDigits();
        String num = "1124";
        int k = 1;

        System.out.println(obj.removeKdigits(num, k));
    }

}
