package leetcode;

public class SearchInBST {
    public TreeNode1 searchBST(TreeNode1 root, int val) {

        while (root != null) {

            if (root == null || root.val == val) {
                return root;
            }
            if (root.val < val) {
                root = root.right;

            } else if (root.val > val) {
                root = root.left;
            }

        }
        return null;

    }

    public TreeNode1 searchBSTRecursive(TreeNode1 root, int val) {


        if (root == null || root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBSTRecursive(root.right, val);
        } else {
            return searchBSTRecursive(root.left, val);
        }

    }

}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
