package linkedlist.util;

import java.util.List;

public class BuildLinkedList {

    public Node buildList(List<Integer> numbers) {
        Node head = new Node(numbers.get(0));
        Node currentNode = head;

        for (int i = 1; i < numbers.size(); i++) {
            Node node = new Node(numbers.get(i));
            currentNode.next = node;
            currentNode = currentNode.next;

        }
        return head;
    }

}
