package leetcode.dec;

import java.util.Comparator;
import java.util.PriorityQueue;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC23MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        ListNode node = dummyNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                }
                return -1;
            }

        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }

        while (queue.size() > 1) {
            ListNode tmpNode = queue.poll();
            node.next = tmpNode;
            node = node.next;
            if (tmpNode.next != null) {
                queue.add(tmpNode.next);
            }
        }
        node.next = queue.poll();
        return dummyNode.next;
    }

    public static void main(String[] args) {
        LC23MergeKSortedList obj = new LC23MergeKSortedList();
        int[] numbers = { 2, 5, 7, 8 };
        ListNode head1 = BuildLinkedList.buildList(numbers);
        int[] numbers1 = { 1, 6, 7, 8 };
        ListNode head2 = BuildLinkedList.buildList(numbers1);
        int[] numbers3 = { 10, 200, 200 };
        ListNode head3 = BuildLinkedList.buildList(numbers3);
        ListNode head4 = null;
        
        ListNode[] lists = { head1, head2, head3,head4 };
        ListNode head = obj.mergeKLists(lists);
        BuildLinkedList.printListNode(head);

    }

}
