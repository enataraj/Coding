package leetcode.aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllDuplicate {

    public List<Integer> findDuplicates(int[] nums) {List<Integer> res = new ArrayList<>();
    int n = nums.length;
    
    for (int i = 0; i < n; i++) {
        int val = Math.abs(nums[i]);
        if (nums[val - 1] < 0) {
            res.add(val);
        }
        
        nums[val-1] *= -1;
    }
    
    return res;
    }

    public static void main(String[] args) {
        FindAllDuplicate obj = new FindAllDuplicate();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(obj.findDuplicates(nums));

    }

}
