package leetcode.sep2021;

import java.util.Stack;

public class LC1249MinimumRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {       
        char[] chArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == '(') {
                chArray[i] = '$';
                stack.push(i);
            } else if (!stack.isEmpty() && chArray[i] == ')') {
                chArray[stack.pop()] = '(';
            } else if (chArray[i] == ')') {
                chArray[i] = '$';
            }
        }
        return new String(chArray).replace("$", "");        
    }
}
