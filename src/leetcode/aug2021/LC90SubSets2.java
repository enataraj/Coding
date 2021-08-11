package leetcode.aug2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC90SubSets2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfsHelper(int[] nums, int idx, List<Integer> curList) {
        result.add(new ArrayList<>(curList));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            dfsHelper(nums, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDupBinary(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.EMPTY_LIST);
        Arrays.sort(nums);
        Set<String> resultString = new HashSet<>();
        for (int i = 1; i < Math.pow(2, nums.length); i++) {

            StringBuffer sb = new StringBuffer();
            int idx = nums.length - 1;
            int n = i;
            while (n > 0) {
                if ((n & 1) == 1) {
                    sb.append(nums[idx] + "#");
                }
                n = n >> 1;
                idx--;
            }
            if (sb.charAt(sb.length() - 1) == '#') {
                sb.deleteCharAt(sb.length() - 1);
            }
            resultString.add(sb.toString());
        }

        for (String str : resultString) {
            String[] tmpArray = str.split("#");
            List<Integer> tmpList = new ArrayList<>();
            for (String num : tmpArray) {
                tmpList.add(Integer.parseInt(num));
            }
            result.add(tmpList);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        LC90SubSets2 obj = new LC90SubSets2();
        // System.out.println(obj.subsetsWithDupRec(nums));
        System.out.println(obj.subsetsWithDupBinary(nums));
    }

}
