package leetcode.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BiWeekly51 {

    public String replaceDigits(String s) {

        char[] chArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        char[] input = s.toCharArray();

        for (int i = 0; i < input.length - 1; i = i + 2) {
            char ch = input[i];
            int idx = ch - 'a';
            int chIdx = input[i + 1] - '0';
            if (chIdx == 0) {
                input[i + 1] = input[i];
            } else {
                input[i + 1] = chArray[idx + chIdx];
            }
        }
        return new String(input);
    }

    class SeatManager {

        boolean[] seats;
        int smallReserve = 1;

        public SeatManager(int n) {
            seats = new boolean[n + 1];

        }

        public int reserve() {
            seats[smallReserve] = true;
            int tmp = smallReserve;
            smallReserve++;
            return tmp;

        }

        public void unreserve(int seatNumber) {
            seats[seatNumber] = false;
            smallReserve = Math.min(smallReserve - 1, seatNumber);

        }
    }

    public void test() {

        SeatManager test = new SeatManager(9);
        System.out.println(test.reserve());
        System.out.println(test.reserve());

        test.unreserve(1);
        test.unreserve(2);

    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        int maxVal = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        for (int[] room : rooms) {
            if (map.containsKey(room[1])) {
                List<Integer> list = map.get(room[1]);
                list.add(room[0]);
                map.put(room[1], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(room[0]);
                map.put(room[1], list);
            }
        }
        
        int idx=0;
        int minAbs=Integer.MAX_VALUE;
        for(int[] query:queries) {
            Set<Integer> keys = map.keySet();
            for(int key : keys) {
               if(key>=query[1]) {
                   minAbs = Math.min(minAbs,Math.abs(query[0]-map.get(key).get(0)));
               }else {
                   break;
               }
            }
            
        }

        return result;
    }

    public static void main(String[] args) {
        BiWeekly51 obj = new BiWeekly51();
        System.out.println(obj.replaceDigits("a1b2c3d4e"));
        obj.test();

    }

}
