package leetcode.june;

import java.util.ArrayList;
import java.util.List;

public class LC629KInversePairsArray {

    long result = 0;

    public int kInversePairs(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int j = k; j > 0; j--) {
            list.add(j);
        }
        dfsHelper(list, n, k);
        return (int) result % 1000000007;

    }

    private void dfsHelper(List<Integer> list, int n, int k) {
        if (list.size() == n) {
            result += 1;
            return;
        }

        for (int i = k + 1; i <= n; i++) {
            list.add(i);
            System.out.println(list);
            dfsHelper(list, n, i);
            list.remove(list.size() - 1);
        }

    }

    private void reverse(List<Integer> list, int left, int right) {
        while (left < right) {
            int tmp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, tmp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        LC629KInversePairsArray obj = new LC629KInversePairsArray();
        System.out.println(obj.kInversePairs(5, 3));
    }
}
