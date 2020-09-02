package leetcode.aug;

import java.util.Stack;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head != null) {
            ListNode node = head;

            ListNode slowPtr = node;
            ListNode fastPtr = node;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;

            }

            ListNode midNode = slowPtr;

            Stack<ListNode> stack = new Stack();
            while (midNode != null) {
                stack.add(midNode);
                midNode = midNode.next;

            }

            node = head;

            while (!stack.isEmpty()) {
                ListNode tmpNode = stack.pop();
                tmpNode.next = node.next;
                node.next = tmpNode;
                node = tmpNode.next;

            }
            node.next = null;

        }

    }
    
    
    public void reorderListOpt(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode preSlow = null,
            slow = head,
            fast = head;
        
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        preSlow.next = null;
        ListNode reversedSecondHalf = reverse(slow);
        ListNode resDummy = new ListNode(0),
            resIter = resDummy,
            iter1 = head,
            iter2 = reversedSecondHalf;
        
        while (iter1 != null && iter2 != null) {
            ListNode nextIter1 = iter1.next,
                    nextIter2 = iter2.next;
            
            resIter.next = iter1;
            iter1.next = iter2;
            resIter = iter2;
            iter1 = nextIter1;
            iter2 = nextIter2;
        }
        
        if (iter1 != null) {
            resIter.next = iter1;
        }
        
        head = resDummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null,
            cur = head,
            tempNext = head.next;
        
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = tempNext;
            if (tempNext != null) {
                tempNext = tempNext.next;
            }
        }
        
        return prev;
    }
    
    
    public void reorderListOpt1(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        // have two pointer slow and fast
        ListNode slow = head, fast = head.next.next;
        // once fast hit the end than take slow pointer + 1 and start adding in recursive backword manner
        reorderListUsingSlowAndFastPointer(slow, fast, true);
    }
    
    public ListNode reorderListUsingSlowAndFastPointer(ListNode slow, ListNode fast, boolean isEvenSize) {
            ListNode newNext = null;
            if(fast != null) {
                newNext = reorderListUsingSlowAndFastPointer(slow.next, fast.next == null ? null : fast.next.next, fast.next == null ? false : true);
            } 
            ListNode temp = isEvenSize && newNext == null ? slow.next.next : slow.next;
            ListNode oldNewNext = newNext == null ? temp : newNext.next;
            if(isEvenSize && newNext == null) slow.next.next = newNext; else slow.next = newNext;
            if(newNext != null) newNext.next = temp;    
            return oldNewNext;
    }
    
    
    public void reorderListOpt3(ListNode head) {
        if (head == null) return;

        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4 
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }

        // reverse the second part of the list [Problem 206]
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        // reverse the second half in-place
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
          tmp = curr.next;

          curr.next = prev;
          prev = curr;
          curr = tmp;
        }

        // merge two sorted linked lists [Problem 21]
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        ListNode first = head, second = prev;
        while (second.next != null) {
          tmp = first.next;
          first.next = second;
          first = tmp;

          tmp = second.next;
          second.next = first;
          second = tmp;
        }
    }

    public static void main(String[] args) {

        ReorderList obj = new ReorderList();
        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode head = BuildLinkedList.buildList(arr);
        BuildLinkedList.printListNode(head);
        obj.reorderList(head);
        System.out.println();
        BuildLinkedList.printListNode(head);

    }

}
