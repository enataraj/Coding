package leetcode.sep;

public class UniquePath3 {

    private int pathCount = 0;
    private int totalSteps = 0;
    private int paths = 0;

    public int uniquePathsIII(int[][] grid) {
        paths = 0;
        int[] locs = getStartLocAndEmptyLocs(grid);
        totalSteps = locs[2] + 1;
        exploreNext(grid, locs[0], locs[1], 0);
        return paths;
    }

    private int[] getStartLocAndEmptyLocs(int[][] grid) {
        int[] ans = new int[3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans[0] = i;
                    ans[1] = j;
                } else if (grid[i][j] == 0) {
                    ans[2]++;
                }
            }
        }
        return ans;
    }

    private static int[][] positionDelta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private static boolean notVisited(int[][] grid, int i, int j) {
        // check in bound
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        // check state
        return grid[i][j] == 0 || grid[i][j] == 2;
    }

    private void exploreNext(int[][] grid, int i, int j, int steps) {
        if (grid[i][j] == 2) {
            if (totalSteps == steps) {
                paths++;
            }
            return;
        }
        int old = grid[i][j];
        grid[i][j] = 1; // mark as visited
        for (int[] delta : positionDelta) {
            int nbi = i + delta[0];
            int nbj = j + delta[1];
            if (notVisited(grid, nbi, nbj)) {
                exploreNext(grid, nbi, nbj, steps + 1);
            }
        }
        grid[i][j] = old;
    }

    public int uniquePathsIII_Visited(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int org_pos_i = 0;
        int org_pos_j = 0;
        int zeros = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    org_pos_i = i;
                    org_pos_j = j;

                }
                if (grid[i][j] == 0) {
                    zeros++;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        dfsHelper_Visited(grid, visited, org_pos_i, org_pos_j, zeros);
        return pathCount;
    }

    private void dfsHelper_Visited(int[][] grid, boolean[][] visited, int i, int j, int zeros) {

        if (grid[i][j] == 2) {
            if (zeros == 0) {
                pathCount = pathCount + 1;
            }
            return;
        }

        visited[i][j] = true;
        if (grid[i][j] == 0) {
            zeros = zeros - 1;
        }

        if (isValidIndx_Visited(grid, visited, i - 1, j)) {

            dfsHelper_Visited(grid, visited, i - 1, j, zeros);
        }
        if (isValidIndx_Visited(grid, visited, i, j - 1)) {

            dfsHelper_Visited(grid, visited, i, j - 1, zeros);
        }
        if (isValidIndx_Visited(grid, visited, i + 1, j)) {

            dfsHelper_Visited(grid, visited, i + 1, j, zeros);
        }

        if (isValidIndx_Visited(grid, visited, i, j + 1)) {

            dfsHelper_Visited(grid, visited, i, j + 1, zeros);
        }

        visited[i][j] = false;
        zeros = zeros + 1;

    }

    private boolean isValidIndx_Visited(int[][] grid, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] != -1
                && grid[i][j] != 1) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        UniquePath3 obj = new UniquePath3();
        // int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };

      //  int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        
        int[][] grid = { { 1, 0, 0,1}, { 0, 0, 0, -1 }, { 0, 0, 0, 2 } };
        System.out.println(obj.uniquePathsIII(grid));

    }
}
