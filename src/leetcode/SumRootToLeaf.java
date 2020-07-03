package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeaf {

	// DFS Solution

	int result = 0;

	public int sumNumbersDFS(TreeNode root) {

		helper(root, 0);

		return result;

	}

	public void helper(TreeNode node, int partial) {
		if (node == null) {
			return;

		}

		partial *= 10;
		partial += node.val;
		if (node.left == null && node.right == null) {
			result += partial;

			return;
		}

		helper(node.left, partial);
		helper(node.right, partial);

	}

	// DFS without Global Variable

	public int sumNumbersWithoutGlobal(TreeNode root) {
		if (root == null)
			return 0;
		else
			return sumHelper(root, 0);
	}

	private int sumHelper(TreeNode node, int sumSoFar) {
		if (node.left == null && node.right == null)
			return sumSoFar * 10 + node.val;
		else {
			int leftSum = 0;
			int rightSum = 0;

			if (node.left != null)
				leftSum = sumHelper(node.left, sumSoFar * 10 + node.val);
			if (node.right != null)
				rightSum = sumHelper(node.right, sumSoFar * 10 + node.val);
			return leftSum + rightSum;
		}
	}

	// DFS with String

	int total = 0;

	public int sumNumbersString(TreeNode root) {
		if (root != null)
			helper(root, "");

		return total;
	}

	public void helper(TreeNode root, String current) {
		if (root == null)
			return;

		if (root != null && root.left == null && root.right == null) { // leaf
			System.out.println(current + (root.val + ""));
			total += Integer.parseInt(current + (root.val + ""));
			return;
		}

		helper(root.left, current + (root.val + ""));
		helper(root.right, current + (root.val + ""));
	}

	// BFS

	private class Data {
		TreeNode node;
		int partial;

		Data(TreeNode node, int partial) {
			this.node = node;
			this.partial = partial;
		}
	}

	public int sumNumbers(TreeNode root) {
		int ans = 0;
		if (root == null) {
			return ans;
		}

		Queue<Data> q = new LinkedList<>();
		q.add(new Data(root, 0));

		while (!q.isEmpty()) {
			Data cur = q.poll();
			int partial = cur.partial * 10 + cur.node.val;
			if (cur.node.left == null && cur.node.right == null) {
				ans += partial;
				continue;
			}

			if (cur.node.left != null) {
				q.add(new Data(cur.node.left, partial));
			}

			if (cur.node.right != null) {
				q.add(new Data(cur.node.right, partial));
			}
		}

		return ans;
	}

	public int sumNumbersMyVersion(TreeNode root) {
		int result = 0;
		if (root == null) {
			return 0;
		}
		preOrder(root, new StringBuilder());
		return result;
	}

	public void preOrder(TreeNode node, StringBuilder sb) {
		if (node == null) {
			return;
		}

		if (node!=null && node.left == null && node.right == null) {
			System.out.println(node.val);
			sb.append(node.val);
			System.out.println(sb.toString());
			return;

		}
		

		preOrder(node.left, sb.append(node.val));
		preOrder(node.right, sb.append(node.val));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		SumRootToLeaf obj = new SumRootToLeaf();

		int result = obj.sumNumbersMyVersion(root);
		System.out.println(result);

	}
	/*
	 * 1 2 3 4 5 6 7
	 * 
	 * 
	 * 
	 */
}
