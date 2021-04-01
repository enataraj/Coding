package leetcode.march;

import tree.util.TreeNode;

public class BuildBinaryTreeFromString {
    
    public TreeNode str2tree(String s) { // "4(1)"
        // System.out.println(s);
        int n = s.length(); // 1
        if (n == 0) {
            return null;
        }
        
        int opening = 0, // 0
            leftStart = -1, // 1
            rightStart = -1, // -1
            idx = 0; // 4
        TreeNode root = null; // 4
        
        for (; idx < n; idx++) {
            char ch = s.charAt(idx); // '4'
            if (ch == '(') {
                ++opening;
                if (opening == 1) {
                    leftStart = idx;
                    int rootVal = Integer.parseInt(s.substring(0, idx));
                    root = new TreeNode(rootVal);
                }
                
            } else if (ch == ')') {
                --opening;
                if (opening == 0) {
                    ++idx;
                    break;
                }
            }
        }
        
        if (root == null) {
            int rootVal = Integer.parseInt(s);
            root = new TreeNode(rootVal);
            return root;
        }
        
        root.left = str2tree(s.substring(leftStart + 1, idx-1));
        
        for (; idx < n; idx++) {
            char ch = s.charAt(idx);
            if (ch == '(') {
                ++opening;
                if (opening == 1) {
                    rightStart = idx;
                    
                } else if (ch == ')') {
                    --opening;
                    if (opening == 0) {
                        break;
                    }
                }
            }
        }
        
        // System.out.println(leftStart + " " + rightStart);
        
        if (rightStart != -1) {
            root.right = str2tree(s.substring(rightStart + 1, idx-1));
        }
        
        return root;
    }

}
