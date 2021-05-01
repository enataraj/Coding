package leetcode.april;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC19RemoveNthNodeFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node1 = head;
        ListNode node2 = head;
        while (n != 1) {
            node1 = node1.next;
            n = n - 1;
        }
        ListNode pre = null;
        while (node1.next != null) {
            node1 = node1.next;
            pre = node2;
            node2 = node2.next;
        }

        if (pre == null) {
            head = head.next;
            return head;
        }
        pre.next = node2.next;
        return head;

    }

    public static void main(String[] args) {
        LC19RemoveNthNodeFromList obj = new LC19RemoveNthNodeFromList();
        int[] nums = { 1 };
        ListNode head = BuildLinkedList.buildList(nums);

        BuildLinkedList.printListNode(obj.removeNthFromEnd(head, 1));
        System.out.println();

    }

}
