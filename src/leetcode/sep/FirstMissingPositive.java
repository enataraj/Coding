package leetcode.sep;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        boolean[] idxMap = new boolean[nums.length];

        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                idxMap[num - 1] = true;
            }
        }
        int i = 0;

        for (boolean var : idxMap) {
            i++;
            if (!var) {
                return i;
            }
        }
        return i + 1;

    }

    public int firstMissingPositiveReuse(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < nums.length) {
            if ((nums[i] > 0) && (nums[i] <= n) && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]);
            } else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return n + 1;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b - 1];
        nums[b - 1] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] nums = { 3, 4, -1, 1 };
        System.out.println(obj.firstMissingPositiveReuse(nums));

    }

}
