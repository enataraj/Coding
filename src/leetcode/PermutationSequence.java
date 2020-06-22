package leetcode;

import java.util.Arrays;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] arr = new int[n], // [1,2,3,4]
                fact = new int[n + 1]; // [1,1,2,6,24]

        fact[0] = 1;
        for (int i = 1; i <= n; i++) { // i = 1
            arr[i - 1] = i;
            fact[i] = i * fact[i - 1];
        }

        --k;

        helper(arr, fact, 0, k); // 0, 8
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void helper(int[] arr, int[] fact, int start, int k) { // [2,3,1,4], 0, 8 .. 1, 2
        if (k == 0) {
            return;
        }

        int len = arr.length - start; // 3
        int idx = k / fact[len - 1]; // 1
        swap(arr, start, start + idx);
        Arrays.sort(arr, start + 1, arr.length);
        helper(arr, fact, start + 1, k % fact[len - 1]); // 1, 2
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 9;

        PermutationSequence obj = new PermutationSequence();
        String result = obj.getPermutation(n, k);
        System.out.println("Result : " + result);

    }

}
