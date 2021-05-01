package leetcode.april;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC86PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode node1 = dummy1;
        ListNode node2 = dummy2;
        ListNode node = head;

        while (node != null) {
            if (node.val < x) {
                node1.next = node;
                node1 = node1.next;
                node2.next = null;

            } else {
                node2.next = node;
                node2 = node2.next;
                node1.next = null;
            }
            node = node.next;
        }
        node1.next = dummy2.next;
        return dummy1.next;

    }

    public ListNode partitionsol(ListNode head, int x) {
        ListNode lesserDummyNode = new ListNode(-1);
        ListNode lesserTailNode = lesserDummyNode;
        ListNode equalOrGreaterDummyNode = new ListNode(-1);
        equalOrGreaterDummyNode.next = head;
        ListNode prev = equalOrGreaterDummyNode;
        while (head != null) {
            if (head.val < x) {
                prev.next = head.next;
                lesserTailNode.next = head;
                head = prev.next;
                lesserTailNode = lesserTailNode.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        lesserTailNode.next = equalOrGreaterDummyNode.next;
        equalOrGreaterDummyNode.next = null;
        return lesserDummyNode.next;
    }

    public ListNode partitionSol2(ListNode head, int x) {
        ListNode smaller = new ListNode(0), greater = new ListNode(0);
        ListNode smallPtr = smaller, greatPtr = greater;
        while (head != null) {
            if (head.val < x) {
                smallPtr.next = head;
                smallPtr = smallPtr.next;
            } else {
                greatPtr.next = head;
                greatPtr = greatPtr.next;
            }
            head = head.next;
        }
        greatPtr.next = null;
        smallPtr.next = greater.next;
        return smaller.next;
    }

    public static void main(String[] args) {
        LC86PartitionList obj = new LC86PartitionList();
        int[] nums = { 7, 8, 9 };
        int x = 3;
        ListNode head = BuildLinkedList.buildList(nums);
        head = obj.partition(head, x);
        // BuildLinkedList.printListNode(head);
    }

}
