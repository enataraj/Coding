package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1365NumberLessThanCurrentNumber {

    private class Data implements Comparable<Data> {
        int val;
        int idx;

        public Data(int val, int idx) {
            this.val = val;
            this.idx = idx;

        }

        public int compareTo(Data data) {

            if (this.val > data.val) {
                return 1;
            }
            if (this.val == data.val && this.idx > data.idx) {
                return 1;
            }
            return -1;
        }

        public String toString() {
            return "Data : " + val + " Idx : " + idx;
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        Data[] dataArray = new Data[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dataArray[i] = new Data(nums[i], i);
        }
        Arrays.sort(dataArray);
        Map<Integer, Integer> cache = new HashMap<>();

        int[] resArray = new int[nums.length];
        for (int i = 0; i < dataArray.length; i++) {
            if (cache.containsKey(dataArray[i].val)) {
                resArray[dataArray[i].idx] = cache.get(dataArray[i].val);
            } else {
                resArray[dataArray[i].idx] = i;
                cache.put(dataArray[i].val, i);
            }

        }

        // System.out.println(Arrays.toString(resArray));
        return resArray;
    }

    public int[] smallerNumbersThanCurrentSol(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = count[nums[i] - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC1365NumberLessThanCurrentNumber obj = new LC1365NumberLessThanCurrentNumber();
        int[] nums = { 8, 1, 2, 2, 3 };
        obj.smallerNumbersThanCurrent(nums);
    }

}
