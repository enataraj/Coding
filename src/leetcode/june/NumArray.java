package leetcode.june;

class NumArray {

    int[] nums;
    int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        calculatePrefixSum(1);

    }

    private void calculatePrefixSum(int idx) {

        for (int i = idx; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == right) {
            return prefixSum[left];
        }
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];

    }

    public void update(int index, int val) {
        if (index == 0) {
            prefixSum[0] = val;
            index = index + 1;
        } else {
            nums[index] = val;
        }
        calculatePrefixSum(index);
    }

}
