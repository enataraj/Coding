package leetcode.april;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1209RemoveAllAdjacentDuplicateII {

    class Pair {
        char ch;
        int cnt;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != ch) {
                stack.push(new Pair(ch, 1));
            } else {

                if (!stack.isEmpty() && stack.peek().ch == ch) {
                    Pair pair = stack.pop();
                    pair.cnt = pair.cnt + 1;
                    if (pair.cnt != k) {
                        stack.push(pair);
                    }
                }
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            for (int i = 0; i < pair.cnt; i++) {
                strBuilder.append(pair.ch);
            }
        }
        return strBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        LC1209RemoveAllAdjacentDuplicateII obj = new LC1209RemoveAllAdjacentDuplicateII();
        System.out.println("Result : " + obj.removeDuplicates("abbcd", 2));

    }

}
