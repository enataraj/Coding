package leetcode.july;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.util.TreeNode;

public class MaxWidthOfBinaryTree {
    
    private class Node {
        int nodeIdx;
        TreeNode tNode;
        Node(TreeNode tNode, int nodeIdx) {
            this.tNode = tNode;
            this.nodeIdx = nodeIdx;
        }
    }
    

    public int widthOfBinaryTree_Mine(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode node = root;
        int leftHeight = 0;

        while (node.left != null) {
            leftHeight++;
            node = node.left;

        }

        int rightHeight = 0;
        node = root;
        while (node.right != null) {
            rightHeight++;
            node = node.right;

        }

        int height = Math.min(leftHeight, rightHeight);
        System.out.println(height);
        return (int) Math.pow(2, height);

    }
    
    
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        
        while (!q.isEmpty()) {
            int firstNodeIdx = -1,
                lastNodeIdx = -1;
            
            for (int b = q.size(); b > 0; b--) {
                Node cur = q.poll();
                if (firstNodeIdx == -1) {
                    firstNodeIdx = cur.nodeIdx;
                }
                
                lastNodeIdx = cur.nodeIdx;
                
                if (cur.tNode.left != null) {
                    q.add(new Node(cur.tNode.left, 2*cur.nodeIdx + 1));
                }
                
                if (cur.tNode.right != null) {
                    q.add(new Node(cur.tNode.right, 2*cur.nodeIdx + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, lastNodeIdx - firstNodeIdx + 1);
        }
        
        return maxWidth;
    }
    
    
    private int max = 1;
    public int widthOfBinaryTree_Optimized(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new LinkedList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        if (level == list.size()) list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(16);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        MaxWidthOfBinaryTree obj = new MaxWidthOfBinaryTree();
        int num = obj.widthOfBinaryTree(root);
        System.out.println("Width : " + num);
    }

}
