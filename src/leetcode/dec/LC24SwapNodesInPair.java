package leetcode.dec;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC24SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), iter = dummy;
        dummy.next = head;

        while (iter != null && iter.next != null && iter.next.next != null) {
            ListNode temp = iter.next, temp2 = iter.next.next;

            temp.next = temp2.next;
            temp2.next = temp;
            iter.next = temp2;
            iter = temp;
        }

        return dummy.next;
    }

    public ListNode swapPairs_Opt(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = swapPairs_Opt(head.next.next);
        ListNode temp = head.next;
        head.next = node;
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        LC24SwapNodesInPair obj = new LC24SwapNodesInPair();
        int numbers[] = { 1, 2, 3, 4 };
        ListNode head = BuildLinkedList.buildList(numbers);
        head = obj.swapPairs(head);
        BuildLinkedList.printListNode(head);
    }

}
