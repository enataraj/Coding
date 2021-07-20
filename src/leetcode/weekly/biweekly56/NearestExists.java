package leetcode.weekly.biweekly56;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestExists {

    public int nearestExit(char[][] maze, int[] entrance) {
        Set<String> exists = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int rows = maze.length;
        int colms = maze[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            if (maze[i][0] == '.') {
                exists.add(i + "#" + 0);
            }
            if (maze[i][colms - 1] == '.') {
                exists.add(i + "#" + (colms - 1));
            }
        }

        for (int i = 0; i < colms; i++) {
            if (maze[0][i] == '.') {
                exists.add(0 + "#" + i);
            }
            if (maze[rows - 1][i] == '.') {
                exists.add((rows - 1) + "#" + i);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(entrance[0] + "#" + entrance[1]);
        visited.add(entrance[0] + "#" + entrance[1]);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (exists.contains(str) && !str.equals(entrance[0] + "#" + entrance[1])) {
                    return res;
                }
                int row = Integer.parseInt(str.split("#")[0]);
                int col = Integer.parseInt(str.split("#")[1]);

                for (int[] dir : dirs) {
                    int newR = dir[0] + row;
                    int newC = dir[1] + col;
                    if (isValid(maze, newR, newC, rows, colms)) {
                        maze[newR][newC] = '+';
                        queue.add(newR + "#" + newC);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean isValid(char[][] grid, int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '.') {
            return true;
        }
        return false;
    }
}
