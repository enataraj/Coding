package leetcode.july;

import linkedlist.util.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return head;

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }

    public ListNode removeElementsParin(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode writeIter = dummy, readIter = head;

        while (readIter != null) {
            if (readIter.val != val) {
                writeIter.next = readIter;
                writeIter = writeIter.next;
            }

            readIter = readIter.next;
        }

        writeIter.next = null;
        return dummy.next;
    }

    public ListNode removeElementsOpt(ListNode head, int val) {
        if (head == null)
            return head;

        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return head;

        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        RemoveLinkedListElements obj = new RemoveLinkedListElements();
        ListNode head = new ListNode(7);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);

        head = obj.removeElements(head, 6);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }

    }

}
