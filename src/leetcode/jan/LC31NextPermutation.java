package leetcode.jan;

import java.util.Arrays;

public class LC31NextPermutation {

    public void nextPermutation(int[] nums) {
        int firstDescFromRight = nums.length - 2;
        while (firstDescFromRight >= 0 && nums[firstDescFromRight] >= nums[firstDescFromRight + 1]) {
            firstDescFromRight--;
        }

        
        if (firstDescFromRight >= 0) {
            int firstNumLarger = nums.length - 1;
            while (nums[firstDescFromRight] >= nums[firstNumLarger]) {
                firstNumLarger--;
            }
           
            swap(nums, firstDescFromRight, firstNumLarger);
        }
        reverse(nums, firstDescFromRight + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        LC31NextPermutation obj = new LC31NextPermutation();
     //   int[] nums = { 1, 3, 2 };// 213
        int[] nums = { 3,2,1 };// 213

        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
