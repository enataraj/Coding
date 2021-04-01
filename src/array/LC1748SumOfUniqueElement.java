package array;

import java.util.Arrays;

public class LC1748SumOfUniqueElement {
    public int sumOfUnique(int[] nums) {
        int[] map = new int[101];
        for (int num : nums) {
            map[num]++;
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (map[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int sumOfUniqueSort(int[] A) {
        Arrays.sort(A);
        int ret = 0, n = A.length;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            } else if (i + 1 < n && A[i] == A[i + 1]) {
                continue;
            }
            ret += A[i];
        }
        return ret;
    }
    
    public int sumOfUniqueSol2(int[] nums) {
        int[] arr = new int[101];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += 1;
        }
        
        for(int i = 0; i < arr.length; i++){
            res += arr[i] == 1 ? i : 0;
        }   
        
        return res;
    }
}
