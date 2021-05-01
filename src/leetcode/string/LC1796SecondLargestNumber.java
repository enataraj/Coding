package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;

public class LC1796SecondLargestNumber {
    public int secondHighest(String s) {
        int[] nums = new int[10];
        Arrays.fill(nums, -1);
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                nums[ch - '0']++;
            }
        }
        System.out.println(Arrays.toString(nums));
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (flag && nums[i] != -1) {
                return i;
            }
            if (nums[i] != -1) {
                flag = true;
            }

        }

        return -1;
    }

    public int secondHighestSol(String s) {
        int max = 10;
        while (max > 0) {
            if (s.indexOf(--max + '0') != -1) {
                break;
            }
        }
        while (max > 0) {
            if (s.indexOf(--max + '0') != -1) {
                return max;
            }
        }
        return -1;
    }

    public int secondHighestSol2(String s) {
        if (s.length() == 1 || s == null)
            return -1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                set.add(Character.getNumericValue(s.charAt(i)));
        }
        int max = -1;
        int secondMax = -1;
        for (int num : set) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max)
                secondMax = num;
        }
        return secondMax;
    }

    public static void main(String[] args) {
        LC1796SecondLargestNumber obj = new LC1796SecondLargestNumber();
        String str = "abc111";
        System.out.println(obj.secondHighest(str));

    }

}
