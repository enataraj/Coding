package leetcode.sep2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1293ShortestPathInGrid {

    class Data {
        int row;
        int col;
        int obstaclesCnt;
        int pathCnt;

        public Data(int row, int col, int obstaclesCnt, int pathCnt) {
            this.row = row;
            this.col = col;
            this.obstaclesCnt = obstaclesCnt;
            this.pathCnt = pathCnt;

        }

        @Override
        public String toString() {
            return "Row : " + row + " Col: " + col + " obstaclesCnt: " + obstaclesCnt + " pathCnt : " + pathCnt;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int globalResult = Integer.MAX_VALUE;
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, 0, grid[0][0], 0));
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 2];
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Data data = queue.poll();
                if (data.row == rows && data.col == cols) { // Reached destination. Return result;
                    return data.pathCnt;
                }
                int row = data.row;
                int col = data.col;
                int obstracles = data.obstaclesCnt;
                int pathCnt = data.pathCnt;

                for (int[] dir : dirs) {
                    int newR = dir[0] + row;
                    int newC = dir[1] + col;
                    if (isValid(grid, newR, newC, rows, cols, obstracles, k, visited)) {
                        queue.add(new Data(newR, newC, obstracles + grid[newR][newC], pathCnt + 1)); // Adding into next path into queue
                        visited[newR][newC][obstracles + grid[newR][newC]] = true;
                        if (newR == rows && newC == cols) { // Reached destination. Return result;
                            globalResult = Math.min(globalResult, data.pathCnt);
                            return globalResult + 1;
                        }
                    }
                }

            }

        }

        return globalResult == Integer.MAX_VALUE ? -1 : globalResult;

    }

    private boolean isValid(int[][] grid, int row, int col, int rows, int cols, int obstracles, int k,
            boolean[][][] visited) {
        return row >= 0 && row <= rows && col >= 0 && col <= cols && !visited[row][col][obstracles + grid[row][col]]
                && obstracles + grid[row][col] <= k;
    }
    
    
    
    
    class Node {
        int i;
        int j;
        int k;
        Node (int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            if (k >= m+n-2) {
                return m+n-2;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, 0));
            int[][] kCount = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(kCount[i],Integer.MAX_VALUE);
            }
            kCount[0][0] = 0;
            int[][] dirs = new int[][]{{1,0}, {0,1},{-1,0}, {0,-1}};
            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node node = queue.poll();
                    if (node.i == m-1 && node.j == n-1) {
                        return steps;
                    }
                    for (int[] dir: dirs) {
                        int ni = node.i + dir[0];
                        int nj = node.j + dir[1];
                        if (ni < 0 || nj < 0 || ni >= m || nj >= n)
                            continue;
                        int nK = node.k + grid[ni][nj];
                        if (nK >= kCount[ni][nj] || nK > k) 
                            continue;
                        kCount[ni][nj] = nK;
                        queue.add(new Node(ni, nj, nK));
                    }
                }
                steps++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = { { 0, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 1 }, { 0, 1 },
                { 0, 1 }, { 0, 0 }, { 1, 0 }, { 1, 0 }, { 0, 0 } };

        int k1 = 4;
        LC1293ShortestPathInGrid obj = new LC1293ShortestPathInGrid();
        System.out.println(obj.shortestPath(grid1, k1));

        int[][] grid = { { 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0, 0, 1, 0 } };
        int k = 1;

        System.out.println(obj.shortestPath(grid, k));

    }

}
