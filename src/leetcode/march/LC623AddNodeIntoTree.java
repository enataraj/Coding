package leetcode.march;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC623AddNodeIntoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            TreeNode oldRoot = root;
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = oldRoot;
            return newRoot;

        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int currentDepth = 1;

        while (!queue.isEmpty()) {
            currentDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (currentDepth == d) {

                    TreeNode leftNode = node.left;
                    TreeNode rightNode = node.right;
                    TreeNode newLeftNode = new TreeNode(v);
                    TreeNode newRightNode = new TreeNode(v);
                    node.left = newLeftNode;
                    newLeftNode.left = leftNode;
                    node.right = newRightNode;
                    newRightNode.right = rightNode;
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);

                    }
                }
            }
        }
        return root;

    }
    
    
    public TreeNode addOneRowdfs(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode a = new TreeNode(v);
            a.left = root;
            return a;
        }
        help(root , v , d);
        return root;
    }
    
    void help(TreeNode root , int v , int d){
        if(root == null){
            return ;
        }
        if(d-1 == 1){
            TreeNode a1 = new TreeNode(v);
            TreeNode a2 = new TreeNode(v);
            TreeNode  s = root.left;
            TreeNode s1 = root.right;
            root.left = a1;
            a1.left = s;
            root.right = a2;
            a2.right = s1;
            return ;
        }
        help(root.left  , v , d-1);
        help(root.right , v ,d-1);
    }

    public static void main(String[] args) {
        LC623AddNodeIntoTree obj = new LC623AddNodeIntoTree();
        TreeNode root = TreeUtil.constructBalancedBinaryTree();
        TreeUtil.printBinaryTreeInorder(root);
        root = obj.addOneRow(root, 12345, 4);
        System.out.println();
        TreeUtil.printBinaryTreeInorder(root);
    }

}
