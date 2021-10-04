package leetcode.sep2021;

import java.util.ArrayList;
import java.util.List;

public class LC282ExpressionAddOperators {

    List<String> result;
  

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();  
        dfsHelper(0, num, "", 0, 0, target);
        return result;
    }

    private void dfsHelper(int idx, String num, String numString, long resSoFar, long prevSum, int target) {
        if (idx >= num.length()) {
            if (resSoFar == target) {
                result.add(numString);
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {
            if (i > idx && num.charAt(idx) == '0') { // Skip for leading zero number
                System.out.println("Breakk "+idx);
                break;
            }
            long curNum = Long.parseLong(num.substring(idx, i + 1));
           // System.out.println("idx  "+idx+"  i = "+(i+1)+"  curNum  "+curNum);
            if (idx == 0) {
                dfsHelper(i + 1, num, numString + curNum, curNum, curNum, target); // First number , Just pick it without adding operator
            } else {
                dfsHelper(i + 1, num, numString + "+" + curNum, resSoFar + curNum, curNum, target);
                dfsHelper(i + 1, num, numString + "-" + curNum, resSoFar - curNum, -curNum, target);
                dfsHelper(i + 1, num, numString + "*" + curNum, resSoFar - prevSum + prevSum * curNum, prevSum * curNum,
                        target);
            }

        }

    }

    class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> result = new ArrayList<>();

            if (Long.valueOf(num) > Integer.MAX_VALUE)
                return result;

            char[] nums = num.toCharArray();
            char[] path = new char[nums.length * 2 - 1];
            long val = 0;

            for (int i = 0; i < nums.length; i++) {
                val = val * 10 + nums[i] - '0';
                path[i] = nums[i];

                addOperators(result, target, nums, path, 0, val, i + 1, i + 1);

                if (val == 0)
                    break;
            }

            return result;
        }

        public void addOperators(List<String> result, int target, char[] nums, char[] path, long leftValue,
                long rightValue, int numsPos, int pathPos) {
            if (numsPos == nums.length) {
                if (leftValue + rightValue == target)
                    result.add(new String(path, 0, pathPos));
                return;
            }

            long val = 0;
            int j = pathPos + 1;

            for (int i = numsPos; i < nums.length; i++) {
                val = val * 10 + nums[i] - '0';
                path[j++] = nums[i];

                path[pathPos] = '+';
                addOperators(result, target, nums, path, leftValue + rightValue, val, i + 1, j);

                path[pathPos] = '-';
                addOperators(result, target, nums, path, leftValue + rightValue, -val, i + 1, j);

                path[pathPos] = '*';
                addOperators(result, target, nums, path, leftValue, rightValue * val, i + 1, j);

                // Check if number has a leading zero
                if (nums[numsPos] == '0')
                    return;
            }
        }
    }

    public static void main(String[] args) {
        LC282ExpressionAddOperators obj = new LC282ExpressionAddOperators();
        String num = "10023";
        int target = 6;
        System.out.println(obj.addOperators(num, target));
    }

}
