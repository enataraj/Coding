package leetcode.nov;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LinkedListBinaryToInteger {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }

        StringBuffer strBuffer = new StringBuffer();
   
        while (head != null) {
            strBuffer.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(strBuffer.toString(), 2);

    }

    public int getDecimalValueAlternate(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }
    
    public int getDecimalValueBitwise(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum << 1 |head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedListBinaryToInteger obj = new LinkedListBinaryToInteger();
        int[] numbers = { 1, 0, 1,1 };

        ListNode head = BuildLinkedList.buildList(numbers);
        System.out.println(obj.getDecimalValueBitwise(head));

    }

}
