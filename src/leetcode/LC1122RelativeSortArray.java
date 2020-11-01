package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LC1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return new int[0];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (freqMap.containsKey(arr1[i])) {
                freqMap.put(arr1[i], freqMap.get(arr1[i]) + 1);
            } else {
                freqMap.put(arr1[i], 1);
            }
        }

        int j = 0;
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            int freq = freqMap.remove(arr2[i]);
            for (int k = 0; k < freq; k++) {
                res[j] = arr2[i];
                j++;
            }
        }

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            for (int k = 0; k < freq; k++) {
                res[j] = key;
                j++;
            }
        }
        return res;
    }
    
    
    public int[] relativeSortArrayOpt(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        int N = arr1.length;
        for (int num: arr1) cnt[num]++;
        int[] res = new int[N];
        int idx = 0;
        for (int num: arr2) while (cnt[num]-- > 0) res[idx++] = num;
        // System.out.println(Arrays.toString(res));
        for (int i = 0; i < 1001; i++) while (cnt[i]-- > 0) res[idx++] = i;
        return res;
    }

    public static void main(String[] args) {

        LC1122RelativeSortArray obj = new LC1122RelativeSortArray();
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        System.out.println(Arrays.toString(obj.relativeSortArray(arr1, arr2)));

    }

}
