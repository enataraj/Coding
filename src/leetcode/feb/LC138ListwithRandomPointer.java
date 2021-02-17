package leetcode.feb;

import java.util.HashMap;
import java.util.Map;

public class LC138ListwithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        HashMap<Node, Node> randomNodeMap = new HashMap<>();
        Node oldHead = head;
        Node nHead = new Node(head.val);
        Node newHead = nHead;
        randomNodeMap.put(head, nHead);
        head = head.next;

        while (head != null) {
            nHead.next = new Node(head.val);
            nHead = nHead.next;
            randomNodeMap.put(head, nHead);
            head = head.next;       
        }
        
        while(oldHead!=null) {
            randomNodeMap.get(oldHead).random = randomNodeMap.get(oldHead.random);
            oldHead =  oldHead.next;
        }

        return newHead;

    }
    
    
    public Node copyRandomListParin(Node head) {
        Map<Node, Node> cloneMap = new HashMap<>();
        if (head == null) {
            return head;
        }
        
        Node cur = head;
        while (cur != null) {
            cloneMap.putIfAbsent(cur, new Node(cur.val));
            Node curClone = cloneMap.get(cur);
            
            if (cur.next != null) {
                cloneMap.putIfAbsent(cur.next, new Node(cur.next.val));
                curClone.next = cloneMap.get(cur.next);
            }
            
            if (cur.random != null) {
                cloneMap.putIfAbsent(cur.random, new Node(cur.random.val));
                curClone.random = cloneMap.get(cur.random);
            }
            
            cur = cur.next;
        }
        
        return cloneMap.get(head);
    }
    
    
    public Node copyRandomListSplit(Node head) {
        if (head == null) {
            return null;
        }
        
        createNewNodes(head);
        copyRandom(head);
        Node newhead = head.next;
        split(head);
        return newhead;
    }
    
    private void createNewNodes(Node head) {
        while (head != null) {
            Node copy = new Node(head.val);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
           
        }
    }
    
    private void copyRandom(Node head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private void split(Node head) {
        while (head != null) {
            Node next = head.next.next;
            Node newhead = head.next;
            head.next = next;
            head = head.next;
            if (next != null) {
                newhead.next = next.next;
            }
        }
    }
    
    
    
    public Node copyRandomListWalk(Node head) {
        Node walk = head, node, dummy = new Node(0), pre = dummy;
        Map<Node, Node> original2copy = new HashMap<>(); // SC(n)
        
        while (walk != null) { // TC(n)
            node = original2copy.get(walk); // important stretegy
            if (node == null) {
                node = new Node(walk.val);
                original2copy.put(walk, node);
            }
            
            if (walk.random != null) {
                node.random = original2copy.get(walk.random);
                if (node.random == null) {
                    node.random = new Node(walk.random.val);
                    original2copy.put(walk.random, node.random);
                }
            }
            
            pre.next = node;
            pre = node;
            walk = walk.next;
        }
        
        return dummy.next;
    }

    private Node buildList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        return head;
    }

    private void printNode(Node head) {
        while (head != null) {
            System.out.print("  " + head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC138ListwithRandomPointer obj = new LC138ListwithRandomPointer();
        Node head = obj.buildList();
        obj.printNode(head);
        head = obj.copyRandomList(head);
        obj.printNode(head);

    }

}
