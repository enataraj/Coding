package leetcode.linkedlist;

import linkedlist.util.ListNode;

public class LC206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseListDFS(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseListDFS(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
