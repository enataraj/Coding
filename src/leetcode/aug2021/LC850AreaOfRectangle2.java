package leetcode.aug2021;

import java.util.HashSet;
import java.util.Set;

public class LC850AreaOfRectangle2 {

    public int rectangleArea(int[][] rectangles) {
        int MOD = 1000000007;
        long result = 0;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int[] rectangle : rectangles) {
            rowSet.add(rectangle[0]);
            rowSet.add(rectangle[2]);
            colSet.add(rectangle[1]);
            colSet.add(rectangle[3]);
        }

        return (int) result % MOD;
    }

    public static void main(String[] args) {
        LC850AreaOfRectangle2 obj = new LC850AreaOfRectangle2();
    }

}
