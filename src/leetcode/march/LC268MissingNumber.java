package leetcode.march;

public class LC268MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long totalSum = n * (n + 1) / 2;
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return (int) (totalSum - sum);

    }

    public int missingNumberSol(int[] nums) {
        int[] result = new int[nums.length + 1];
        for (int item : nums) {
            result[item] += 1;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0)
                return i;
        }
        return -1;
    }

    public int missingNumberXOR(int[] nums) {
        int myXor = 0;
        int expXor = 0;
        int i = 0;
        for (int n : nums) {
            myXor ^= n;
            expXor ^= i++;
        }
        expXor ^= i;
        return expXor ^ myXor;
    }
    
    public int missingNumber_piegeon_hole(int nums[]) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums.length) {
                    missing = i;
                    break;
                }
                //swap(nums[i], nums[nums[i]]); // need to write the swap method
            }
        }
        return missing;
    }
    
    

    public static void main(String[] args) {
        LC268MissingNumber obj = new LC268MissingNumber();
        int[] nums = { 1, 3, 4, 5 };
        System.out.println(obj.missingNumberXOR(nums));
    }

}
