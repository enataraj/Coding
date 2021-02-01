package leetcode.jan;

import java.util.HashMap;
import java.util.Map;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC82RemoveDuplicates2 {

    public ListNode deleteDuplicatesBF(ListNode head) {
        if (head == null) {
            return head;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        ListNode node = head;

        while (node != null) {
            if (freqMap.containsKey(node.val)) {
                freqMap.put(node.val, freqMap.get(node.val) + 1);
            } else {
                freqMap.put(node.val, 1);
            }
            node = node.next;
        }

        ListNode dummyNode = new ListNode(-101);
        node = dummyNode;
        ListNode runningNode = head;

        while (runningNode != null) {
            if (freqMap.get(runningNode.val) == 1) {
                node.next = runningNode;
                node = node.next;

            }
            runningNode = runningNode.next;
        }
        node.next = null;
        return dummyNode.next;

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-101);
        ListNode preNode = dummyNode;
        ListNode node = head;

        while (node != null && node.next != null) {
            if (node.val != node.next.val) {
                preNode.next = node;
                preNode = preNode.next;
                node = node.next;
            } else {
                int val = node.val;
                while (node != null && node.val == val) {
                    node = node.next;
                }
            }
        }

        if (node != null && node.next == null) {
            preNode.next = node;
            preNode = preNode.next;
        }

        preNode.next = null;

        return dummyNode.next;

    }

    public ListNode deleteDuplicatesParin(ListNode head) { // [1,2,3,3,4,4,5]
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), // 0
                iter = head, // 1
                resIter = dummy; // 0

        while (iter != null && iter.next != null) {
            if (iter.val != iter.next.val) {
                resIter.next = iter;
                resIter = resIter.next;
                iter = iter.next;

            } else {
                int dupeVal = iter.val;
                while (iter != null && iter.val == dupeVal) {
                    iter = iter.next;
                }
            }
        }

        if (iter != null && iter.next == null) {
            resIter.next = iter;
            resIter = resIter.next;
        }
        resIter.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        LC82RemoveDuplicates2 obj = new LC82RemoveDuplicates2();
        int[] nums = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 4 };
        ListNode head = BuildLinkedList.buildList(nums);
        head = obj.deleteDuplicates(head);
        BuildLinkedList.printListNode(head);

    }

}
