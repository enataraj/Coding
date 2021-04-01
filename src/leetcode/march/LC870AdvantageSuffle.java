package leetcode.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LC870AdvantageSuffle {

   
    
    
    public int[] advantageCountSol(int[] A, int[] B) {
        Arrays.sort(A);
        int len = A.length;
        long[] aux = new long[len];
        for (int i = 0; i < len; i++) {
            aux[i] = (long) B[i] * 10000 + i;
        }
        Arrays.sort(aux);
        int left = 0;
        int right = len - 1;
        for (int num : A) {
            if (num > aux[left] / 10000) {
                B[(int) (aux[left++] % 10000)] = num;
            } else {
                B[(int) (aux[right--] % 10000)] = num;
            }
        }
        return B;
    }

    public int[] advantageCountParin(int[] A, int[] B) {
        TreeMap<Integer, Integer> aMap = new TreeMap<>();
        for (int a : A) {
            aMap.put(a, aMap.getOrDefault(a, 0) + 1);
        }
        
        for (int i = 0; i < A.length; i++) {
            Integer val = aMap.higherKey(B[i]);
            if (val == null) {
                val = aMap.firstKey();
            }
            
            if (aMap.put(val, aMap.get(val) - 1) == 1) {
                aMap.remove(val);
            }
            
            A[i] = val;
        }
        
        return A;
    }
    
    public int[] advantageCount(int[] A, int[] B) {

        int min = Integer.MAX_VALUE;

        for (int num : B) {
            min = Math.min(num, min);
        }

        List<Integer> unUsedNumbers = new ArrayList<>();
        for (int num : A) {
            if (num <= min) {
                unUsedNumbers.add(num);
            }
        }

        Arrays.sort(A);
        int result[] = new int[A.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[j] > B[i]) {
                    result[i] = A[j];
                    break;
                }
            }

        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == -1) {
                result[i] = unUsedNumbers.remove(0);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        LC870AdvantageSuffle obj = new LC870AdvantageSuffle();
        int[] A = { 2, 7, 11, 15 }, B = { 1, 10, 4, 11 };
        System.out.println(Arrays.toString(obj.advantageCount(A, B)));
    }

}
