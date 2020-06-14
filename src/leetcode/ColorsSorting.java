package leetcode;

import java.util.Arrays;

public class ColorsSorting {

    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                r++;
            else if (nums[i] == 1)
                w++;
            else if (nums[i] == 2)
                b++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (r > 0) {
                nums[i] = 0;
                r--;
            } else if (w > 0) {
                nums[i] = 1;
                w--;
            } else if (b > 0) {
                nums[i] = 2;
                b--;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    public void sortColorsSinglePass(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        int tmp;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                tmp = nums[lo];
                nums[lo] = nums[mid];
                nums[mid] = tmp;
                
                lo++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;
            } else {
                if (nums[mid] == 2) {
                    tmp = nums[mid];
                    nums[mid] = nums[hi];
                    nums[hi] = tmp;
                    hi--;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        
       

    }

    public static void main(String[] args) {
//        int nums[] = { 2, 0, 2, 1, 1, 0, 2, 2, 2, 2 };
//        new ColorsSorting().sortColors(nums);
        int nums[] = {2,0,1};
        new ColorsSorting().sortColorsSinglePass(nums);
    }

}
