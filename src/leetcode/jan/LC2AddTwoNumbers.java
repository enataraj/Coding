package leetcode.jan;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1;
        int sum = 0;
        int carry = 0;
        ListNode prev1 = null;
        ListNode prev2;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;

            carry = sum / 10;
            sum = sum % 10;
            l1.val = sum;
            prev1 = l1;
            prev2 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            prev1 = l1;
            prev2 = l1;
            l1.val = sum;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            prev1.next = new ListNode(sum);
            prev2 = prev1;
            prev1 = prev1.next;

            l2 = l2.next;
        }
        if (carry > 0) {
            prev1.next = new ListNode(carry);
        }
        return head;

    }

    public static void main(String[] args) {
        LC2AddTwoNumbers obj = new LC2AddTwoNumbers();
        int[] num1 = { 4, 5, 1 };
        int[] num2 = { 7, 2, 8, 2 };
        ListNode l1 = BuildLinkedList.buildList(num1);
        ListNode l2 = BuildLinkedList.buildList(num2);
        ListNode res = obj.addTwoNumbers(l1, l2);
        BuildLinkedList.printListNode(res);
    }

}
