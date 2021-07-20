package leetcode.july2021;

import java.util.ArrayList;
import java.util.List;

public class LC658FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - 1;
        int cnt = arr.length - k;

        while (cnt > 0) {
            if (x - arr[left] < arr[right] - x) {
                right--;
            } else {
                left++;
            }
            cnt--;

        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        LC658FindKClosestElements obj = new LC658FindKClosestElements();
        int[] arr = { -1, -2, 3, 3, 3, 4, 7 };
        int k = 5;
        int x = 3;
        System.out.println(obj.findClosestElements(arr, k, x));

    }

}
