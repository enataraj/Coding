package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    private boolean isIndexValid(int row, int column, int mr, int mc) {
        if (row < mr && column < mc && row >= 0 && column >= 0) {
            return true;
        }
        return false;

    }

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }

        if (board.length <= 0 || board[0].length <= 0) {
            return;
        }

        int mr = board.length;
        int mc = board[0].length;
        System.out.println("\n Row : " + mr + " Column :" + mc);

        int count = 0;
        Set<String> zeros = new HashSet<>();

        for (int i = 0; i < mc; i++) {
            // First Row Contains Zero
            if (board[0][i] == 'O') {
                zeros.add(0 + "#" + i);
                count++;

            }

            // Last Row Contains Zero
            if (board[mr - 1][i] == 'O') {
                zeros.add(mr - 1 + "#" + i);
                count++;

            }

        }

        for (int i = 0; i < mr; i++) {
            // First column contains zero
            if (board[i][0] == 'O') {
                zeros.add(i + "#" + 0);
                count++;

            }
            // Last colmn contains zero
            if (board[i][mc - 1] == 'O') {
                zeros.add(i + "#" + (mc - 1));
                count++;

            }

        }
       // System.out.println();
        if (count == 0) {

            for (int i = 0; i < mr; i++) {
                for (int j = 0; j < mc; j++) {
                    board[i][j] = 'X';
                }
            }
            return;
        }

        for (String str : zeros) {
            int curr_row = Integer.parseInt(str.split("#")[0]);
            int curr_col = Integer.parseInt(str.split("#")[1]);
            dfs(board, curr_row, curr_col, mr, mc);

        }
        for (int i = 0; i < mr; i++) {
            for (int j = 0; j < mc; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

        printBoard(board);

    }

    private void dfs(char[][] board, int row, int col, int mr, int mc) {
        if (!isIndexValid(row, col, mr, mc)) {
            return;
        }
        if (board[row][col] == 'X' || board[row][col] == 'Y') {
            return;
        }
        board[row][col] = 'Y';
        dfs(board, row + 1, col, mr, mc);
        dfs(board, row - 1, col, mr, mc);
        dfs(board, row, col + 1, mr, mc);
        dfs(board, row, col - 1, mr, mc);
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("  " + board[i][j]);

            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions obj = new SurroundedRegions();
        char[][] board = { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X', 'X' }, { 'X', 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'X', 'X', 'X' } };
        obj.printBoard(board);
        obj.solve(board);
        System.out.println();
        obj.printBoard(board);
    }

}
