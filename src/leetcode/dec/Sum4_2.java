package leetcode.dec;

import java.util.HashMap;
import java.util.Map;

public class Sum4_2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int len = A.length - 1;

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                for (int k = 0; k <= len; k++) {
                    for (int z = 0; z <= len; z++) {
                        if (A[i] + B[j] + C[k] + D[z] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;

    }
    
    public int fourSumCount_Parin(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int twoSum = A[i] + B[j];
                map.put(twoSum, map.getOrDefault(twoSum, 0) + 1);
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int twoSum = C[i] + D[j];
                if (map.containsKey(-twoSum)) {
                    count += map.get(-twoSum);
                }
            }
        }
        
        return count;
        
    }

    public static void main(String[] args) {

        Sum4_2 obj = new Sum4_2();
        int[] A = { 1, 2 };
        int[] B = { -2, -1 };
        int[] C = { -1, 2 };
        int[] D = { 0, 2 };
        System.out.println(obj.fourSumCount(A, B, C, D));
    }

}
