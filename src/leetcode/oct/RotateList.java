package leetcode.oct;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {  // Find the length of the Linked List
            node = node.next;
            length++;
        }
        k = k % length;  // if K is too larger reduce to required shift
        if (k == 0) {
            return head;
        }

        int move = length - k;
        node = head;
        ListNode preNode = null;
        while (move != 0) {  // Move length-k nodes in the list
            preNode = node;
            node = node.next;
            move--;
        }
        ListNode newHead = node;
        preNode.next = null;  // Break the list
        node = newHead;
        while (node.next != null) { // Mark second part of the list to first part and link with old list.
            node = node.next;

        }
        node.next = head;
        return newHead;

    }
    
    
    public ListNode rotateRightOpt(ListNode head, int k) 
    {
        ListNode a=head,b=head,c=head;
        int ctr=0;
        if(head==null || k==0)
            return head;
        while(c!=null)
        {
            ctr++;
            c=c.next;
        }
        k=k%ctr;
        while(k>0)
        {
            b=b.next;
            k--;
        }
        while(b.next!=null)
        {
            a=a.next;
            b=b.next;
        }
        b.next=head;
        head=a.next;
        a.next=null;
        return head;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        int[] numbers = { 1, 2, 3, 4, 5 };
        ListNode head = BuildLinkedList.buildList(numbers);
        BuildLinkedList.printListNode(head);
        head = obj.rotateRight(head, 4);
        BuildLinkedList.printListNode(head);
    }

}
