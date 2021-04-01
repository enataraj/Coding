package leetcode.march;

import java.util.Arrays;

public class LC645SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int num : nums) {
            num = Math.abs(num);
            if (nums[num - 1] < 0) {
                res[0] = num;
            } else
                nums[num - 1] = -nums[num - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;

    }

    public int[] findErrorNumsSol(int[] nums) {
        int[] count = new int[nums.length];
        int[] result = new int[2];
        for (int num : nums) {
            count[num - 1]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 2) {
                result[0] = i + 1;
            }
            if (count[i] == 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }

    public int[] findErrorNumsParin(int[] nums) {
        int n = nums.length, xor1toN = 0, xorAll = 0;

        for (int i = 1; i <= n; i++) {
            xor1toN ^= i; // XOR all the numbers from 1 to N
            xorAll ^= nums[i - 1]; // XOR all the values in the given Array
        }

        int missingXorDupe = xorAll ^ xor1toN; // While XOR both all numbers from 1 to N and Given Array, it will tell
                                               // you which two numbers are hidden in it. Now need to find what are
                                               // those two numbers.
        int mask = (missingXorDupe & ~(missingXorDupe - 1)); // Find a last set bit which is your mask value.

        // Apply that mask value with AND of 1 to N and XOR the result
        int missingOrDupe = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & mask) != 0) {
                missingOrDupe ^= i;
            }
        }

        // Apply that mask value with AND from numbers in array and XOR the result.
        for (int i = 0; i < n; i++) {
            if ((nums[i] & mask) != 0) {
                missingOrDupe ^= nums[i];
            }
        }

        // Above two value contains one missing and one duplicate, Now need to find
        // which one is missing and duplicate by go over again in the given numbers

        for (int i = 0; i < n; i++) {
            if (nums[i] == missingOrDupe) {
                return new int[] { nums[i], missingOrDupe ^ missingXorDupe };
            }
        }

        return new int[] { missingOrDupe ^ missingXorDupe, missingOrDupe };
    }

    public static void main(String[] args) {
        LC645SetMismatch obj = new LC645SetMismatch();
        int[] nums = { 1, 2, 3, 4, 4 };
        System.out.println(Arrays.toString(obj.findErrorNums(nums)));
    }

}
