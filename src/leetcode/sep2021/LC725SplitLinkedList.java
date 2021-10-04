package leetcode.sep2021;

import java.util.Arrays;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC725SplitLinkedList {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }
        // Finding the Length
        ListNode node = head;
        int length = 1;
        while (node != null) {
            length++;
            node = node.next;
        }

        // Build a split length array.
        int[] splitLength = new int[k];
        int split = length / k;
        int bal = length - split * k;
        Arrays.fill(splitLength, split);
        int idx = 0;
        while (bal > 0) {
            splitLength[idx++] += 1;
            bal--;
        }

        node = head;
        int cnt = 0;
        ListNode prev = null;

        ListNode[] result = new ListNode[k];
        result[0] = node;
        idx = 1;
        // Traverse the List upto the required length by tracking the previous pointer.
        // Once reached required length marking previous pointer as null.
        while (node != null && idx < splitLength.length && splitLength[idx] > 0) {
            if (splitLength[idx] == cnt) {
                if (prev != null) {
                    prev.next = null;
                }
                result[idx] = node;
                cnt = 0;
                idx += 1;
            } else {
                cnt++;
                prev = node;
                node = node.next;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        LC725SplitLinkedList obj = new LC725SplitLinkedList();
        //  int k = 2;
        for (int k = 1; k < 6; k++) {
            int[] num = { 1, 2, 3, 4, 5, 6 };
            ListNode head = BuildLinkedList.buildList(num);

            ListNode[] result = obj.splitListToParts(head, k);

            System.out.println("Result : " + Arrays.toString(result));
        }

    }

}
