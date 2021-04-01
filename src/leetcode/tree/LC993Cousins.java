package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC993Cousins {

    class CustomNode {
        TreeNode parentNode;
        TreeNode childNode;

        public CustomNode(TreeNode parentNode, TreeNode childNode) {
            this.parentNode = parentNode;
            this.childNode = childNode;
        }

        @Override
        public String toString() {

            return "Parent : " + parentNode.val + "  Child : " + childNode.val;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<CustomNode> queue = new LinkedList<>();
        queue.add(new CustomNode(new TreeNode(-1), root));

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xflag = false;
            boolean yflag = false;
            TreeNode xParent = null;
            TreeNode yParent = null;
            for (int i = 0; i < size; i++) {
                CustomNode node = queue.poll();

                if (node.childNode.val == x) {
                    xParent = node.parentNode;
                    xflag = true;
                }
                if (xflag && node.childNode.val == y && xParent != null && xParent.val != node.parentNode.val) {
                    return true;
                }

                if (node.childNode.val == y) {
                    yParent = node.parentNode;
                    yflag = true;
                }
                if (yflag && node.childNode.val == x && yParent != null && yParent.val != node.parentNode.val) {
                    return true;
                }

                if (node.childNode.left != null) {
                    queue.add(new CustomNode(node.childNode, node.childNode.left));
                }
                if (node.childNode.right != null) {
                    queue.add(new CustomNode(node.childNode, node.childNode.right));
                }
            }

        }

        return false;
    }

    public boolean isCousinsSol(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> q1 = new LinkedList<Integer>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            if (q1.contains(x) && q1.contains(y))
                return true;
            if (q1.contains(x))
                return false;
            if (q1.contains(y))
                return false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                q1.poll();
                // System.out.println("a");
                if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y)
                        || (node.left.val == y && node.right.val == x))) {
                    // System.out.println("a"); 
                    return false;
                }
                if (node.left != null) {
                    q.add(node.left);
                    q1.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    q1.add(node.right.val);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {

        LC993Cousins obj = new LC993Cousins();
        TreeNode root = TreeUtil.constructTreeForCousins();
        System.out.println(obj.isCousins(root, 4, 5));

    }

}
