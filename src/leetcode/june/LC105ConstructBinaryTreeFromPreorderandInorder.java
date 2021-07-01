package leetcode.june;

import tree.util.TreeNode;

public class LC105ConstructBinaryTreeFromPreorderandInorder {
    
    
    private int inoderIdx = 0;
    private int preoderIdx = 0;
    
    public TreeNode buildTreeSol2(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (preoderIdx >= preorder.length) return null;
        if (inorder[inoderIdx] == stop) {
            inoderIdx=inoderIdx+1;
            return null;
        }
        TreeNode node = new TreeNode(preorder[preoderIdx++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;        
    }
    
    
    

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = dfsHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
        return root;

    }

    private TreeNode dfsHelper(int[] preorder, int preOrderStartIdx, int preOrderEndIdx, int[] inorder,
            int inoderStartIdx, int inoderEndIdx) {
        if (inoderStartIdx > inoderEndIdx) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preOrderStartIdx]);

        int inorderIdx = 0;

        for (int i = inoderStartIdx; i <= inorder.length; i++) {
            if (inorder[i] == preorder[preOrderStartIdx]) {
                inorderIdx = i;
                break;
            }
        }

        root.left = dfsHelper(preorder, preOrderStartIdx + 1, preOrderStartIdx + inorderIdx, inorder, inoderStartIdx,
                inoderStartIdx + inorderIdx - 1);
        root.right = dfsHelper(preorder, preOrderStartIdx + 1 + inorderIdx, preOrderEndIdx, inorder,
                inoderStartIdx + inorderIdx + 1, inoderEndIdx);
        return root;

    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inS, int inE, int preS, int preE) {

        if (inS > inE)
            return null;

        int rootData = preorder[preS];
        int rootIndex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int linS = inS;
        int linE = rootIndex - 1;
        int lpreS = preS + 1;
        int lpreE = linE - linS + lpreS;

        int rinS = rootIndex + 1;
        int rinE = inE;
        int rpreS = lpreE + 1;
        int rpreE = preE;

        TreeNode root = new TreeNode(rootData);
        root.left = buildTreeHelper(preorder, inorder, linS, linE, lpreS, lpreE);
        root.right = buildTreeHelper(preorder, inorder, rinS, rinE, rpreS, rpreE);

        return root;
    }

    public TreeNode buildTreeSol(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTreeHelper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        LC105ConstructBinaryTreeFromPreorderandInorder obj = new LC105ConstructBinaryTreeFromPreorderandInorder();

    }

}
