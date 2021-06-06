package leetcode.weekly.week242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    int[] nums1;
    Map<Integer, Integer> map;
    Map<Integer, Integer> valueMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        Arrays.sort(nums1);
        map = new HashMap<>();
        valueMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(i, nums2[i]);
            valueMap.put(nums2[i], valueMap.getOrDefault(nums2[i], 0) + 1);
        }

    }

    public void add(int index, int val) {
        int oldVal = map.get(index);
        int newVal = oldVal + val;
        map.put(index, newVal);
        valueMap.put(oldVal, valueMap.get(oldVal) - 1);
        valueMap.put(newVal, valueMap.getOrDefault(newVal, 0) + 1);

    }

    public int count(int tot) {
        int cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (tot >= nums1[i]) {

                cnt += valueMap.getOrDefault(tot - nums1[i], 0);

            } else {
                return cnt;
            }

        }
        return cnt;

    }

    public static void main(String[] args) {
        /*
         * ["FindSumPairs","count","add","count","count","add","add","count"]
        [[[1,1,2,2,2,3],[1,4,5,2,5,4]],[7],[3,2],[8],[4],[0,1],[1,1],[7]]
         */
        int[] nums1 = { 1, 1, 2, 2, 2, 3 };
        int[] nums2 = { 1, 4, 5, 2, 5, 4 };

        FindSumPairs obj = new FindSumPairs(nums1, nums2);
        obj.count(7);
        obj.add(3, 2);
        obj.count(8);
        obj.count(4);
        obj.add(0, 1);
        obj.add(1, 1);
        obj.count(7);

    }

}
