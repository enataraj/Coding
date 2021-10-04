package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InOrderIterative {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);

    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;

    }
    
    
    class BSTIterator {
        private TreeNode tree;
        public BSTIterator(TreeNode root) {
            tree = root;
        }
        
        public int next() {
            TreeNode temp = tree;
            int val = -1;
            
            if (temp.left == null) {
                tree = tree.right;
                return temp.val;
            }
            
            while (temp.left.left != null) {
                temp = temp.left;
            }
            
            val = temp.left.val;
            temp.left = temp.left.right;
            
            return val;
        }
        
        public boolean hasNext() {
            return tree != null;
        }
    }

}
