package leetcode.sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MajorityElement3 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return Collections.emptyList();

        } else if (n == 1) {
            return Arrays.asList(nums[0]);
        }

        List<Integer> res = new ArrayList<>();
        Integer cand1 = null, cand2 = null;

        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (cand1 == null || cand1 == num) {
                cand1 = num;
                ++count1;

            } else if (cand2 == null || cand2 == num) {
                cand2 = num;
                ++count2;

            } else if (count1 == 0) {
                cand1 = num;
                ++count1;

            } else if (count2 == 0) {
                cand2 = num;
                ++count2;

            } else {
                --count1;
                --count2;

            }
        }

        int actualCount1 = 0, actualCount2 = 0;

        for (int num : nums) {
            if (cand1 != null && cand1 == num) {
                ++actualCount1;
            }

            if (cand2 != null && cand2 == num) {
                ++actualCount2;
            }
        }

        if (cand1 != null && actualCount1 > n / 3) {
            res.add(cand1);
        }

        if (cand2 != null && actualCount2 > n / 3) {
            res.add(cand2);
        }

        return res;
    }
    
    
    public List<Integer> majorityElementOpt(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int cand1 = nums[0], cand2 = nums[0];
        int count1 = 0, count2= 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == cand1){
                count1++;
            } else if(num == cand2){
                count2++;
            } else if(count1 == 0){
                cand1 = num;
                count1++;
            } else if(count2 == 0){
                cand2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(cand1 == num){
                count1++;
            } else if(cand2 == num){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            result.add(cand1);
        }
        if(count2 > nums.length / 3){
            result.add(cand2);
        }
        return result;
    }


    public static void main(String[] args) {

        MajorityElement3 obj = new MajorityElement3();
        int[] nums = { 2, 3, 4, 4, 4, 5, 5, 5 };
        System.out.println(obj.majorityElement(nums));

    }

}
