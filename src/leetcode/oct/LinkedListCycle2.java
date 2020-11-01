package leetcode.oct;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LinkedListCycle2 {

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode slowPtr = head;
            ListNode fastPtr = null;
            if (head.next != null && head.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = head.next.next;
            } else {
                return null;
            }
    
            while (slowPtr != fastPtr) {
    
                if (fastPtr.next != null && fastPtr.next.next != null) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next.next;
    
                } else {
                    return null;
                }
            }
    
            slowPtr = head;
    
            while (slowPtr != fastPtr) {
               
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
    
            return slowPtr;
    
        }

    public static void main(String[] args) {
        LinkedListCycle2 obj = new LinkedListCycle2();

        ListNode head = BuildLinkedList.buildListWithLoop();
        ListNode loopNode = obj.detectCycle(head);
        if (loopNode == null) {
            System.out.println("No Loop");
        } else {
            System.out.println(loopNode.val);

        }

    }

}
