package leetcode.feb;

import java.util.Stack;

public class LC1249MiniParantheseToRemove {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;

        Stack<Data> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek().paranthese == '(') {
                    stack.pop();
                    continue;
                }
                stack.push(new Data(i, ch));
            } else if (ch == '(') {
                stack.push(new Data(i, ch));
            }

        }
        StringBuffer resultString = new StringBuffer(s);
        while (!stack.isEmpty()) {
            resultString.deleteCharAt(stack.pop().idx);
        }

        return resultString.toString();
    }

    private class Data {
        int idx;
        char paranthese;

        public Data(int idx, char paranthese) {
            this.idx = idx;
            this.paranthese = paranthese;
        }
    }

    public static void main(String[] args) {
        LC1249MiniParantheseToRemove obj = new LC1249MiniParantheseToRemove();
        System.out.println(obj.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(obj.minRemoveToMakeValid("))(("));
        System.out.println(obj.minRemoveToMakeValid("(a(b(c)d)"));
    }

}
