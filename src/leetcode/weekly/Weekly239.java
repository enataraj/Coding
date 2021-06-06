package leetcode.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Weekly239 {

    public int getMinDistance(int[] nums, int target, int start) {

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(start - i));
                if (res == 0) {
                    return 0;
                }
            }
        }
        return res;
    }

    public int getMinSwaps(String num, int k) {
        String tmp = num;

        while (k >= 0) {
            char[] nums = tmp.toCharArray();
            tmp = nextPermutation(nums);
            k--;
        }
        return k;

    }

    public String nextPermutation(char[] nums) {
        int firstDescFromRight = nums.length - 2;
        while (firstDescFromRight >= 0 && nums[firstDescFromRight] >= nums[firstDescFromRight + 1]) {
            firstDescFromRight--;
        }

        if (firstDescFromRight >= 0) {
            int firstNumLarger = nums.length - 1;
            while (nums[firstDescFromRight] >= nums[firstNumLarger]) {
                firstNumLarger--;
            }

            swap(nums, firstDescFromRight, firstNumLarger);
        }
        reverse(nums, firstDescFromRight + 1, nums.length - 1);
        return new String(nums);
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(char[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private int test(String num, int n) {
        char[] P = num.toCharArray();
        int arr[] = new int[n + 1];

        arr[0] = 0;

        for (int i = 0; i < n; i++)
            arr[i + 1] = P[i];

        // Keeps count of swaps
        int cnt = 0;

        for (int i = 1; i < n; i++) {

            // Check if it is an 'X' position
            if (arr[i] == i) {
                int t = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = t;
                cnt++;
            }
        }

        // Corner Case
        if (arr[n] == n) {

            // Swap
            int t = arr[n - 1];
            arr[n - 1] = arr[n];
            arr[n] = t;
            cnt++;
        }

        return cnt;
    }

    public int[] minIntervalTLE(int[][] intervals, int[] queries) {

        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = 0;
        for (int query : queries) {
            int diff = Integer.MAX_VALUE;
            for (int[] interval : intervals) {
                if (interval[0] <= query && query <= interval[1]) {
                    diff = Math.min(diff, interval[1] - interval[0] + 1);
                    result[idx] = diff;
                } else if (interval[0] > query) {
                    break;

                }
            }
            idx++;
        }

        return result;

    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] interval : intervals) {
            int val = interval[1] - interval[0] + 1;
            for (int i = interval[0]; i <= interval[1]; i++) {
                if (map.containsKey(i)) {
                    map.put(i, Math.min(val, map.get(i)));
                } else {
                    map.put(i, val);
                }
            }

        }

        int[] result = new int[queries.length];
        int idx = 0;
        for (int query : queries) {
            if (map.get(query) != null) {
                result[idx++] = map.get(query);
            } else {
                result[idx++] = -1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Weekly239 obj = new Weekly239();

        System.out.println(obj.test("5489355142", 4));
        int[][] invls = { { 2, 3 }, { 2, 5 }, { 1, 8 }, { 20, 25 } };
        int[] qry = { 2, 19, 5, 22 };

        System.out.println(Arrays.toString(obj.minInterval(invls, qry)));
    }

}
