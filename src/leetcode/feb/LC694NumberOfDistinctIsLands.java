package leetcode.feb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC694NumberOfDistinctIsLands {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0)
            return 0;
        StringBuilder builder;
        int rows = grid.length;
        int columns = grid[0].length;
        Set<String> uniqueShapeIslands = new HashSet<String>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == 1) {
                    builder = new StringBuilder("C");
                    numIslandsHelper(grid, row, col, builder);
                    uniqueShapeIslands.add(builder.toString());
                }
            }
        }
        return uniqueShapeIslands.size();
    }

    private void numIslandsHelper(int[][] grid, int row, int col, StringBuilder builder) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
            return;
        grid[row][col] = 0;
        numIslandsHelper(grid, row + 1, col, builder.append('D'));
        numIslandsHelper(grid, row - 1, col, builder.append('U'));
        numIslandsHelper(grid, row, col + 1, builder.append('R'));
        numIslandsHelper(grid, row, col - 1, builder.append('L'));
    }

    public int numDistinctIslandsBFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, islandId = 2;

        final int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, dirs, islandId);
                    ++islandId;
                }
            }
        }

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 1) {
                    map.putIfAbsent(grid[i][j], new ArrayList<>());
                    map.get(grid[i][j]).add(new int[] { i, j });
                }
            }
        }

        Set<String> uniques = new HashSet<>();
        for (List<int[]> island : map.values()) {
            uniques.add(serialize(island));
        }

        return uniques.size();

    }

    private String serialize(List<int[]> island) {
        int[] offset = new int[] { -island.get(0)[0], -island.get(0)[1] };

        StringBuilder sb = new StringBuilder();
        for (int[] p : island) {
            p[0] += offset[0];
            p[1] += offset[1];
            sb.append(Arrays.toString(p));
        }

        return sb.toString();
    }

    private void bfs(int[][] grid, int x, int y, int[][] dirs, int islandId) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        grid[x][y] = islandId;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0], nextY = cur[1] + dir[1];

                if (isValid(grid, nextX, nextY) && grid[nextX][nextY] == 1) {

                    grid[nextX][nextY] = islandId;
                    q.add(new int[] { nextX, nextY });
                }
            }
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

}
