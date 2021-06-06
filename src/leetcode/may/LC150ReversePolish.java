package leetcode.may;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC150ReversePolish {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operator = new HashSet<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        for (String str : tokens) {
            if (operator.contains(str)) {

                int num2 = stack.pop();
                int num1 = stack.pop();
                if (str.equals("+")) {
                    stack.push(num1 + num2);
                } else if (str.equals("-")) {
                    stack.push(num1 - num2);
                } else if (str.equals("*")) {
                    stack.push(num1 * num2);
                } else if (str.equals("/")) {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LC150ReversePolish obj = new LC150ReversePolish();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(obj.evalRPN(tokens));

    }

}
