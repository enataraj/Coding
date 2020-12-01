package leetcode.nov;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class AddTwoNumbersLinkedList {

    public ListNode addTwoNumbers_Bad(ListNode l1, ListNode l2) {
        StringBuffer num1 = new StringBuffer();
        StringBuffer num2 = new StringBuffer();

        int len1 = 0;
        int len2 = 0;
        while (l1 != null || l2 != null) {
            if (l2 != null) {
                num2.append(l2.val);
                l2 = l2.next;
                len2++;
            }
            if (l1 != null) {
                num1.append(l1.val);
                l1 = l1.next;
                len1++;
            }
        }

        num1 = num1.reverse();
        num2 = num2.reverse();

        if (len1 < len2) {
            while (len1 != len2) {
                num1.append('0');
                len1++;
            }

        } else {
            while (len1 != len2) {
                num2.append('0');
                len2++;
            }

        }

        StringBuffer resultBuffer = new StringBuffer();
        int carry = 0;
        int res = 0;
        for (int i = 0; i < num1.length(); i++) {
            res = Integer.parseInt(num1.charAt(i) + "") + Integer.parseInt(num2.charAt(i) + "") + carry;
            carry = res / 10;
            resultBuffer.append(res % 10);

        }
        if (carry != 0) {
            resultBuffer.append(carry);
        }

        resultBuffer = resultBuffer.reverse();

        // System.out.println(resultBuffer.reverse());
        ListNode resHead = new ListNode(Integer.parseInt(resultBuffer.charAt(0) + ""));
        ListNode node = resHead;

        for (int i = 1; i < resultBuffer.length(); i++) {
            node.next = new ListNode(Integer.parseInt(resultBuffer.charAt(i) + ""));
            node = node.next;
        }

        return resHead;

    }

    private ListNode reverse(ListNode l) {
        ListNode prev = null;
        ListNode cur = l;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        int a = 0, b = 0, res = 0;
        ListNode newHead = null;
        ListNode node = null;
        boolean flag = true;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                b = 0;

            } else {
                b = l2.val;
                l2 = l2.next;
            }

            res = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;

            if (flag) {
                flag = false;
                newHead = new ListNode(res);
                node = newHead;
            } else {
                node.next = new ListNode(res);
                node = node.next;
            }
        }

        if (carry != 0) {
            node.next = new ListNode(carry);

        }
        return reverse(newHead);

    }

    public static void main(String[] args) {
        AddTwoNumbersLinkedList obj = new AddTwoNumbersLinkedList();
        int[] numbers = { 2, 3, 1 };
        int[] numbers1 = { 9, 9, 1, 7 };
        // int[] numbers = { 0, 0, 0, 0, 0 };
        // int[] numbers1 = { 0, 0, 0 };
        ListNode l1 = BuildLinkedList.buildList(numbers);

        ListNode l2 = BuildLinkedList.buildList(numbers1);
        ListNode resHead = obj.addTwoNumbers(l1, l2);
        BuildLinkedList.printListNode(resHead);

    }

}
