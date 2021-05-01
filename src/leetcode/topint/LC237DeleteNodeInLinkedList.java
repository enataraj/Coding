package leetcode.topint;

import linkedlist.util.ListNode;

public class LC237DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
