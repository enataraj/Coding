package leetcode.june;

import java.util.Stack;

public class LC1047RemoveAllAdjacent {
   
    
    public String removeDuplicatessol(String s) {
        char [] charArr = s.toCharArray();
        int end = -1;
        for (char c: charArr) {
            if (end >= 0 && charArr[end] == c){
                --end;
            } else {
                charArr[++end] = c;
            }
        }
    return String.valueOf(charArr, 0, end+1);
    }

    public String removeDuplicatesAlt(String S) {
        StringBuffer buffer = new StringBuffer();
        for (char ch : S.toCharArray()) {
            if (buffer.length() != 0 && buffer.charAt(buffer.length() - 1) == ch) {
                buffer.deleteCharAt(buffer.length() - 1);
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

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

    public static void main(String[] args) {
        LC1047RemoveAllAdjacent obj = new LC1047RemoveAllAdjacent();
    }

}
