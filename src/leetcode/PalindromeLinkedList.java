package leetcode;

import java.util.Stack;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null)
            return false;

        ListNode node = head;
        Stack<Integer> stack = new Stack();

        while (node != null) {
            stack.push(node.val);
            node = node.next;

        }

        node = head;
        while (!stack.isEmpty()) {
            if (node.val != stack.pop()) {
                return false;
            }
            node = node.next;

        }
        return true;

    }
    
    
    public boolean isPalindrome_Eff(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = null;
        ListNode prev_mid = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(prev_mid == null){
                prev_mid = head;
            }else{
                prev_mid = prev_mid.next;
            }
        }
        mid = slow;
        ListNode prev = null;
        ListNode cur = mid;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
          
        }
        prev_mid.next = prev;
        ListNode flag = prev;
        while(head != flag){
            if(head.val != prev.val){
                return false;
            }else{
                head =head.next;
                prev = prev.next;
            }
        }
        return true;

        
    }

    public static void main(String[] args) {
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(obj.isPalindrome(head));
    }

}
