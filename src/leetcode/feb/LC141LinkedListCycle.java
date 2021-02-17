package leetcode.feb;

import java.util.ArrayList;
import java.util.List;

import linkedlist.util.ListNode;

public class LC141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }

        return false;

    }

    
    public boolean hasCycleSol(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){return true;}
        }
     return false;   
    }
    
    
    public boolean hasCycleSol2(ListNode head) {
        if (head == null) {
            return false;
        }
        List<ListNode> previousNodes = new ArrayList<>();
        ListNode temp = head;
        while (temp.next != null) {
            previousNodes.add(temp);
            if (previousNodes.contains(temp.next)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        LC141LinkedListCycle obj = new LC141LinkedListCycle();
    }

}
