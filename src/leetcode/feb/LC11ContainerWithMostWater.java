package leetcode.feb;

public class LC11ContainerWithMostWater {

    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {

            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    public int maxAreaSol(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LC11ContainerWithMostWater obj = new LC11ContainerWithMostWater();
        // int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] height = { 2, 3, 10, 5, 7, 8, 9 };
        System.out.println(obj.maxArea(height));
    }

}
