package leetcode.oct;

public class RotateArray {
    
    public void rotate(int[] nums, int k) {
        /*if (nums == null || nums.length == 0 || k == 0 || nums.length == 1) {
            return;
        }*/

        k = k % nums.length;

        /*if (k == 0) {
            return;
        }*/

        // Reverse the whole array
        // Reverse the first k number
        // Reverse the last n-k number
        int l = 0, r = nums.length - 1;

        rotate(nums, l, r);
        rotate(nums, l, k - 1);
        rotate(nums, k, r);

        //System.out.println(Arrays.toString(nums));

    }

    private void rotate(int[] nums, int l, int r) {
        int tmp=0;
        while (l < r) {
             tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

}
