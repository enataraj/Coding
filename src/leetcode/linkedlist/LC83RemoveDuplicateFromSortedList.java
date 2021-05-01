package leetcode.linkedlist;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC83RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return head;
    }

    public ListNode deleteDuplicatesSol(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LC83RemoveDuplicateFromSortedList obj = new LC83RemoveDuplicateFromSortedList();

        int[] nums = { 1, 1 };
        ListNode head = BuildLinkedList.buildList(nums);
        BuildLinkedList.printListNode(obj.deleteDuplicates(head));
    }

}
