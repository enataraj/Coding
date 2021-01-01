package leetcode.array;

public class LC1539KthMissingPositive {
    public int findKthPositive(int[] arr, int k) {
        int idx = 0;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (idx < arr.length && arr[idx] == i) {
                idx++;
            } else {
                k--;
            }
            if (k == 0) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        LC1539KthMissingPositive obj = new LC1539KthMissingPositive();
        int[] arr = { 1, 2, 3, 4 };

        System.out.println(obj.findKthPositive(arr, 4));

    }

}
