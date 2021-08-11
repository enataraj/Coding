package leetcode.aug2021;

public class LC42TrappingRainWater {

    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];

                }
                result += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                result += rightMax - height[right];
                right--;
            }
        }
        return result;

    }

}
