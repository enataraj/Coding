package leetcode.aug;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return i + "#" + j;
        }

    }

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return -1;
        }

        boolean flag = true;

        Queue<Pair> rottonQueue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    flag = false;
                }

                if (grid[i][j] == 2) {
                    rottonQueue.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    freshCount++;
                }

            }
        }

        if (flag) {
            return 0;
        }

        if (rottonQueue.isEmpty()) {
            return -1;
        }

        int gridRow = grid.length;
        int gridCol = grid[0].length;
        int count = 0;

        System.out.println("Queue Size : " + rottonQueue);

        while (!rottonQueue.isEmpty()) {
            int qsize = rottonQueue.size();
            boolean foundFresh = false;
            for (int k = 0; k < qsize; k++) {
                Pair cell = rottonQueue.poll();
                int x = cell.i;
                int y = cell.j;

                if (isValid(x, y - 1, gridRow, gridCol) && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    rottonQueue.add(new Pair(x, y - 1));
                    foundFresh = true;
                    freshCount--;

                }
                if (isValid(x, y + 1, gridRow, gridCol) && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    rottonQueue.add(new Pair(x, y + 1));
                    foundFresh = true;
                    freshCount--;

                }

                if (isValid(x - 1, y, gridRow, gridCol) && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    rottonQueue.add(new Pair(x - 1, y));
                    foundFresh = true;
                    freshCount--;

                }

                if (isValid(x + 1, y, gridRow, gridCol) && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    rottonQueue.add(new Pair(x + 1, y));
                    foundFresh = true;
                    freshCount--;

                }

                System.out.println("Queue  : " + rottonQueue);

            }
            if (!foundFresh) {
                break;
            }

            count++;

        }

        if (freshCount > 0) {
            return -1;
        }

        return count;

    }

    private boolean isValid(int i, int j, int gridRow, int gridCol) {
        if (i >= 0 && j >= 0 && i < gridRow && j < gridCol) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        RottingOranges obj = new RottingOranges();
        // int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // int[][] grid = { { 2, 1, 1 }, { 0,1,1}, { 1,0,1 } };
        int[][] grid = { { 1, 2, 1, 1, 2, 1, 1 } };
        System.out.println(obj.orangesRotting(grid));

    }
}
