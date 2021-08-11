package leetcode.aug2021;

public class LC1958CheckIftheMoveIsLegal {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char opColor = 'W';
        if (color == 'W') {
            opColor = 'B';
        }
        return horizantalValidMoveRight(board, rMove, cMove, color, opColor)
                || horizantalValidMoveLeft(board, rMove, cMove, color, opColor)
                || verticalValidMoveDown(board, rMove, cMove, color, opColor)
                || verticalValidMoveUp(board, rMove, cMove, color, opColor)
                || diagonalValidMoveToUPLeft(board, rMove, cMove, color, opColor)
                || diagonalValidMoveToDownRight(board, rMove, cMove, color, opColor)
                || diagonalValidMoveToDownLeft(board, rMove, cMove, color, opColor)
                || diagonalValidMoveToUpRight(board, rMove, cMove, color, opColor);

    }

    private boolean horizantalValidMoveRight(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            cMove = cMove + 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean horizantalValidMoveLeft(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            cMove = cMove - 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean verticalValidMoveDown(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove + 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean verticalValidMoveUp(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove - 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean diagonalValidMoveToUPLeft(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove - 1;
            cMove = cMove - 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean diagonalValidMoveToDownRight(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove + 1;
            cMove = cMove + 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean diagonalValidMoveToDownLeft(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove + 1;
            cMove = cMove - 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean diagonalValidMoveToUpRight(char[][] board, int rMove, int cMove, char color, char opColor) {
        int blankCellCnt = 0;
        int opColorCnt = 0;
        int maxR = board.length;
        int maxC = board[0].length;
        boolean foundColor = false;
        while (true) {
            rMove = rMove - 1;
            cMove = cMove + 1;
            if (isValid(rMove, cMove, maxR, maxC)) {
                if (board[rMove][cMove] == '.') {
                    blankCellCnt++;
                    break;
                }
                if (board[rMove][cMove] == opColor) {
                    opColorCnt++;
                }
                if (board[rMove][cMove] == color) {
                    foundColor = true;
                    break;
                }
            } else {
                break;
            }

        }
        return blankCellCnt == 0 && opColorCnt > 0 && foundColor;
    }

    private boolean isValid(int row, int col, int maxR, int maxC) {
        return row >= 0 && row < maxR && col >= 0 && col < maxC;
    }

    class Solution {
        public boolean checkMove(char[][] b, int r, int c, char color) {
            int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

            char op = color == 'W' ? 'B' : 'W'; //opposite color 

            for (int i = 0; i < 8; i++) {
                int x = r;
                int y = c;
                int count = 1;
                x += dirs[i][0];
                y += dirs[i][1];

                while (x < 8 && y < 8 && x >= 0 && y >= 0 && b[x][y] != '.') {
                    if (count != 1 && b[x][y] == color)
                        return true;

                    if (b[x][y] != op)
                        break;

                    x += dirs[i][0];
                    y += dirs[i][1];
                    count++;
                }
            }
            return false;
        }
    }

}
