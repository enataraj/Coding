package leetcode.dec;

import java.util.Arrays;
import java.util.Stack;

public class LC84LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        System.out.println(Arrays.toString(heights));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);

        }

        return maxArea;

    }

    public int largestRectangleAreaSol2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int k = i - 1;
            while (k >= 0) {
                if (heights[k] >= heights[i]) {
                    k = left[k];
                } else {
                    break;
                }
            }
            left[i] = k;
        }

        for (int i = n - 1; i >= 0; i--) {
            int k = i + 1;
            while (k < n) {
                if (heights[k] >= heights[i]) {
                    k = right[k];
                } else {
                    break;
                }
            }
            right[i] = k;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }

    public int largestRectangleAreaSol1(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    private int largestRectangleArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return heights[start];
        }

        int minIndex = start;
        int inc = 0;
        int dec = 0;
        int res = 0;

        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }

            if (heights[i] > heights[i - 1]) {
                inc++;
            } else if (heights[i] < heights[i - 1]) {
                dec--;
            }
        }

        if (dec == 0) {
            for (int i = start; i <= end; i++) {
                res = Math.max(res, heights[i] * (end - i + 1));
            }
        } else if (inc == 0) {
            for (int i = start; i <= end; i++) {
                res = Math.max(res, heights[i] * (i - start + 1));
            }
        } else {
            res = Math.max(Math.max(largestRectangleArea(heights, minIndex + 1, end),
                    largestRectangleArea(heights, start, minIndex - 1)), heights[minIndex] * (end - start + 1));
        }

        return res;
    }

    public int largestRectangleAreaBF(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int cnt = 0;
            int currentHeight = heights[i];

            for (int j = i; j >= 0; j--) {
                if (currentHeight <= heights[j]) {
                    cnt++;
                } else {
                    break;
                }
            }

            for (int k = i + 1; k < heights.length; k++) {
                if (currentHeight <= heights[k]) {
                    cnt++;
                } else {
                    break;
                }
            }

            maxArea = Math.max(maxArea, cnt * currentHeight);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC84LargestRectangle obj = new LC84LargestRectangle();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        // int[] heights = { 2, 0, 2 };
        System.out.println(obj.largestRectangleArea(heights));
    }

}
