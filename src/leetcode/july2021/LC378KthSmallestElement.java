package leetcode.july2021;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC378KthSmallestElement {
    
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int[] mat = new int[matrix.length*matrix.length];
            int idx=0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix.length;j++){
                   mat[idx++] =  matrix[i][j];
                }
            }
            Arrays.sort(mat);
            return mat[k-1];
            
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }

            }
        }

        return pq.peek();
    }

    public int kthSmallestBinarySearch(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(matrix, mid, k, n)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;

    }

    public static void main(String[] args) {
        LC378KthSmallestElement obj = new LC378KthSmallestElement();
        int[][] mat = { { -5 } };
        int k = 1;
        System.out.println(obj.kthSmallest(mat, k));
    }

}
