package leetcode.array;

import java.util.Stack;

public class LC739DailyTemparatures {

    // Brute force from left to right
    public int[] dailyTemperaturesBF(int[] T) {
        int result[] = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // Brute Force from right to left
    public int[] dailyTemperaturesReverse(int[] T) {
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0 && T[i] > T[j]; j--) {
                res[j] = i - j;
            }
        }
        return res;
    }

    // Monotonic stack from right to left
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }

    // Monotonic stack from left to right
    public int[] dailyTemperaturesFromLeftToRight(int[] temperatures) {

        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }

}
