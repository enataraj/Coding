package leetcode.jan;

import java.util.HashMap;
import java.util.Map;

public class LC1658MinimumOperationReducetoZero {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int result = Integer.MAX_VALUE;
        // Base condition
        if (nums[0] > x && nums[len - 1] > x) {
            return -1;
        }

        if (nums[0] == x || nums[len - 1] == x) {
            return 1;
        }

        // Running Sum from Left to Right
        int sum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            freqMap.put(sum, i + 1);
            if (sum == x) {
                result = Math.min(result, i + 1);
            }

            if (sum > x) {
                break;
            }
        }

        if (sum < x) {
            return -1;
        }
        sum = 0;

        // From Right to Left Find a pair from Left Sum Map
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];

            if (sum == x) {
                result = Math.min(result, len - i);
            }
            if (sum > x) {
                break;
            }

            if (freqMap.containsKey(x - sum)) {
                int idx = freqMap.get(x - sum);
                if (idx < i) {
                    int val = len - i + idx;
                    result = Math.min(result, val);
                }

            }
        }

        if (result == Integer.MAX_VALUE)
            return -1;
        return result;

    }

    public int minOperations_Initial(int[] nums, int x) {

        int len = nums.length;
        int result = Integer.MAX_VALUE;
        if (nums[0] > x && nums[len - 1] > x) {
            return -1;
        }

        if (nums[0] == x || nums[len - 1] == x) {
            return 1;
        }

        int[] nums1 = new int[len];
        int[] nums2 = new int[len];
        Map<Integer, Integer> freqMap = new HashMap<>();
        nums1[0] = nums[0];
        for (int i = 1; i < len; i++) {
            nums1[i] = nums1[i - 1] + nums[i];
            freqMap.put(nums1[i], i + 1);
            if (nums1[i] == x) {
                result = Math.min(result, i + 1);
            }
        }
        if (nums1[len - 1] < x) {
            return -1;
        }
        nums2[len - 1] = nums[len - 1];
        if (freqMap.containsKey(x - nums2[len - 1])) {
            result = Math.min(result, 1 + freqMap.get(x - nums2[len - 1]));
        }

        for (int i = len - 1; i > 0; i--) {
            nums2[i - 1] = nums2[i] + nums[i - 1];
            if (nums2[i - 1] == x) {
                result = Math.min(result, len - i + 1);
            }

            if (freqMap.containsKey(x - nums2[i - 1])) {

                int idx = freqMap.get(x - nums2[i - 1]);
                if (idx < i - 1) {
                    int val = len - i + 1 + idx;
                    result = Math.min(result, val);
                }

            }
        }
        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));

        if (result == Integer.MAX_VALUE)
            return -1;
        return result;

    }
    
    public int minOperationsSol(int[] nums, int x) {
        
        int i = 0;
        int j = 0;
        
        int sum = 0;
        int count = 0;
        int maxCount = 0;
        
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        if (total == x) {
            return nums.length;
        }
        
        while (j < nums.length) {
            sum += nums[j];
            j++;
            count++;
            while (sum > total - x && i < j) {
                sum -= nums[i];
                i++;
                count--;
            }
            
            if (sum == total - x) {
                maxCount = Math.max(count, maxCount);
                if (i < nums.length) {
                    sum -= nums[i];
                    i++;
                    count--;
                }
            }
        }
        
        return maxCount > 0 ? nums.length - maxCount : -1;
    }

    public static void main(String[] args) {
        LC1658MinimumOperationReducetoZero obj = new LC1658MinimumOperationReducetoZero();
        // int[] nums = { 3, 2, 20, 1 , 1, 3 };
        int[] nums = { 3, 2, 20, 1, 1, 3 };
        int x = 10;
        // int[] nums = {5,6,7,8,9};
        // int x =4;
        // int[] nums = { 1, 1, 4, 2, 3 };
        // int x = 5;
        // int[] nums = { 1, 1 };
        // int x = 3;
        System.out.println(obj.minOperations(nums, x));
    }

}
