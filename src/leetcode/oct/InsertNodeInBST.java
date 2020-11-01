package leetcode.oct;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InsertNodeInBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode currentNode = root;
        while (true) {

            if (currentNode.val > val) {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new TreeNode(val);
                    break;
                }

            } else {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public TreeNode insertIntoBSTDFS(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        dfsHelpher(root, val);

        return root;

    }

    private void dfsHelpher(TreeNode node, int val) {
      /*  if (node == null) {
            return;
        }*/

        if (node.val > val) {
            if (node.left != null) {
                dfsHelpher(node.left, val);
            } else {
                node.left = new TreeNode(val);
                return;

            }
        } else {
            if (node.right != null) {
                dfsHelpher(node.right, val);
            } else {
                node.right = new TreeNode(val);
                return;
            }
        }

    }
    
    
    public TreeNode insertIntoBSTDFSOptimized(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBSTDFSOptimized(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBSTDFSOptimized(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertNodeInBST obj = new InsertNodeInBST();
        TreeNode root = TreeUtil.constructBinarySearchTree1();
        TreeUtil.inOrderTraversal(root);
        obj.insertIntoBSTDFS(root, 8);
        System.out.println();
        TreeUtil.inOrderTraversal(root);

    }

}
