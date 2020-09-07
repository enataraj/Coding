package leetcode.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class ElementInTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> firstList = new ArrayList<Integer>();
        List<Integer> secondList = new ArrayList<Integer>();

        helper(root1, firstList);
        helper(root2, secondList);
        if (root1 == null) {
            return secondList;
        }
        if (root2 == null) {
            return firstList;
        }

        int i = 0;
        int j = 0;

        List<Integer> resultList = new ArrayList<>();
        while (i < firstList.size() && j < secondList.size()) {

            if (firstList.get(i) <= secondList.get(j)) {
                resultList.add(firstList.get(i));

                i++;

            } else {
                resultList.add(secondList.get(j));

                j++;
            }
        }

        while (i < firstList.size()) {
            resultList.add(firstList.get(i));
            i++;

        }

        while (j < secondList.size()) {
            resultList.add(secondList.get(j));
            j++;

        }

        return resultList;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }

    public static void main(String[] args) {

        ElementInTwoBST obj = new ElementInTwoBST();

        TreeNode root1 = TreeUtil.constructBinarySearchTree();
        TreeNode root2 = TreeUtil.constructBinarySearchTree1();
        System.out.println(obj.getAllElements(root1, root2));

    }

}
