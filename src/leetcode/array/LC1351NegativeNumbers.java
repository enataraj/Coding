package leetcode.array;

public class LC1351NegativeNumbers {

    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        LC1351NegativeNumbers obj = new LC1351NegativeNumbers();
        int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(obj.countNegatives(grid));
    }

}
