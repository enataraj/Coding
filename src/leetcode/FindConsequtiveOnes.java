package leetcode;

public class FindConsequtiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int preMax = 0;
        int curMax = 0;

        if (nums == null || nums.length == 0) {
            return 0;

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curMax++;
            } else {
                preMax = Math.max(curMax, preMax);
                curMax = 0;
            }
        }

        return Math.max(preMax, curMax);

    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        FindConsequtiveOnes obj = new FindConsequtiveOnes();
        int result = obj.findMaxConsecutiveOnes(nums);
        System.out.println("Max Ones " + result);
    }
}
