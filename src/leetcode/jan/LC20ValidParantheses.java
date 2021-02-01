package leetcode.jan;

import java.util.Stack;

public class LC20ValidParantheses {

    public boolean isValidAlt1(String s) {

        char[] ch = new char[s.length()];
        int idx = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                ch[++idx] = c;
            } else if (c == ')') {
                if (idx == -1 || ch[idx--] != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (idx == -1 || ch[idx--] != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (idx == -1 || ch[idx--] != '{') {
                    return false;
                }
            }
        }
        if (idx != -1)
            return false;
        return true;

    }

    // (a())
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (stack.isEmpty() || ch == ')' && stack.pop() != '(' || ch == ']' && stack.pop() != '['
                    || ch == '}' && stack.pop() != '{') {
                return false;
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }

    public boolean isValidAlt(String s) {

        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            if (s.contains("{}")) {
                s=s.replace("{}", "");
            }

            if (s.contains("()")) {
                s=s.replace("()", "");
            }

            if (s.contains("[]")) {
                s=s.replace("[]", "");
            }
           // System.out.println(s);
            // {{{{}}}}
            //{{{}}}
            //{{}}
            //{}
            //""
            //n/2
            //n
        }

        if (s.length() == 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        LC20ValidParantheses obj = new LC20ValidParantheses();
        String s = "()[]{}";
         System.out.println(obj.isValid(s));
        System.out.println(obj.isValidAlt(s));
    }

}
