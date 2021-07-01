package algorithm;

import java.util.Stack;

import linkedlist.util.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseListDFS(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseListDFS(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //first part
        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for (int i = 0; i < left; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        //reverse
        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        ListNode q2;
        for (int i = left; i <= right; i++) {
            q2 = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = q2;
        }

        //connect 
        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }

    public ListNode reverseBetweenAlt(ListNode head, int left, int right) {

        int numberOfNodes = right - left + 1;
        if (head == null || numberOfNodes == 1)
            return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode current = head;
        ListNode previous = dummyNode;

        while (left > 1) {
            previous = current;
            current = current.next;
            left -= 1;
        }

        ListNode t1 = previous;
        ListNode h2 = current;
        ListNode next = null;

        while (numberOfNodes > 0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            numberOfNodes -= 1;
        }
        t1.next = previous;
        h2.next = current;
        return dummyNode.next;
    }

    public ListNode reverseBetweenStack(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = head;
        ListNode firstNode = node;
        int cnt = 1;
        while (cnt != left) {
            firstNode = node;
            node = node.next;
            cnt++;
        }
        Stack<ListNode> stack = new Stack<>();
        while (cnt != right) {
            stack.push(node);
            node = node.next;
            cnt++;
        }
        stack.push(node);
        ListNode nextNode = node.next;
        if (left == 1) {
            dummyNode.next = stack.peek();
            firstNode = stack.peek();
        }
        while (!stack.isEmpty()) {
            firstNode.next = stack.pop();
            firstNode = firstNode.next;
        }
        firstNode.next = nextNode;
        return dummyNode.next;
    }

}
