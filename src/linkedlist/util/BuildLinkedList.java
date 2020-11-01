package linkedlist.util;

import java.util.List;

public class BuildLinkedList {

    public static ListNode buildList(List<Integer> numbers) {
        ListNode head = new ListNode(numbers.get(0));
        ListNode currentListNode = head;

        for (int i = 1; i < numbers.size(); i++) {
            ListNode ListNode = new ListNode(numbers.get(i));
            currentListNode.next = ListNode;
            currentListNode = currentListNode.next;

        }
        return head;
    }

    public static ListNode buildList(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode currentListNode = head;

        for (int i = 1; i < numbers.length; i++) {
            ListNode ListNode = new ListNode(numbers[i]);
            currentListNode.next = ListNode;
            currentListNode = currentListNode.next;

        }
        return head;
    }
    
    public static ListNode buildListWithLoop() {
        ListNode head = new ListNode(10);
        
        ListNode node = head;
        node.next = new ListNode(11); 
        node.next.next = new ListNode(12); 
        node.next.next.next = new ListNode(13); 
        node.next.next.next.next = new ListNode(14); 
        node.next.next.next.next.next =node.next; 
        
        return head;
        
    }

    public static void printListNode(ListNode head) {

        ListNode node = head;
        while (node != null) {
            System.out.print("  " + node.val);
            node = node.next;
        }
    }

}
