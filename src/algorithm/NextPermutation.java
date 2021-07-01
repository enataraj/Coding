package algorithm;

public class NextPermutation {

    /*
     * Algorithm
     * =========
     *  Find the first dip from last (large number to small number)
     *   nums[i] >  nums[i-1]
     *   
     *   Find the number greater than nums[i-1] & swap (lower number and next highest number)
     *   
     *   Reverse from i to end of nums
     *
     * 
     */

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

}
