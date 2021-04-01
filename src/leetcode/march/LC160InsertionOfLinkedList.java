package leetcode.march;

import java.util.Stack;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC160InsertionOfLinkedList {

    public ListNode getIntersectionNodeStack(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode node = headA;
        while (node != null) {
            stackA.push(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            stackA.push(node);
            node = node.next;
        }

        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                return result;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB)
            return headA;
        ListNode first = headA;
        ListNode second = headB;
        while (first != null || second != null) {
            if (first == null) {
                first = headB;
            } else {
                first = first.next;
            }

            if (second == null) {
                second = headA;
            } else {
                second = second.next;
            }

            if (first == second)
                return first;
        }
        return null;
    }

    public ListNode getIntersectionNodeSol(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0;
        int lenB = 0;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            lenB++;
        }
        if (nodeA != nodeB) {
            return null;
        }
        nodeA = headA;
        nodeB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                nodeA = nodeA.next;
                diff--;
            }
        } else if (lenB > lenA) {
            int diff = lenB - lenA;
            while (diff > 0) {
                nodeB = nodeB.next;
                diff--;
            }
        }

        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        LC160InsertionOfLinkedList obj = new LC160InsertionOfLinkedList();
        int[] nums = { 4, 1, 8, 4, 5 };
        int[] nums1 = { 5, 6, 1, 8, 4, 5 };

        ListNode head1 = BuildLinkedList.buildList(nums);
        ListNode head2 = BuildLinkedList.buildList(nums1);
        System.out.println(obj.getIntersectionNode(head1, head2).val);

    }

}
