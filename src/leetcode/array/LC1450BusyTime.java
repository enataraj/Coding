package leetcode.array;

public class LC1450BusyTime {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int busyTime = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                busyTime++;
            }
        }
        return busyTime;
    }

    public static void main(String[] args) {
        LC1450BusyTime obj = new LC1450BusyTime();
        int[] startTime = { 1, 2, 3 };
        int[] endTime = { 3, 2, 7 };
        int queryTime = 4;
        System.out.println(obj.busyStudent(startTime, endTime, queryTime));
    }

}
