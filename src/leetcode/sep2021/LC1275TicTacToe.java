package leetcode.sep2021;

public class LC1275TicTacToe {

    public String tictactoe(int[][] moves) {
        if (moves.length < 3) {
            return "Pending";
        }

        int[] rowCnt = new int[3];
        int[] colCnt = new int[3];
        int digCnt = 0;
        int antiDigCnt = 0;

        int i = 0;
        for (int[] move : moves) {
            if (i % 2 == 0) {
                // Diagonal check
                if (move[0] == move[1]) {
                    digCnt += 1;
                    if (digCnt == 3) {

                        return "A";
                    }
                }
                // Anti Digonal check
                if (move[0] + move[1] == 2) {
                    antiDigCnt += 1;
                    if (antiDigCnt == 3) {
                        return "A";
                    }
                }
                
                rowCnt[move[0]] += 1;
                colCnt[move[1]] += 1;
                if (rowCnt[move[0]] == 3) {
                    return "A";
                }
                if (colCnt[move[1]] == 3) {
                    return "A";
                }
            } else {
                // diagonal check
                if (move[0] == move[1]) {
                    digCnt -= 1;
                    if (digCnt == -3) {
                        return "B";
                    }
                }

                // Anti Digonal check
                if (move[0] + move[1] == 2) {
                    antiDigCnt -= 1;
                    if (antiDigCnt == -3) {
                        return "B";
                    }
                }

                rowCnt[move[0]] -= 1;
                colCnt[move[1]] -= 1;
                if (rowCnt[move[0]] == -3) {
                    return "B";
                }
                if (colCnt[move[1]] == -3) {
                    return "B";
                }
            }
            i++;
        }

        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";

    }

    public String tictactoeBf(int[][] moves) {

        if (moves.length < 3) {
            return "Pending";
        }

        int[][] grid = new int[3][3];
        int i = 0;
        for (int[] move : moves) {
            if (i % 2 == 0) {
                grid[move[0]][move[1]] = 1;
                if (isFinish(grid, 1)) {
                    return "A";
                }
            } else {
                grid[move[0]][move[1]] = 2;
                if (isFinish(grid, 2)) {
                    return "B";
                }
            }
            i++;
        }

        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private boolean isFinish(int[][] grid, int player) {

        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[2][0] == player && grid[1][1] == player && grid[0][2] == player) {
            return true;
        }
        for (int i = 0; i < grid.length; i++) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == player) {
                    cnt1++;
                }
                if (grid[j][i] == player) {
                    cnt2++;
                }
            }
            if (cnt1 == 3) {
                return true;
            }

            if (cnt2 == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC1275TicTacToe obj = new LC1275TicTacToe();
        int[][] moves = { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
        System.out.println(obj.tictactoe(moves));
    }

}
