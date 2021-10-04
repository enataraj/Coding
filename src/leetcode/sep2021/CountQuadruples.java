package leetcode.sep2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountQuadruples {
    
 public int countQuadruplets(int[] nums) {
     int cnt =0;
     int len = nums.length;
    // Arrays.sort(nums);
     System.out.println(Arrays.toString(nums));
     for(int i=0;i<len;i++) {
         for(int j=i+1;j<len;j++) {
             for(int k=j+1;k<len;k++) {
                 for(int z=k+1;z<len;z++) {
                     if(nums[i]+nums[j]+nums[k]-nums[z]==0) {
                         List<Integer> list = new ArrayList<>();
                         list.add(nums[i]);
                         list.add(nums[j]);
                         list.add(nums[k]);
                         list.add(nums[z]);
                         System.out.println(list);
                         cnt++;
                     }
                 }
             }
         }
     }
        return cnt;
    }
 
 public static void main(String[] args) {
    int[] nums = {28,8,49,85,37,90,20,8};
    CountQuadruples obj = new CountQuadruples();
    System.out.println(obj.countQuadruplets(nums));
}
}
