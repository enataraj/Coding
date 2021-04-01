package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;

public class LC872LeafSimilarTrees {

    private List<Integer> resultList1 = new ArrayList<>();
    private List<Integer> resultList2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        dfsHelpher(root1, true);
        dfsHelpher(root2, false);

        if (resultList1.size() != resultList2.size()) {
            return false;
        }
        for (int i = 0; i < resultList1.size(); i++) {
            if (resultList1.get(i) != resultList2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void dfsHelpher(TreeNode node, boolean first) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (first) {
                resultList1.add(node.val);
            } else {
                resultList2.add(node.val);
            }
        }
        dfsHelpher(node.left, first);
        dfsHelpher(node.right, first);
    }

    public static void main(String[] args) {
        LC872LeafSimilarTrees obj = new LC872LeafSimilarTrees();
    }

}
