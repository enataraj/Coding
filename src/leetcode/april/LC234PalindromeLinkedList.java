package leetcode.april;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode newHead = null;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null) {
                head = head.next;
                break;
            }
            fast = fast.next.next;

            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        while (newHead != null) {
            if (newHead.val != head.val)
                return false;
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LC234PalindromeLinkedList obj = new LC234PalindromeLinkedList();
        int[] nums = { 1, 1, 2, 1 };
        ListNode head = BuildLinkedList.buildList(nums);
        obj.isPalindrome(head);
    }

}
