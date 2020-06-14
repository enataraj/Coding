package leetcode;

import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode head = new ListNode();
        Stack<Integer> l1Stack = new Stack();
        Stack<Integer> l2Stack = new Stack();
        Stack<Integer> result = new Stack();
        long num1 = 0;
        long num2 = 0;
        boolean flag = false;
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        while (!l1Stack.empty()) {
            int tmp = l1Stack.pop();
            num1 = tmp + (num1 * 10);

        }
        while (!l2Stack.empty()) {
            int tmp = l2Stack.pop();
            num2 = tmp + (num2 * 10);

        }

        long res = num1 + num2;
        System.out.println(res);
        while (res > 0) {

            int tmp =(int) res % 10;
            res = res / 10;

            if (flag) {
                newHead.next = new ListNode();
                newHead.next.val = tmp;
                newHead = newHead.next;

            } else {
                flag = true;
                newHead.val = tmp;
                head = newHead;

            }
            System.out.print(tmp);

        }

        return head;

    }
    
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode res = null, temp = null;
        int carry = 0, sum = 0;
        while (l1 != null || l2 != null) {
            sum += carry;
            sum += (l1 != null) ? l1.val : 0;
            sum += (l2 != null) ? l2.val : 0;
            carry = sum / 10;
            sum = sum % 10;
            if (res == null) {
                res = new ListNode(sum);
                temp = res;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            sum = 0;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return res;
        
    }
    

    public static void printList(ListNode l1) {
        while (l1 != null) {
            System.out.print("  " + l1.val);
            l1 = l1.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next= new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        

        printList(l1);
        System.out.println();
        printList(l2);
        System.out.println();
        ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);

        printList(l3);
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
