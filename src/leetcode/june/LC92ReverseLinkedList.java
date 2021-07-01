package leetcode.june;

import java.util.Stack;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC92ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //first part
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for (int i = 0; i < left; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        //reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode q2;
        for (int i = left; i <= right; i++) {
            q2 = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = q2;
        }

        //connect 
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

    public ListNode reverseBetweenNotSinglePass(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = head;
        ListNode firstNode = node;
        int cnt = 1;
        while (cnt != left) {
            firstNode = node;
            node = node.next;
            cnt++;
        }

        Stack<ListNode> stack = new Stack<>();

        while (cnt != right) {
            stack.push(node);
            node = node.next;
            cnt++;
        }
        stack.push(node);
        ListNode nextNode = node.next;
        if (left == 1) {
            dummyNode.next = stack.peek();
            firstNode = stack.peek();
        }

        while (!stack.isEmpty()) {
            firstNode.next = stack.pop();
            firstNode = firstNode.next;

        }
        firstNode.next = nextNode;
        return dummyNode.next;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val;
     * ListNode next; ListNode() {} ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }

            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode node = head;
            ListNode firstNode = node;
            int cnt = 1;
            while (cnt != left) {
                firstNode = node;
                node = node.next;
                cnt++;
            }
            Stack<ListNode> stack = new Stack<>();
            while (cnt != right) {
                stack.push(node);
                node = node.next;
                cnt++;
            }
            stack.push(node);
            ListNode nextNode = node.next;
            if (left == 1) {
                dummyNode.next = stack.peek();
                firstNode = stack.peek();
            }

            while (!stack.isEmpty()) {
                firstNode.next = stack.pop();
                firstNode = firstNode.next;

            }
            firstNode.next = nextNode;
            return dummyNode.next;
        }
    }

    public static void main(String[] args) {
        LC92ReverseLinkedList obj = new LC92ReverseLinkedList();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        // int[] nums = { 1, 2, 3, 4, 5, 6 };
        ListNode head = BuildLinkedList.buildList(nums);
        head = obj.reverseBetween(head, 2, 4);

        BuildLinkedList.printListNode(head);
    }

}
