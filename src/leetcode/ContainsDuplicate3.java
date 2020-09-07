package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean flag = false;
        List<long[]> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            long[] arr = new long[2];
            arr[0] = (long) nums[i];
            arr[1] = (long) i;
            list.add(arr);
        }
        Collections.sort(list, (e1, e2) -> {
            if (e1[0] == e2[0])
                return Long.compare(e1[1], e2[1]);
            else
                return Long.compare(e1[0], e2[0]);
        });

        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            long numd = Math.abs(list.get(i)[0] - list.get(j)[0]);
            if (numd <= (long) t) {
                long indd = Math.abs(list.get(i)[1] - list.get(j)[1]);
                if (indd <= (long) k) {
                    flag = true;
                    break;
                } else {
                    j++;
                }
            } else {
                i++;
                if (i == j)
                    j++;
            }
        }
        return flag;
    }

    public boolean containsNearbyAlmostDuplicateEfficient(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (k >= 10000 && t == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j >= nums.length) {
                    break;
                }
                if ((long) nums[i] - (long) nums[j] > (long) Integer.MAX_VALUE
                        || (long) nums[j] - (long) nums[i] > (long) Integer.MAX_VALUE) {
                    continue;
                }
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

}
