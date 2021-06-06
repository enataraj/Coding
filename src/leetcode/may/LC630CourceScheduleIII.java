package leetcode.may;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC630CourceScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int courceCnt = 0;
        int totalDuration = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < courses.length; i++) {

            if ((totalDuration + courses[i][0]) <= courses[i][1]) {
                queue.add(courses[i][0]);
                totalDuration += courses[i][0];
                courceCnt++;

            } else if (courses[i][0] < queue.peek()) {

                totalDuration = totalDuration - queue.poll();
                totalDuration += courses[i][0];
                queue.add(courses[i][0]);

            }
        }
        return courceCnt;

    }

    public static void main(String[] args) {
        LC630CourceScheduleIII obj = new LC630CourceScheduleIII();
        //int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1200, 1250 }, { 2000, 3200 } };
        //int[][] courses ={{5,5},{4,6},{2,6}};
        // int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
        int[][] courses = { { 5, 15 }, { 3, 19 }, { 6, 7 }, { 2, 10 }, { 5, 16 }, { 8, 14 }, { 10, 11 }, { 2, 19 } };
        System.out.println(obj.scheduleCourse(courses));
    }

}
