package linkedlist;

import java.util.ArrayList;
import java.util.List;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        BuildLinkedList linkedList = new BuildLinkedList();

        ListNode head = linkedList.buildList(list);
        // printList(head);

        findMiddleElement(head);

    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static void findMiddleElement(ListNode node) {
        ListNode slowPtr = node;
        ListNode fastPtr = node;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

        }
        System.out.println("Middle Node : " + slowPtr.val);

    }

    /*
     * Other two approaches
     * 
     * Two Parase
     * 
     * Find the lenght of the Linked List and traversal traverse middle and rerutn
     * 
     *
     * 
     * // Single Pass but O(n) space Traverse and put into list or array get the
     * middle element
     * 
     */
}
