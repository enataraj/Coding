package leetcode.jan;

import java.util.HashMap;
import java.util.Map;

public class LC1640CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] idxArray = new int[101];
        for (int i = 0; i < arr.length; i++) {
            idxArray[arr[i]] = i;
        }
        for (int i = 0; i < pieces.length; i++) {
            int[] tmpArr = pieces[i];
            int idx = idxArray[tmpArr[0]];
            if (tmpArr[0] != arr[idx]) {
                return false;
            }
            for (int j = 1; j < tmpArr.length; j++) {
                if (idxArray[tmpArr[j]] != idx + j) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean canFormArraySol(int[] arr, int[][] pieces) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxMap.put(arr[i], i);
        }

        for (int i = 0; i < pieces.length; i++) {
            int[] tmpArr = pieces[i];
            if (tmpArr.length > 1) {
                if (idxMap.containsKey(tmpArr[0])) {
                    int idx = idxMap.get(tmpArr[0]);
                    for (int j = 1; j < tmpArr.length; j++) {
                        if (idxMap.containsKey(tmpArr[j])) {
                            if (idxMap.get(tmpArr[j]) != idx + j) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

            } else if (!idxMap.containsKey(tmpArr[0])) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        LC1640CanFormArray obj = new LC1640CanFormArray();
        int[] arr = { 91, 4, 64, 78 };
        int[][] pieces = { { 78 }, { 4, 64 }, { 91 } };
        // int[] arr = { 12 };
        // int[][] pieces = { { 1 } };
        // int[] arr = { 1, 2, 3 };
        // int[][] pieces = { { 2 }, { 1, 3 } };

        // int[] arr = { 1, 3, 5, 7 };
        // int[][] pieces = { { 2, 4, 6, 8 } };

        // int[] arr = { 49, 18, 16 };
        // int[][] pieces = { { 16, 18, 49 } };

        System.out.println(obj.canFormArray(arr, pieces));

    }

}
