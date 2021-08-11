package leetcode.aug2021;

import java.util.Stack;

public class LC84LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
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
                System.out.println(stack);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
            System.out.println(stack);
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LC84LargestRectangle obj = new LC84LargestRectangle();
        System.out.println(obj.largestRectangleArea(heights));
    }

}
