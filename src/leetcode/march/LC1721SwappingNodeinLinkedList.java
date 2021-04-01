package leetcode.march;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC1721SwappingNodeinLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        while (node != null && k > 1) {
            node = node.next;
            k = k - 1;
        }
        ListNode kthFrontNode = node;
        ListNode kthLastNode = head;
        while (node.next != null) {
            node = node.next;
            kthLastNode = kthLastNode.next;
        }
        int tmp = kthFrontNode.val;
        kthFrontNode.val = kthLastNode.val;
        kthLastNode.val = tmp;
        return head;
    }

    public static void main(String[] args) {
        LC1721SwappingNodeinLinkedList obj = new LC1721SwappingNodeinLinkedList();
        int[] nums = { 1, 2 };
        ListNode head = BuildLinkedList.buildList(nums);
        head = obj.swapNodes(head, 1);
        BuildLinkedList.printListNode(head);

       
    }

}
