package leetcode.dec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC173BSTIterator {

    private int idx = 0;
    
    private List<Integer> values = new ArrayList<>();

    public LC173BSTIterator(TreeNode root) {
        dfsHelpher(root);
        System.out.println(values);

    }

    public int next() {
        int val = values.get(idx);
        idx++;
        return val;

    }

    public boolean hasNext() {
        if (idx + 1 <= values.size()) {
            return true;
        }
        return false;

    }

    private void dfsHelpher(TreeNode node) {
        if (node == null) {
            return;
        }

        dfsHelpher(node.left);
        values.add(node.val);
        dfsHelpher(node.right);

    }
    
    

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinarySearchTree();
        LC173BSTIterator obj = new LC173BSTIterator(root);
    }
    
    
    class BSTIterator1 {
        LinkedList<TreeNode>stack = new LinkedList<TreeNode>();
        
        public void traverse(TreeNode root){
            while(root.left != null){
                stack.add(root);
                root = root.left;
            }
            stack.add(root);
            
        }
        public BSTIterator1(TreeNode root) {
            traverse(root);
        }
        
        public int next() {
            TreeNode curr = stack.pollLast();
            if(curr.right != null){
                traverse(curr.right);
            }
            return curr.val;
        }
        
        public boolean hasNext() {
            if(stack.size() > 0){
                return true;
            }
            return false;
        }
    }

}
