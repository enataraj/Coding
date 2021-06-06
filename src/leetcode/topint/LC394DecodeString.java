package leetcode.topint;

import java.util.Stack;

public class LC394DecodeString {

    public String decodeString(String s) {
        StringBuffer resultString = new StringBuffer();
        int i = 0;
        Stack<String> stack = new Stack<>();

        while (i < s.length()) {

            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i) + "");
            } else {

                // Getting Inner String
                StringBuffer str = new StringBuffer();
                while (!stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }
                stack.pop();

                StringBuffer tmpStr = new StringBuffer(str);
                // Getting Digit multiplier
                StringBuffer digitStr = new StringBuffer();
                while (!stack.isEmpty() && isDigit(stack.peek())) {
                    digitStr.insert(0, stack.pop());

                }

                if (digitStr.length() != 0) {
                    int num = Integer.parseInt(digitStr.toString());
                    for (int j = 1; j < num; j++) {
                        tmpStr.append(str);
                    }

                }
                stack.push(tmpStr.toString());
            }
            i++;
        }

        while (!stack.isEmpty()) {
            resultString.insert(0, stack.pop());
        }

        return resultString.toString();

    }

    private boolean isDigit(String str) {
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return true;
        }
        return false;
    }

    public String decodeStringSol(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                index.push(count);
                stack.push(tmp);
                tmp = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder tmp1 = tmp;
                tmp = stack.pop();
                for (int j = index.pop(); j > 0; j--) {
                    tmp = tmp.append(tmp1);
                }
            } else {
                tmp.append(c);
            }
        }
        return new String(tmp);
    }

}
