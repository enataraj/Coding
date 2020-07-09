package leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums == null || nums.length < 3 ) {
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int sum = 0;
            List<Integer> resultSet = new ArrayList<>();
            resultSet.add(nums[i]);
            if (findTwoSum(i+1, nums, sum - nums[i], resultSet)) {
                Collections.sort(resultSet);
                result.add(resultSet);
            }

        }

        return new ArrayList<>(result);

    }

    private boolean findTwoSum(int i,int[] nums, int sum, List<Integer> resultSet) {
        boolean flag = false;
        Set<Integer> tmpSet = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            int res = sum - nums[j];
            if (tmpSet.contains(res)) {
                resultSet.add(nums[j]);
                resultSet.add(res);
                return true;
            }
            tmpSet.add(nums[j]);
        }
        return flag;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
         int[] nums = { -1, 0, 1, 2, -1, -4 };
        // int[] nums = {1,1,-2};
        //int[] nums = { 0, 0,0,0 };
       //int[] nums = { -2, 0, 1, 1, 2 };
      //  int[] nums = {1,2,-2,-1};
       // int[] nums = {0,0,0};
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);

    }
    
    
    // Optimized
    
    public List<List<Integer>> threeSum_Optimized(int[] nums) {
        int i,j;
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        for(i=0;i<nums.length-2;i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = -nums[i];
                int low = i+1;
                int high = nums.length - 1;
                while(low < high) {
                    if((nums[low] + nums[high]) == target){
                        list.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if((nums[low] + nums[high]) < target){
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return list;
    }
    
    // Parin
    public List<List<Integer>> threeSum_ParinSol(int[] nums) {
        int n = nums.length;
        
        if (n < 3) {
            return Collections.emptyList();
        }
        
        Arrays.sort(nums); // [-4,-1,-1,0,1,2]
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) { // i = 0
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            for (int j = i+1, k = n-1; j < k;) { // j = 1, k = 5
                int target = -nums[i]; // 4
                if ((k < n-1 && nums[k] == nums[k+1]) || nums[j] + nums[k] > target) {
                    --k;
                    
                } else if ((j > i+1 && nums[j] == nums[j-1]) || (nums[j] + nums[k] < target)) {
                    ++j;
                    
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    
                }
            }
        }
        
        return res;
    }
    
    
public List<List<Integer>> threeSum_UsingSet(int[] nums) {
        
        Set<List<Integer>>set = new HashSet();
        Arrays.sort(nums);
        
           for(int i = 0; i < nums.length-2; i++)
        {
       // int i = 0;
        int j = i+1;
        int k = nums.length-1;
        int sum = 0;
        
        while(j < k){
            
           sum = nums[i] + nums[j] + nums[k];
            
            if(sum == 0)
                set.add(Arrays.asList(nums[i] , nums[j++], nums[k--]));
            
            else if(sum < 0)
                j++;
            
            else if(sum > 0)
                k--;
        }
      }
        
        return new ArrayList(set);
    }

}
