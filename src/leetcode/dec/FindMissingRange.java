package leetcode.dec;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRange {
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int low = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != low)
                res.add(getRange(low, nums[i] - 1));
            low = nums[i] + 1;
        }
        if (upper >= low || low == lower)
            res.add(getRange(low, upper));
        return res;
    }
    
    private String getRange(int low, int high) {
        if (high != low)
            return low + "->" + high;
        else
            return "" + low;
    }

}
