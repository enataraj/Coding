package leetcode.weekly.biweekly58;

import java.util.Stack;

public class MinSwapToBalance {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char chr : s.toCharArray())
            if (chr == '[')
                stack.push(chr);
            else if (!stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else
                stack.push(chr);

        //One swap will reduce 4 , ]][[ => 3rd to first, 2nd to last = > [][]
        int tmp = 0;
        int unBalancedParanthesesis = stack.size();
        if (unBalancedParanthesesis % 4 != 0) {
            tmp = 4 - unBalancedParanthesesis % 4;
        }
        return (unBalancedParanthesesis + tmp) / 4;

    }

    public int minSwapsSol2(String s) {
        int i = 0, j = s.length() - 1, leftCount = 0, rightCount = 0, result = 0;
        while (i < j) {
            while (leftCount >= 0 && i < j)
                leftCount = (s.charAt(i++) == '[') ? leftCount + 1 : leftCount - 1;

            while (rightCount >= 0 && i < j)
                rightCount = (s.charAt(j--) == ']') ? rightCount + 1 : rightCount - 1;

            if (leftCount == -1) { // swap
                result++;
                leftCount = rightCount = 1;
            }
        }
        return result;
    }

    class Solution {
        public int minSwaps(String s) {
            int x = 0;
            int ans = 0;
            char[] ss = s.toCharArray();
            int j = ss.length - 1;
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] == '[')
                    x++;
                else
                    x--;
                if (x < 0) {
                    while (ss[j] != '[')
                        j--;
                    ss[i] = '[';
                    ss[j] = ']';
                    x = 1;
                    ans++;
                }
            }
            return ans;
        }
    }

    public int minSwapsTLE(String s) {
        while (s.contains("[]")) {
            s = s.replace("[]", "");
        }

        int left = 0;
        int right = s.length() - 1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                result++;
            }

        }
        while (left < right) {
            if (s.charAt(left) == ']' && s.charAt(right) == '[') {
                result++;
                left += 2;
                right -= 2;

            }
        }
        return result;

    }

    public static void main(String[] args) {
        MinSwapToBalance obj = new MinSwapToBalance();
        System.out.println(obj.minSwaps("[[[]]]][][]][[]]][[["));
    }

}
