package tree;

import java.util.Stack;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class DFSTreeTraversalWithStack {

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }

    }
    
    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBalancedBinaryTree();
        DFSTreeTraversalWithStack obj = new DFSTreeTraversalWithStack();
        obj.inorder(root);
    }

}
