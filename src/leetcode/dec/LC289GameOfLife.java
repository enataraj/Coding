package leetcode.dec;

import java.util.Arrays;

public class LC289GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rowLen = board.length;
        int colLen = board[0].length;

        int[][] tmpBoard = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            tmpBoard[i] = Arrays.copyOf(board[i], colLen);
        }

        int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (tmpBoard[i][j] == 1) {

                    int cnt = 0;

                    for (int[] dir : dirs) {
                        if (isValid(i, j, dir[0], dir[1], rowLen, colLen) && tmpBoard[i + dir[0]][j + dir[1]] == 1) {

                            cnt++;
                        }
                    }

                    if (cnt == 2 || cnt == 3) {
                        board[i][j] = 1;
                    }
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 0;
                    }

                } else if (tmpBoard[i][j] == 0) {
                    int cnt = 0;

                    for (int[] dir : dirs) {
                        if (isValid(i, j, dir[0], dir[1], rowLen, colLen) && tmpBoard[i + dir[0]][j + dir[1]] == 1) {

                            cnt++;
                        }
                    }
                    if (cnt == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        /*
         * for (int i = 0; i < rowLen; i++) {
         * System.out.println(Arrays.toString(board[i])); }
         */

    }

    private boolean isValid(int i, int j, int x, int y, int rowLen, int colLen) {
        if ((i + x >= 0) && (i + x < rowLen) && (j + y >= 0) && (j + y < colLen)) {
            return true;
        }
        return false;
    }

    // Without Extra Space

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };

    public void gameOfLifeSol(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] dir : dirs) {
                    int p = dir[0] + i;
                    int q = dir[1] + j;
                    if (p < 0 || q < 0 || p >= m || q >= n)
                        continue;
                    if (board[p][q] == 1 || board[p][q] == 2)
                        live++;
                }
                if (board[i][j] == 0 && live == 3)
                    board[i][j] = 3;
                if (board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 2;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
    
    
    
/*
    
    oldVal newVal --> Mapping
      0     0            2
      0     1            3
      1     0            4
      1     1            5
    */
    public void gameOfLifeParin(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int rows = board.length,
            cols = board[0].length;
        
        updateState(board);
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                    
                } else if (board[i][j] == 4) {
                    board[i][j] = 0;
                    
                }
            }
        }
        
    }
    
    private void updateState(int[][] board) {
        int rows = board.length,
            cols = board[0].length;
        
        int[][] dirs = new int[][]{{-1,0}, {-1,-1}, {0,-1}, {1,-1},{1,0}, {1,1}, {0,1}, {-1,1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    int liveNeighbors = getLiveNeighbors(board, i, j, dirs);
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 4;
                    }
                    
                } else if (board[i][j] == 0) {
                    int liveNeighbors = getLiveNeighbors(board, i, j, dirs);
                    if (liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
    }
    
    private int getLiveNeighbors(int[][] board, int x, int y, int[][] dirs) {
        int liveNeighbors = 0;
        
        for (int[] dir : dirs) {
            int nextX = x + dir[0],
                nextY = y + dir[1];
            
            if (isValid(board, nextX, nextY) 
                && (board[nextX][nextY] == 1 
                    || board[nextX][nextY] == 4 
                    || board[nextX][nextY] == 5)) {
                ++liveNeighbors;
            }
        }
        
        return liveNeighbors;
    }
    
    private boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static void main(String[] args) {
        LC289GameOfLife obj = new LC289GameOfLife();
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        obj.gameOfLife(board);
    }

}
