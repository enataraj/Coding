package leetcode;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode resultNodeHead = new ListNode();
        ListNode node = null;
        int res, nodeVal, carry = 0;

        while (l1 != null && l2 != null) {
            if (node == null) {
                node = resultNodeHead;
            } else {
                node.next = new ListNode();
                node = node.next;
            }
            res = l1.val + l2.val + carry;
            nodeVal = res % 10;
            carry = res / 10;
            node.val = nodeVal;
            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {
            node.next = new ListNode();
            node = node.next;
            res = l1.val + carry;
            nodeVal = res % 10;
            carry = res / 10;
            node.val = nodeVal;
            l1 = l1.next;

        }
        while (l2 != null) {
            node.next = new ListNode();
            node = node.next;
            res = l2.val + carry;
            nodeVal = res % 10;
            carry = res / 10;
            node.val = nodeVal;
            l2 = l2.next;

        }

        if (carry != 0) {
            node.next = new ListNode();
            node=node.next;
            node.val = carry;
        }

        return resultNodeHead;

    }

    public static void main(String[] args) {

        AddTwoNumbersLinkedList obj = new AddTwoNumbersLinkedList();
     //   int[] nums1 = { 2, 4, 3, 6 };
     //   int[] nums2 = { 5, 6, 9 };

        int[] nums1= {5};
        int[] nums2= {5};
        ListNode l1 = BuildLinkedList.buildList(nums1);
        ListNode l2 = BuildLinkedList.buildList(nums2);

        ListNode resultNode = obj.addTwoNumbers(l1, l2);
        BuildLinkedList.printListNode(resultNode);

    }

}
