package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC897IncreasingSearchOrder {
    List<TreeNode> nodeList = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfsHelpher(root);

        TreeNode newRoot = nodeList.get(0);
        TreeNode node = newRoot;
        for (int i = 1; i < nodeList.size(); i++) {
            node.left = null;
            node.right = nodeList.get(i);
            node = node.right;
            System.out.println(node);
        }
        
        node.left = null;
        node.right = null;
        
        System.out.println(nodeList);
        return newRoot;
    }

    private void dfsHelpher(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsHelpher(node.left);
        nodeList.add(node);
        dfsHelpher(node.right);

    }
    
    
    public TreeNode increasingBSTParin(TreeNode root) {
        TreeNode[] res = helper(root);
        return res == null ? null : res[0];
    }
    
    private TreeNode[] helper(TreeNode root) {
        if (root == null) {
            return null;
            
        } else if (root.left == null && root.right == null) {
            return new TreeNode[]{root, root};
            
        }
        
        TreeNode[] res = new TreeNode[2],
            leftRes = helper(root.left),
            rightRes = helper(root.right);
        
        res[0] = root;
        res[1] = root;
        root.left = null;
        
        if (leftRes != null) {
            res[0] = leftRes[0];
            leftRes[1].right = root;
        }
        
        if (rightRes != null) {
            res[1] = rightRes[1];
            root.right = rightRes[0];
        }
        
        return res;
        
    }
    
    
public TreeNode increasingBSTStack(TreeNode root) {
        
        if (root == null){
            return null;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode prevNode = null;
        TreeNode head = null;
        
        while (!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            
            node = stack.pop();
               
            if (head == null){
                head = node;
            }
            
            if (prevNode != null){
                prevNode.right = node;
                node.left = null;
            }
            
            prevNode = node;
            node = node.right;
        }
        
        return head;
    }

    public static void main(String[] args) {
        LC897IncreasingSearchOrder obj = new LC897IncreasingSearchOrder();
        TreeNode root = TreeUtil.constructBinarySearchTreeIncrease();
        obj.increasingBST(root);
    }
}
