package general;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxNumberOfWeeks {

    public long numberOfWeeks(int[] milestones) {
        long result = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : milestones) {
            maxHeap.add(num);
        }
        while (maxHeap.size() > 1) {
            int firstProject = maxHeap.poll();
            int secondProject = maxHeap.poll();
            int diff = firstProject - secondProject;
            result += (2 * Math.min(secondProject, firstProject));
            if (diff > 0) {
                maxHeap.add(diff);
            }
        }
        if (maxHeap.size() == 1) {
            result += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        MaxNumberOfWeeks obj = new MaxNumberOfWeeks();
        int[] milestones = { 5, 7, 5, 7, 9, 7 };
        System.out.println(obj.numberOfWeeks(milestones));

    }

}
