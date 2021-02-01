package leetcode.jan;

import tree.util.TreeNode;

public class LC1379BinaryTreeInCloneTree {
    TreeNode resultNode;
    boolean flag;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null || target == null) {
            return null;
        }

        dfsHelpher(original, cloned, target);

        return resultNode;
    }

    private void dfsHelpher(TreeNode node1, TreeNode node2, TreeNode target) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (flag) {
            return;
        }
        dfsHelpher(node1.left, node2.left, target);
        if (node1 == target) {
            resultNode = node2;
            flag = true;
        }
        dfsHelpher(node1.right, node2.right, target);

    }

    public final TreeNode getTargetCopySol(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return cloned;
        return dfs(original, cloned, target);
    }

    public TreeNode dfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target)
            return cloned;
        if (original.left != null) {
            TreeNode tmp = dfs(original.left, cloned.left, target);
            if (tmp != null)
                return tmp;
        }
        if (original.right != null) {
            TreeNode tmp = dfs(original.right, cloned.right, target);
            if (tmp != null)
                return tmp;
        }
        return null;
    }

    TreeNode ans = null;

    public final TreeNode getTargetCopyAlt (final TreeNode original, final TreeNode cloned, final TreeNode target) {
        find(original, cloned, target);
        return ans;
    }

    public void find(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null || ans != null)
            return;
        if (original == target) {
            ans = cloned;
            return;
        }
        find(original.left, cloned.left, target);
        find(original.right, cloned.right, target);
    }

    public static void main(String[] args) {
        LC1379BinaryTreeInCloneTree obj = new LC1379BinaryTreeInCloneTree();
        // TreeNode root = TreeUtil
    }
}
