package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC961NrepeatedNums {
    public int repeatedNTimes(int[] A) {
        Set<Integer> nums = new HashSet<>();
        for(int num:A){
            if(nums.contains(num)){
                return num;
            }
            nums.add(num);
        }
        return -1;
    }
    
    public int repeatedNTimesSol(int[] A) {
        int[] count = new int[10000];
        for (int a : A) {
            if (count[a]++ == 1) {
                return a;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        LC961NrepeatedNums obj = new LC961NrepeatedNums();
        
    }

}
