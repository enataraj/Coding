package leetcode.dec;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import linkedlist.util.BuildLinkedList;
import linkedlist.util.ListNode;

public class LinkedListRandom {

    
    // Instead of Map i can Use List Also
    Random r = new Random();
    private int idx = 0;
    private Map<Integer, Integer> listMap = new HashMap<>();

    public LinkedListRandom(ListNode head) {

        while (head != null) {
            listMap.put(idx, head.val);
            head = head.next;
            idx++;

        }
        r = new Random(idx);

    }

    /** Returns a random node's value. */
    public int getRandom() {
        return listMap.get(r.nextInt(idx));
    }
    
    

    public static void main(String[] args) {

        int numbers[] = { 10, 3, 5, 2 };
        ListNode head = BuildLinkedList.buildList(numbers);
        LinkedListRandom obj = new LinkedListRandom(head);
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.getRandom());
        }

    }

}
