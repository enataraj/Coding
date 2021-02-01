package leetcode.jan;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LC21MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }
        if (l2 != null) {
            node.next = l2;

        }
        if (l1 != null) {
            node.next = l1;

        }
        return dummyNode.next;

    }

    public ListNode mergeTwoListsNotOptimized(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null && l2 != null) {
                node.next = l2;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        return dummyNode.next;

    }

    public static ListNode buildList(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode currentListNode = head;

        for (int i = 1; i < numbers.length; i++) {
            ListNode ListNode = new ListNode(numbers[i]);
            currentListNode.next = ListNode;
            currentListNode = currentListNode.next;

        }
        return head;
    }

    public ListNode mergeTwoListsSol(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoListsSol(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoListsSol(l1, l2.next);
        }
        return head;
    }

    public ListNode mergeTwoListsParin(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), resIter = dummy, iter1 = l1, iter2 = l2;

        while (iter1 != null && iter2 != null) {
            if (iter1.val <= iter2.val) {
                resIter.next = iter1;
                iter1 = iter1.next;

            } else {
                resIter.next = iter2;
                iter2 = iter2.next;
            }

            resIter = resIter.next;

        }

        if (iter1 != null) {
            resIter.next = iter1;

        } else if (iter2 != null) {
            resIter.next = iter2;

        }

        return dummy.next;

    }

    public ListNode mergeTwoListsNO(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;

        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;

        }
        ListNode node = head;
        ListNode tmpNode;
        int val;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            tmpNode = new ListNode(val);
            node.next = tmpNode;
            node = node.next;

        }

        while (l1 != null) {
            tmpNode = new ListNode(l1.val);
            node.next = tmpNode;
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            tmpNode = new ListNode(l2.val);
            node.next = tmpNode;
            node = node.next;
            l2 = l2.next;
        }

        return head;

    }

    public static void main(String[] args) {
        LC21MergeSortedList obj = new LC21MergeSortedList();
        int[] num = { 1, 3, 4, 9 };
        int[] num2 = { 1, 4, 9 };
        ListNode l1 = BuildLinkedList.buildList(num);
        ListNode l2 = BuildLinkedList.buildList(num2);
        ListNode head = obj.mergeTwoLists(l1, l2);
        BuildLinkedList.printListNode(head);
    }

}
