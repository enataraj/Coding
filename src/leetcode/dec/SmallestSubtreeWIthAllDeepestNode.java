package leetcode.dec;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class SmallestSubtreeWIthAllDeepestNode {

    TreeNode newRoot = null;
    int maxDepth = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return root;
        postOrderDFSHelpher(root, 0);
        return newRoot;
    }

    private int postOrderDFSHelpher(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int leftDepth = postOrderDFSHelpher(node.left, depth + 1);
        int rightDepth = postOrderDFSHelpher(node.right, depth + 1);
        if (leftDepth == rightDepth) {
            maxDepth = Math.max(maxDepth, leftDepth);
            if (maxDepth == leftDepth) {
                newRoot = node;
            }

        }
        return Math.max(leftDepth, rightDepth);

    }
    
    
    TreeNode ans;
   
    int minHeight = Integer.MAX_VALUE;
    public TreeNode subtreeWithAllDeepest1(TreeNode root) {
        if (root == null) return null;
        getDepth(root, 0);
        return ans;
    }
    private int getDepth(TreeNode root, int height) {
        if (root == null) return 0;
        int left = getDepth(root.left, height + 1);
        int right = getDepth(root.right, height + 1);
        if (left == right) {
            if (height + left > maxDepth) {
                maxDepth = height + left;
                minHeight = height;
                ans = root;
            } else if (height + left == maxDepth) {
                if (height < minHeight) {
                    ans = root;
                    minHeight = height;
                }
            }
        }
        return Math.max(left , right) + 1;
    }

    public static void main(String[] args) {
        SmallestSubtreeWIthAllDeepestNode obj = new SmallestSubtreeWIthAllDeepestNode();
        TreeNode root = TreeUtil.constructBinaryTreeForSmallestSubtree();
        System.out.println(obj.subtreeWithAllDeepest(root));

    }

}
