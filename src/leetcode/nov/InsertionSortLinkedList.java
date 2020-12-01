package leetcode.nov;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class InsertionSortLinkedList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode iNode = head;
        ListNode jNode = head;
        while (iNode != null) {
            jNode = iNode.next;
            while (jNode != null) {
                if (iNode.val > jNode.val) {
                    int tmp = jNode.val;
                    jNode.val = iNode.val;
                    iNode.val = tmp;
                }
                jNode = jNode.next;
            }
            iNode = iNode.next;
        }

        return head;

    }
    
    public ListNode insertionSortList_Parin(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE),
            cur = head;
        
        while (cur != null) {
            // detach the node
            ListNode node = cur;
            cur = cur.next;
            node.next = null;
            
            ListNode iter = dummy;
            while (iter.next != null && iter.next.val < node.val) {
                iter = iter.next;
            }
            
            node.next = iter.next;
            iter.next = node;
        }
        
        return dummy.next;
    }
    
    
    public ListNode insertionSortListSol(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(head != null){
            ListNode temp = head.next;
            if(prev.val >= head.val){
                prev = dummy;
            }
            while(prev.next != null && prev.next.val < head.val){
                prev = prev.next;
            }
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }
        return dummy.next;
    }

    public ListNode insertionSortListOld(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oldNode = head;
        ListNode newHead = head;
        ListNode newNode = head;
        ListNode preNode;

        while (oldNode != null) {
            int oldValue = oldNode.val;
            if (oldValue <= newHead.val) {
                ListNode node = new ListNode(oldValue);
                node.next = newHead;
                newHead = node;
            } else {
                preNode = newHead;
                newNode = newHead.next;
                boolean flag = false;
                while (newNode != null) {
                    int newVal = newNode.val;
                    if (oldValue <= newVal) {
                        ListNode node = new ListNode(oldValue);
                        node.next = newNode;
                        preNode.next = node;
                        flag = true;
                        break;
                    }
                    preNode = newNode;
                    newNode = newNode.next;
                }

                if (!flag) {
                    preNode.next = new ListNode(oldValue);
                }
            }

            oldNode = oldNode.next;

        }

        return newHead;

    }
    
    public ListNode insertionSortListMerge(ListNode head) {
        // NOTE : This is mergesort. Not insertion sort
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode preslow = null;
        
        
        while(fast != null && fast.next != null) {
            preslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
            
        preslow.next = null;
                
        ListNode head1 = insertionSortList(head);
        ListNode head2 = insertionSortList(slow);
        
        ListNode prehead = new ListNode();
        ListNode current = prehead;
        
        while(head1!=null && head2 != null) {
            if(head1.val < head2.val){
                current.next = head1;
                head1 = head1.next;
            }else{
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
     
        if(head1!=null){
            current.next = head1;
        }
        
        if(head2!=null) {
            current.next = head2;
        }
        
        ListNode result = prehead.next;
        prehead.next = null;
        return result;
    }

    public static void main(String[] args) {
        InsertionSortLinkedList obj = new InsertionSortLinkedList();
        int[] numbers = { 3, 1, 7, 4, 9, 12 };
        ListNode headNode = BuildLinkedList.buildList(numbers);
        headNode = obj.insertionSortList(headNode);
        BuildLinkedList.printListNode(headNode);
    }

}
