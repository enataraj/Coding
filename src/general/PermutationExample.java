package general;

import java.util.Arrays;

public class PermutationExample {

    private void generatePermuatation(int[] nums) {
        permutation(nums, 0, nums.length - 1);
    }

    private void permutation(int[] nums, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(nums));
        }

        for (int i = left; i <= right; i++) {
            swap(nums, left, i);
            permutation(nums, left + 1, right);
            swap(nums, left, i);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3};
        PermutationExample obj = new PermutationExample();
        obj.generatePermuatation(nums);
    }

}
