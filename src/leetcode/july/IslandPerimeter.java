package leetcode.july;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;

        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    int nei = 0;

                    for (int[] dir : dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if ((nextI >= 0 && nextJ >= 0 && nextI < rows && nextJ < cols) && (grid[nextI][nextJ] == 1)) {
                            nei++;
                        }
                    }

                    count = count + (4 - nei);

                }

            }
        }

        return count;

    }

    public int islandPerimeterEff(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0)
                    perimeter++;
                if (i == n - 1 || grid[i + 1][j] == 0)
                    perimeter++;
                if (j == 0 || grid[i][j - 1] == 0)
                    perimeter++;
                if (j == m - 1 || grid[i][j + 1] == 0)
                    perimeter++;
            }
        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter obj = new IslandPerimeter();

        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };

        int result = obj.islandPerimeterEff(grid);
        System.out.println("Result : " + result);
    }

}
