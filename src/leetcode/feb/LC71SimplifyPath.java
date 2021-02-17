package leetcode.feb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC71SimplifyPath {
    public String simplifyPath(String path) {

        path = path.concat("/");

        Stack<Character> stack = new Stack();
        for (char ch : path.toCharArray()) {
            // Removing two //
            if (ch == '/' && !stack.isEmpty() && stack.peek() == '/') {
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '/') {
                int cnt = 0;
                while (!stack.isEmpty() && stack.peek() == '.') {
                    cnt++;
                    stack.pop();
                }

                if (cnt == 3) {
                    stack.push('.');
                    stack.push('.');
                    stack.push('.');
                    stack.push('/');
                }

                if (cnt == 2) {
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() != '/') {
                        stack.pop();

                    }
                    if(stack.isEmpty()) {
                        stack.push('/');
                    }
                }

            } else {
                stack.push(ch);
            }

           // System.out.println(stack);
        }

        if (!stack.isEmpty() && stack.peek() == '/') {
            stack.pop();
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuffer pathBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            pathBuffer.append(stack.pop());

        }

        return pathBuffer.reverse().toString();
    }
    
    public String simplifyPathSol(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token: path.split("/")) {
            // System.out.println(token);
            if (token.equals(".") || token.isEmpty()) {
                continue;
                
            } else if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                
            } else {
                stack.addLast(token);
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        
        return sb.length() == 0
            ? "/"
            : sb.toString();
    }

    public static void main(String[] args) {
        LC71SimplifyPath obj = new LC71SimplifyPath();
        // String path = "/home/";
        // String path = "/a/./b/../../c/";
        // String path = "/a/./b/";
        // String path = "/../";
        // String path = "/..hidden";

       // String path = "/a//b////c/d//././/..";
        // String path = "/...";
        String path = "/a/../../b/../c//.//";
        System.out.println(obj.simplifyPath(path));

    }

}
