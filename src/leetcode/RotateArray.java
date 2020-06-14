package leetcode;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((i + k) > nums.length - 1) {
                res[i-k-1] = nums[i];
            } else {
                res[i + k ] = nums[i];
            }
           
        }
        System.out.println("actual Arra : "+Arrays.toString(res));

    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Inout Arra : " + Arrays.toString(a));
        int[] res = { 5, 6, 7, 1, 2, 3, 4 };
        System.out.println("Expected Res : " + Arrays.toString(res));
       new RotateArray().rotate(a, 3);
        
    }

}
