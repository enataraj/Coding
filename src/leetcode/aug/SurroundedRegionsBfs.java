package leetcode.aug;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegionsBfs {

    void solveBFS(char[][] board) {
        Queue<String> zeros = new LinkedList<>();
        int[][] posibleDir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
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
        System.out.println();
        if (count == 0) {

            for (int i = 0; i < mr; i++) {
                for (int j = 0; j < mc; j++) {
                    board[i][j] = 'X';
                }
            }
            return;
        }

        while (!zeros.isEmpty()) {
            System.out.println("\nQueue Element " + zeros);
            String str = zeros.poll();
            int curr_row = Integer.parseInt(str.split("#")[0]);
            int curr_col = Integer.parseInt(str.split("#")[1]);
            board[curr_row][curr_col] = 'Y';
            for (int i = 0; i < posibleDir.length; i++) {
                int[] pos = posibleDir[i];
                int new_row = curr_row + pos[0];
                int new_col = curr_col + pos[1];
                if (isIndexValid(new_row, new_col, mr, mc) && board[new_row][new_col] == 'O') {
                    zeros.add(new_row + "#" + new_col);
//                    printBoard(board);
                }
            }
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

    }

    private boolean isIndexValid(int row, int column, int mr, int mc) {
        if (row < mr && column < mc && row >= 0 && column >= 0) {
            return true;
        }
        return false;

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
        SurroundedRegionsBfs obj = new SurroundedRegionsBfs();
        char[][] board = { { 'X', 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X', 'X' }, { 'X', 'O', 'O', 'X', 'X' },
                { 'X', 'O', 'X', 'X', 'X' } };
        char[][] board1 = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        obj.printBoard(board);
        obj.solveBFS(board);
        System.out.println();
        obj.printBoard(board);

    }

}
