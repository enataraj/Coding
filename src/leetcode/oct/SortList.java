package leetcode.oct;

import linkedlist.util.ListNode;

public class SortList {
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode sortedHead = sortList(head);
        ListNode sortedSecond = sortList(second);
        return merge(sortedHead, sortedSecond);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }

}
