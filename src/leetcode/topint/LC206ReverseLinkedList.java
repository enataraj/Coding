package leetcode.topint;

import linkedlist.util.ListNode;

public class LC206ReverseLinkedList {
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

}
