package leetcode.feb;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid[0][0] == 1)
            return -1;
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        grid[0][0] = 2;
        int shortestLength = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int data[] = queue.poll();
                int row = data[0];
                int col = data[1];

                if (row == maxRow - 1 && col == maxCol - 1)
                    return shortestLength;

                if (row + 1 < maxRow && col + 1 < maxCol && grid[row + 1][col + 1] == 0) {
                    queue.add(new int[] { row + 1, col + 1 });
                    grid[row + 1][col + 1] = 2;

                }
                if (row + 1 < maxRow && grid[row + 1][col] == 0) {
                    queue.add(new int[] { row + 1, col });
                    grid[row + 1][col] = 2;

                }
                if (col + 1 < maxCol && grid[row][col + 1] == 0) {
                    queue.add(new int[] { row, col + 1 });
                    grid[row][col + 1] = 2;

                }

                if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                    queue.add(new int[] { row - 1, col });
                    grid[row - 1][col] = 2;

                }

                if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                    queue.add(new int[] { row, col - 1 });
                    grid[row][col - 1] = 2;

                }
                if (row - 1 >= 0 && col + 1 < maxCol && grid[row - 1][col + 1] == 0) {
                    queue.add(new int[] { row - 1, col + 1 });
                    grid[row - 1][col + 1] = 2;

                }

                if (row + 1 < maxRow && col - 1 >= 0 && grid[row + 1][col - 1] == 0) {
                    queue.add(new int[] { row + 1, col - 1 });
                    grid[row + 1][col - 1] = 2;

                }

                if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0) {
                    queue.add(new int[] { row - 1, col - 1 });
                    grid[row - 1][col - 1] = 2;

                }

            }
            shortestLength++;

        }

        return -1;
    }

    public int shortestPathBinaryMatrixWorking(int[][] grid) {
        if (grid == null || grid[0][0] == 1)
            return -1;
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, 0, 1));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Data data = queue.poll();
                int row = data.row;
                int col = data.col;
                int shortestLength = data.sortestPath;

                if (row == maxRow - 1 && col == maxCol - 1)
                    return shortestLength;

                if (row + 1 < maxRow && col + 1 < maxCol && grid[row + 1][col + 1] == 0 && !visited[row + 1][col + 1]) {
                    queue.add(new Data(row + 1, col + 1, shortestLength + 1));
                    visited[row + 1][col + 1] = true;

                }
                if (row + 1 < maxRow && grid[row + 1][col] == 0 && !visited[row + 1][col]) {
                    queue.add(new Data(row + 1, col, shortestLength + 1));
                    visited[row + 1][col] = true;

                }
                if (col + 1 < maxCol && grid[row][col + 1] == 0 && !visited[row][col + 1]) {
                    queue.add(new Data(row, col + 1, shortestLength + 1));
                    visited[row][col + 1] = true;

                }

                if (row - 1 >= 0 && grid[row - 1][col] == 0 && !visited[row - 1][col]) {
                    queue.add(new Data(row - 1, col, shortestLength + 1));
                    visited[row - 1][col] = true;

                }

                if (col - 1 >= 0 && grid[row][col - 1] == 0 && !visited[row][col - 1]) {
                    queue.add(new Data(row, col - 1, shortestLength + 1));
                    visited[row][col - 1] = true;

                }
                if (row - 1 >= 0 && col + 1 < maxCol && grid[row - 1][col + 1] == 0 && !visited[row - 1][col + 1]) {
                    queue.add(new Data(row - 1, col + 1, shortestLength + 1));
                    visited[row - 1][col + 1] = true;

                }

                if (row + 1 < maxRow && col - 1 >= 0 && grid[row + 1][col - 1] == 0 && !visited[row + 1][col - 1]) {
                    queue.add(new Data(row + 1, col - 1, shortestLength + 1));
                    visited[row + 1][col - 1] = true;

                }

                if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0 && !visited[row - 1][col - 1]) {
                    queue.add(new Data(row - 1, col - 1, shortestLength + 1));
                    visited[row - 1][col - 1] = true;

                }

            }

        }

        return -1;
    }

    class Data {
        int row;
        int col;
        int sortestPath;

        public Data(int row, int col, int sortestPath) {
            this.row = row;
            this.col = col;
            this.sortestPath = sortestPath;
        }
    }

    public int shortestPathBinaryMatrixSol(int[][] grid) {
        int N = grid.length;
        // edge case
        if (grid[0][0] != 0 || grid[N - 1][N - 1] != 0) {
            return -1;
        }
        int len = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int size = q.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] n = q.poll();
                int r = n[0], c = n[1];
                // if reached end return len
                if (r == N - 1 && c == N - 1) {
                    return len;
                }
                // this is for 8 directions loop 9 possible combi's
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int nr = r + x;
                        int nc = c + y;
                        // validate
                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] == 0) {
                            // modify to not take this path again
                            grid[nr][nc] = 2;
                            q.add(new int[] { nr, nc });
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1091ShortestPathBinaryMatrix obj = new LC1091ShortestPathBinaryMatrix();
        // int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        // int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 0, 0, 0 } };
        System.out.println(obj.shortestPathBinaryMatrix(grid));

    }

}
