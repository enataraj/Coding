package leetcode.july2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC18Sum4 {
    
    /*
     * 
     * 
     *  1,2,3,4
     *  1,3,4,2
     *  
     *  10 -- > 1,2 2,3 
     *  
     *  10 -- 6,7 ,9,10
     *  
     *  1,2,6,7
     *  1,2,9,10
     *  2,3,67
     *  2,3,9,10
     *  
     *  6,7 9,10
     *  
     *  
     *  
     *  20 
     */
    

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        int length = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                twoSum(nums, target - nums[i] - nums[j], j + 1, result, i, j);
            }
        }

        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> list : result) {
            finalResult.add(list);
        }
        return finalResult;
    }

    private void twoSum(int[] nums, int target, int startIdx, Set<List<Integer>> result, int firstIdx, int secondIdx) {

        Set<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[firstIdx]);
                list.add(nums[secondIdx]);
                list.add(target - nums[i]);
                list.add(nums[i]);
                result.add(list);

            } else {
                set.add(nums[i]);
            }
        }

    }

    public List<List<Integer>> fourSumBF(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int x = j + 1; x < nums.length - 1; x++) {
                    for (int y = x + 1; y < nums.length; y++) {
                        if (nums[i] + nums[j] + nums[x] + nums[y] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[x]);
                            list.add(nums[y]);
                            result.add(list);
                        }
                    }
                }
            }
        }

        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> list : result) {
            finalResult.add(list);
        }
        return finalResult;
    }

    
   
    
    /*   
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
    */
    public static void main(String[] args) {
        LC18Sum4 obj = new LC18Sum4();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(obj.fourSum(nums, target));

    }

}
