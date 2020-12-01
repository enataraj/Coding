package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;

public class SymetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuffer str1 = new StringBuffer();
            StringBuffer str2 = new StringBuffer();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (i < size / 2) {
                    str1.append(node.val + "#");
                } else {
                    str2.append(node.val + "#");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.println(str1);
            System.out.println(str2);
            if (size%2==0 && !str1.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SymetricTree obj = new SymetricTree();
    }

}
