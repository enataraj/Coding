package leetcode.nov;

import java.util.Stack;

public class DecodeString {
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

    private boolean isChar(String str) {
        if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
            return true;
        }
        return false;
    }

    String decodeString_Opt(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String s = "bc3[a2[cd]]";
        System.out.println(obj.decodeString(s));

    }

}
