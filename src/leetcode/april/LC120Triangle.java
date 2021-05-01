package leetcode.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC120Triangle {

    // Top Down DP

    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = 1; i < triangle.size(); i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int sum = 0;
                if (j == 0) {
                    sum = triangle.get(i - 1).get(j) + triangle.get(i).get(j);
                } else if (j == size - 1) {
                    sum = triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                } else {
                    int min = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                    sum = min + triangle.get(i).get(j);
                }
                triangle.get(i).set(j, sum);
                System.out.println(triangle);
            }
        }

        return Collections.min(triangle.get(triangle.size() - 1));

    }

    // Bottom up
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int sum = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }

    // O(N) Space Solution

    public int minimumTotalOptimized(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] memo = new int[size + 1];
        for (int i = size - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                memo[j] = triangle.get(i).get(j) + Math.min(memo[j], memo[j + 1]);
        return memo[0];
    }

    public int minimumTotalSame(List<List<Integer>> triangle) {
        int SIZE = triangle.size();
        int[] lastRow = new int[SIZE + 1];
        for (int row = SIZE - 1; row >= 0; row--)
            for (int col = 0; col <= row; col++)
                lastRow[col] = triangle.get(row).get(col) + Math.min(lastRow[col], lastRow[col + 1]);
        return lastRow[0];
    }

    public static void main(String[] args) {
        LC120Triangle obj = new LC120Triangle();
        List<List<Integer>> triangle =  new ArrayList<>();
        List<Integer> list = new ArrayList();
        list.add(2);
        triangle.add(list);
        list = new ArrayList();
        list.add(3);
        list.add(4);
        triangle.add(list);
        list = new ArrayList();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);
        list = new ArrayList();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);
        System.out.println(obj.minimumTotal(triangle));
        
        
        
        
        
        
        
    }

}
