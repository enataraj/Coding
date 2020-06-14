package leetcode;

import java.util.Arrays;

public class MaxElementRight {
    
    
    public int[] replaceElements(int[] arr) {
        int maxsofar = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for(int i = arr.length-2;i>=0;i--){
            int tmp = maxsofar;
            if(maxsofar < arr[i]){
                maxsofar = arr[i];
            }
            arr[i] = tmp;
        }
        
        return arr;
        
    }
    
    public static void main(String[] args) {
        int[] a = {17,18,5,4,6,1};
        a=new MaxElementRight().replaceElements(a);
        System.out.println(Arrays.toString(a));
    }

}
