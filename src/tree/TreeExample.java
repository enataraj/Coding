package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class TreeExample {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        System.out.println("Print Tree : ");
        TreeUtil.printBinaryTreeInorder(root);
        System.out.println();
        
        System.out.println("Print In Order : ");
        TreeUtil.inOrderTraversal(root);
        System.out.println();
        
        System.out.println("Print Pre Order : ");
        TreeUtil.preOrderTraversal(root);
        System.out.println();
        
        System.out.println("Print Post Order : ");
        TreeUtil.postOrderTraversal(root);
        System.out.println();
        
        root=TreeUtil.invertBinaryTree(root);
        System.out.println("Invenrt Tree  :");
        TreeUtil.printBinaryTreeInorder(root);
        System.out.println();
        
       
    }

}
