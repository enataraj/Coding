package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1200MinAbsoluteDiff {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            minAbs = Math.min(minAbs, Math.abs(arr[i - 1] - arr[i]));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i - 1] - arr[i]) == minAbs) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }

}
