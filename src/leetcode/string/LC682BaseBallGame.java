package leetcode.string;

import java.util.Stack;

public class LC682BaseBallGame {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String str : ops) {
            if (str.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                int sum = first + second;
                stack.push(first);
                stack.push(second);
                stack.push(sum);

            } else if (str.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (str.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }

        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }

    public static void main(String[] args) {
        LC682BaseBallGame obj = new LC682BaseBallGame();
        String[] ops = {"5","2","C","D","+"};
        
    }

}
