package leetcode.feb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC594LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
            if (freqMap.get(num - 1) != null) {
                res = Math.max(res, freqMap.get(num) + freqMap.get(num - 1));
            }
            if (freqMap.get(num + 1) != null) {
                res = Math.max(res, freqMap.get(num) + freqMap.get(num + 1));
            }

        }

        return res;
    }

    public int findLHSSort(int[] nums) {
        if (nums.length < 2)
            return 0;

        Arrays.sort(nums);

        int longestSubsequence = 0;
        int currentNumLength = 1;
        int nextNumLength = 0;
        int currentNum = nums[0];
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNum) {
                currentNumLength++;
            } else if (nums[i] == currentNum + 1) {
                nextNumLength++;
                flag = true;
            } else {
                if (flag) {
                    longestSubsequence = Math.max(longestSubsequence, currentNumLength + nextNumLength);
                    flag = false;
                }

                if (nums[i] - nums[i - 1] == 1) {
                    currentNum = nums[i - 1];
                    currentNumLength = nextNumLength;
                    nextNumLength = 1;
                } else {
                    currentNum = nums[i];
                    currentNumLength = 1;
                    nextNumLength = 0;
                }
            }
        }

        if (flag) {
            longestSubsequence = Math.max(longestSubsequence, currentNumLength + nextNumLength);
        }

        return longestSubsequence;
    }

    public int findLHSMap(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {

            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int answer = 0;
        for (int num : counts.keySet()) {

            if (counts.containsKey(num + 1)) {

                answer = Math.max(answer, counts.get(num) + counts.get(num + 1));

            }
        }

        return answer;
    }
    
    
    public int findLHSSort1(int[] nums) {
        Arrays.sort(nums); 
        int res = 0, i=0, j = 1, gap = 0;
        while(j<nums.length){
            gap = nums[j] - nums[i];
            if(gap == 1) res = Math.max(res,j-i+1);
            if(gap <= 1) j++;
            else i++;
        }
        return res;
    }

    public static void main(String[] args) {
        LC594LongestHarmoniousSubsequence obj = new LC594LongestHarmoniousSubsequence();
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(obj.findLHS(nums));

    }

}
