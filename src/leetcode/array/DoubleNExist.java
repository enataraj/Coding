package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class DoubleNExist {

    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return false;
        }

        int count = 0;
        Set<Integer> existSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            existSet.add(arr[i]);
            if (arr[i] == 0) {
                count++;
            }

        }

        if (count > 1) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && existSet.contains(arr[i] * 2)) {
                return true;
            }
        }

        return false;

    }
    
    
    public boolean checkIfExistOpt(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        
        Set<Integer> arr_set = new HashSet<Integer> ();
        for (int num : arr) {
            if (arr_set.contains(num * 2)) {
                return true;
            } 
            if (num % 2 == 0 && arr_set.contains(num / 2)) {
                return true;
            }
            arr_set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleNExist obj = new DoubleNExist();
        int arr[] = {0};
        System.out.println(obj.checkIfExist(arr));

    }
}
