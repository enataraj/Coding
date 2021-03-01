package leetcode.feb;

import java.util.Stack;

public class LC856ScoreOfParenthesis {

    public int scoreOfParentheses(String S) {
        int res = 0;
        Stack<String> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                if (stack.peek() == "(") {
                    stack.pop();
                    stack.push("1");

                } else {
                    int tmp = 0;
                    while (stack.peek() != "(") {
                        tmp += Integer.parseInt(stack.pop()) * 2;

                    }
                    stack.pop();
                    stack.push(tmp + "");
                }
            } else {
                stack.push("(");
            }

            // System.out.println(stack);
        }

        while (!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }

        return res;

    }

    public int scoreOfParenthesesSol1(String S) {

        Stack<Integer> results = new Stack<>();
        int out = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                results.push(out);
                out = 0;
            } else {
                out = results.pop() + Math.max(out * 2, 1);
            }
        }
        return out;
    }

    // Recursive sol

    public int scoreOfParenthesesSol(String S) {
        return F(S, 0, S.length());
    }

    public int F(String S, int i, int j) {
        // Score of balanced string S[i:j]
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += S.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1)
                    ans++;
                else
                    ans += 2 * F(S, i + 1, k);
                i = k + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LC856ScoreOfParenthesis obj = new LC856ScoreOfParenthesis();
        // System.out.println(obj.scoreOfParentheses("(()(()))"));
        System.out.println(obj.scoreOfParentheses("()((()(()(()))()()))"));
    }

}
