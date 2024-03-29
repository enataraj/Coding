package leetcode.oct2021;

public class LC463FindPermeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 1;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 1;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 1;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 1;
                    }
                }
            }
        }
        return perimeter;
    }

    public int islandPerimeterSol(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        ans -= 2;
                    if (j > 0 && grid[i][j - 1] == 1)
                        ans -= 2;
                }
            }
        }

        return ans;
    }

}
