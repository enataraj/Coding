package leetcode.may;

import java.util.ArrayList;
import java.util.List;

import linkedlist.util.ListNode;

public class LC109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return dfsHelper(list, 0, list.size() - 1);

    }

    private TreeNode dfsHelper(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if (left == right) {
            return node;
        }
        node.left = dfsHelper(list, left, mid - 1);
        node.right = dfsHelper(list, mid + 1, right);
        return node;

    }

    public TreeNode sortedListToBSTSol3(ListNode head) {
        if (head == null)
            return null;
        ListNode s = head, f = head, p = null;
        while (f != null && f.next != null) {
            p = s;
            s = s.next;
            f = f.next.next;
        }
        if (p == null)
            return new TreeNode(s.val);
        else {
            p.next = null;
            return new TreeNode(s.val, sortedListToBST(head), sortedListToBST(s.next));
        }
    }

    private ListNode root;

    public TreeNode sortedListToBSTSol(ListNode head) {
        //use while loop to find len of list
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        this.root = head;
        return simulator(0, len - 1);

    }

    private TreeNode simulator(int start, int end) {
        //stop condition
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode left = simulator(start, mid - 1);
        TreeNode curRoot = new TreeNode(root.val);
        curRoot.left = left;
        root = root.next;
        curRoot.right = simulator(mid + 1, end);
        return curRoot;
    }

    public TreeNode sortedListToBSTSol2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode mid = findMid(head), right = mid.next;
        mid.next = null;

        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(right);
        return node;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = new ListNode(-1), slow = new ListNode(-1);
        fast.next = head;
        slow.next = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

}
