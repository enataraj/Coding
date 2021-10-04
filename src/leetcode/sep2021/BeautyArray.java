package leetcode.sep2021;

public class BeautyArray {

    public int sumOfBeauties(int[] nums) {

        int result = 0;
        int[] leftMaxArray = new int[nums.length];
        leftMaxArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMaxArray[i] = Math.max(leftMaxArray[i - 1], nums[i]);
        }

        int[] rightMinArray = new int[nums.length];
        rightMinArray[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            rightMinArray[i] = Math.min(rightMinArray[i + 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (leftMaxArray[i - 1] < nums[i] && nums[i] < rightMinArray[i + 1]) {
                result += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                result += 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        BeautyArray obj = new BeautyArray();
        int[] nums = {2,4,6,4 };
        System.out.println(obj.sumOfBeauties(nums));
        int[] nums1 = { 1, 2, 3 };
        System.out.println(obj.sumOfBeauties(nums1));
    }

}
