package leetcode.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.util.TreeNode;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> resultList = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return resultList;
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if (node != null) {
					levelList.add(node.val);
					queue.add(node.left);
					queue.add(node.right);

				}
			}

			if (levelList.size() != 0) {
				resultList.add(0, levelList);
			}

		}

		return resultList;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = null;

		root.right.left = null;
		root.right.right = new TreeNode(5);

		LevelOrderTraversal obj = new LevelOrderTraversal();
		List<List<Integer>> res = obj.levelOrderBottom(root);
		System.out.println(res);

	}

}
