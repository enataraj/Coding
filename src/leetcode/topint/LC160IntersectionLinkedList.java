package leetcode.topint;

import linkedlist.util.ListNode;

public class LC160IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB)
            return headA;
        ListNode first = headA;
        ListNode second = headB;
        while (first != null || second != null) {
            if (first == null) {
                first = headB;
            } else {
                first = first.next;
            }

            if (second == null) {
                second = headA;
            } else {
                second = second.next;
            }

            if (first == second)
                return first;
        }
        return null;

    }

}
