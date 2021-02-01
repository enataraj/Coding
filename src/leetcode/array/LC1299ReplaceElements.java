package leetcode.array;

import java.util.Arrays;

public class LC1299ReplaceElements {

    public int[] replaceElements(int[] arr) {
        int maxsofar = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = maxsofar;
            if (maxsofar < arr[i]) {
                maxsofar = arr[i];
            }
            arr[i] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        LC1299ReplaceElements obj = new LC1299ReplaceElements();
        int arr[] = { 17, 18, 5, 4, 6, 1 };
        System.out.println(Arrays.toString(obj.replaceElements(arr)));
        // 18,6,6,6,1,-1

    }

}
