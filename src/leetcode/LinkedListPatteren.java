package leetcode;

public class LinkedListPatteren {

    // Reverse the Linked List
    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    ListNode reverse_recursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        /*
         * reverse the rest list and put the first element at the end
         */
        ListNode rest = reverse_recursive(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    ListNode head;

    // A simple and tail recursive function to reverse
    // a linked list. prev is passed as NULL initially.
    ListNode reverseUtil(ListNode curr, ListNode prev) {
        /* If head is initially null OR list is empty */
        if (head == null)
            return head;
        /* If last node mark it head */
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return head;
        }

        /* Save curr->next node for recursive call */
        ListNode next1 = curr.next;

        /* and update next .. */
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }
}
