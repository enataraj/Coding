package leetcode.jan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1631PathtoMinEffort {

    // DFS Solution
    int result = Integer.MAX_VALUE;
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPathDFS(int[][] heights) {
        boolean[][] visited;

        int start = 0;
        int end = 1000001;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            visited = new boolean[heights.length][heights[0].length];
            if (dfsHelpher(heights, 0, 0, visited, mid)) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;

    }
    
    

    private boolean dfsHelpher(int[][] heights, int row, int col, boolean[][] visited, int currentEffort) {
        if (row == heights.length - 1 && col == heights[0].length - 1) {
            return true;
        }

        visited[row][col] = true;

        boolean tmpRes = false;
        for (int i = 0; i < dirs.length; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if (isValid(newRow, newCol, heights.length - 1, heights[0].length - 1) && !visited[newRow][newCol]
                    && Math.abs(heights[row][col] - heights[newRow][newCol]) <= currentEffort) {
                tmpRes = tmpRes || dfsHelpher(heights, newRow, newCol, visited, currentEffort);

            }
        }

        return tmpRes;

    }

    private boolean isValid(int row, int col, int maxRow, int maxCol) {
        if (row >= 0 && row <= maxRow && col >= 0 && col <= maxCol) {
            return true;
        }
        return false;
    }

    // Same Solution via BFS

    public int minimumEffortPathBFS(int[][] heights) {

        int start = 0;
        int end = 1000001;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (bfsHelpher(heights, mid)) {
                result = Math.min(result, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;

    }

    private boolean bfsHelpher(int[][] heights, int currentEffort) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        while (queue.size() > 0) {
            int[] data = queue.poll();
            int row = data[0];
            int col = data[1];

            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(newRow, newCol, heights.length - 1, heights[0].length - 1) && !visited[newRow][newCol]
                        && Math.abs(heights[row][col] - heights[newRow][newCol]) <= currentEffort) {
                    queue.add(new int[] { newRow, newCol });
                    visited[newRow][newRow] = true;
                }
            }

        }
        return false;
    }

    // Dijistra Algorithm Single source shortest distance

    public int minimumEffortPath(int[][] heights) {

        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[] { 0, 0, 0 });
        int[][] cost = new int[heights.length][heights[0].length];
        for (int i = 0; i < cost.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        while (queue.size() > 0) {
            int[] data = queue.poll();
            int row = data[0];
            int col = data[1];
            int effort = data[2];

            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return effort;
            }
            visited[row][col] = true;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(newRow, newCol, heights.length - 1, heights[0].length - 1) && !visited[newRow][newCol]) {
                    int maxCost = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), cost[row][col]);

                    if (maxCost < cost[newRow][newCol]) {
                        cost[newRow][newCol] = maxCost;
                        queue.add(new int[] { newRow, newCol, cost[newRow][newCol] });
                    }
                    queue.add(new int[] { newRow, newCol, cost[newRow][newCol] });
                }
            }

        }
        return -1;
    }

    public int minimumEffortPathSol(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            if (cur[0] > dist[cur[1]][cur[2]]) {
                continue;
            }
            if (cur[1] == m - 1 && cur[2] == n - 1) {
                return cur[0];
            }
            dist[cur[1]][cur[2]] = cur[0];
            for (int[] dir : dirs) {
                int nexX = cur[1] + dir[0], nexY = cur[2] + dir[1];
                if (nexX >= 0 && nexX < m && nexY >= 0 && nexY < n) {
                    int effort = Math.max(cur[0], Math.abs(heights[cur[1]][cur[2]] - heights[nexX][nexY]));
                    if (effort < dist[nexX][nexY]) {
                        pq.add(new int[] { effort, nexX, nexY });
                        dist[nexX][nexY] = effort;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1631PathtoMinEffort obj = new LC1631PathtoMinEffort();
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

        System.out.println(obj.minimumEffortPath(heights));

    }

}
