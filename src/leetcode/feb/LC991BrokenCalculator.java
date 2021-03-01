package leetcode.feb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC991BrokenCalculator {
    int res = Integer.MAX_VALUE;

    public int brokenCalcRec(int X, int Y) {
        if (X >= Y)
            return X - Y;
        return 1 + brokenCalcRec(X, (Y % 2 == 0) ? Y / 2 : Y + 1);
    }

    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y = Y / 2;
            } else {
                Y = Y + 1;
            }
            res++;
        }
        res += X - Y;
        return res;
    }

    public int brokenCalcBFSTLE(int X, int Y) {
        if (X >= Y)
            return X - Y;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        int res = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                if (tmp == Y) {
                    return res;
                }
                if (tmp - 1 > X / 2 && !visited.contains(tmp - 1)) {
                    queue.add(tmp - 1);
                    visited.add(tmp - 1);
                }

                if (tmp * 2 <= Y + 1 && !visited.contains(tmp * 2)) {
                    queue.add(tmp * 2);
                    visited.add(tmp * 2);
                }
            }
            System.out.println(queue);
            res++;

        }

        return res;

    }

    public static void main(String[] args) {
        LC991BrokenCalculator obj = new LC991BrokenCalculator();
        System.out.println(obj.brokenCalc(2, 3));

    }

}
