package leetcode.topint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC350TwoIntersectionArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] resArray = new int[result.size()];
        for (i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
    
    public int[] intersectSol(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[1001];
        for(int x : nums1){
            //increment occurence
            arr[x] = arr[x]+1;
        }
        for(int y : nums2){
            if(arr[y] > 0){
                arr[y] = arr[y]-1;
                list.add(y);
            }
        }
        int[] newarr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) newarr[i] = list.get(i); 
        return newarr;
    }

    public static void main(String[] args) {
        LC350TwoIntersectionArrays obj = new LC350TwoIntersectionArrays();
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        System.out.println(obj.intersect(nums1, nums2));
    }

}
