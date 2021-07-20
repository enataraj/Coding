package leetcode.weekly.week250;

import java.util.Stack;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, tail = prev.next;
        int count = 0;
        while (tail != null) {
            tail = tail.next;
            count++;
            if (count == k) {
                head = prev.next;
                prev.next = reverseList(head, tail);
                prev = head;
                tail = prev.next;
                count = 0;
            }
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        ListNode prev = tail;
        while (head != tail) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /*
     * class Solution {
    ListNode* reverse(ListNode* head, ListNode* tail) {
        ListNode* prev = tail;
        while (head != tail) {
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;            
        }
        return prev;
    }
    public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode dummy;
        dummy.next = head;
        ListNode* prev = &dummy, *tail = prev->next;
        int count = 0;
        while (tail) {
            tail = tail->next;
            count++;
            if (count == k) {
                ListNode* head = prev->next;
                prev->next = reverse(head, tail);
                prev = head;
                tail = prev->next;
                count = 0;
            }
        }
        return dummy.next;
    }
    };
     */

    public ListNode reverseKGroupStack(ListNode head, int k) {

        if (head == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode newNode = dummyNode;
        while (node != null) {
            if (stack.size() < k) {
                stack.push(node);
                node = node.next;
            } else {
                while (!stack.isEmpty()) {
                    newNode.next = stack.pop();
                    newNode = newNode.next;
                    newNode.next = null;

                }
            }

        }

        // Last few node 
        Stack<ListNode> newStack = new Stack<>();
        if (!stack.isEmpty()) {
            // Last few node is equal to k
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    newNode.next = stack.pop();
                    newNode = newNode.next;
                    newNode.next = null;

                }

            } else {
                // Last few node is less than k
                while (!stack.isEmpty()) {
                    newStack.push(stack.pop());
                }
            }
        }
        // Last few node is less than k
        while (!newStack.isEmpty()) {
            newNode.next = newStack.pop();
            newNode = newNode.next;
            newNode.next = null;

        }

        return dummyNode.next;
    }

    public ListNode reverseKGroupALt(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        begin = dummyNode;
        int cnt = 0;
        while (head != null) {
            cnt++;
            if (cnt % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyNode.next;

    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode node = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = node;
        while (node != end) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        begin.next = prev;
        first.next = node;
        return first;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ListNode head = BuildLinkedList.buildList(nums);
        ListNode newHead = new LC25ReverseNodesInKGroup().reverseKGroup(head, 6);
        BuildLinkedList.printListNode(newHead);

        //  ListNode newHead1 = new LC25ReverseNodesInKGroup().reverseList(head, null, 9);
        // BuildLinkedList.printListNode(newHead1);
    }

}
