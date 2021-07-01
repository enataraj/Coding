import java.util.HashSet;
import java.util.Set;

public class Weekly {
    public String largestOddNumber(String num) {
        Set<Character> oddSet = new HashSet<>();
        oddSet.add('1');
        oddSet.add('3');
        oddSet.add('5');
        oddSet.add('7');
        oddSet.add('9');

        String restult = "";

        for (int i = num.length() - 1; i >= 0; i--) {
            if (oddSet.contains(num.charAt(i))) {
                restult = num.substring(0, i + 1);
                break;
            }
        }

        return restult;
    }

    public int numberOfRounds(String startTime, String finishTime) {

        int start_hr = Integer.parseInt(startTime.split(":")[0]);
        int start_min = Integer.parseInt(startTime.split(":")[1]);
        int end_hr = Integer.parseInt(finishTime.split(":")[0]);
        int end_min = Integer.parseInt(finishTime.split(":")[1]);

        int result = 0;
        start_min = nextStartMin(start_min);
        end_min = preEndTime(end_min);

        start_min = (start_hr * 60) + start_min;
        end_min = (end_hr * 60) + end_min;

        if (start_min > end_min) {
            end_min += 24 * 60;
        }
        int totalMin = end_min - start_min;

        result = totalMin / 15;

        return result;

    }

    private int nextStartMin(int start_min) {

        if (start_min == 0 || start_min == 15 || start_min == 30 || start_min == 45) {
            return start_min;
        }
        if (start_min > 0 && start_min < 15) {
            return 15;
        }
        if (start_min > 15 && start_min < 30) {
            return 30;
        }
        if (start_min > 30 && start_min < 45) {
            return 45;
        }
        return 60;
    }

    private int preEndTime(int end_min) {
        if (end_min == 0 || end_min == 15 || end_min == 30 || end_min == 45) {
            return end_min;
        }
        if (end_min > 0 && end_min < 15) {
            return 0;
        }
        if (end_min > 15 && end_min < 30) {
            return 15;
        }
        if (end_min > 30 && end_min < 45) {
            return 30;
        }
        return 45;

    }

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean flag = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;

        int rows = grid2.length - 1;
        int cols = grid2[0].length - 1;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid2[i][j] == 1) {
                    grid2[i][j] = 0;
                    dfsHelper(grid2, i, j, rows, cols, grid1);
                    if (flag) {
                        result++;
                        
                    }
                    flag = true;

                }
            }
        }
        return result;
    }

    private void dfsHelper(int[][] grid2, int row, int col, int rows, int cols, int[][] grid1) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(grid2, newR, newC, rows, cols)) {
                grid2[newR][newC] = 0;
                if (grid1[newR][newC] == 0) {
                    flag = false;
                }
                dfsHelper(grid2, newR, newC, rows, cols, grid1);

            }

        }

    }

    private boolean isValid(int[][] grid, int row, int col, int rows, int cols) {
        if (row >= 0 && row <= rows && col >= 0 && col <= cols && grid[row][col] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Weekly obj = new Weekly();
        System.out.println(obj.largestOddNumber("3"));

        System.out.println(obj.numberOfRounds("12:01", "12:44"));
        System.out.println(obj.numberOfRounds("00:01", "00:00"));
        System.out.println(obj.numberOfRounds("23:46", "00:01"));

    }
}
