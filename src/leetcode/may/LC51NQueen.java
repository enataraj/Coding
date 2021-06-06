package leetcode.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC51NQueen {

    /*
     * It's my first blog post. Please give a feedback
    Intuition: Let's try to understand the situation in stepwise manner :
    
    We know that at every row only one queen can be placed.
    So basically we'll try placing i'th queen in the i'th row for all the columns.
    If successful, we'll mark that position in our board with 'Q' and call our helper method : solveNQueenHelper() for the i+1'th queen.
    Base Case - if I've successfully placed all the 'n' queens then my k will be equal to n and I just have to capture the board at that moment and add it to my ans list.
    Imp. Note : Once the function returns , you've to demark the board again i.e replace 'Q' with '.' - since we have to try for further positions as well. This is the backtracking step.
    placeQueenMethod: - This checks whether I can successfully place my queen at the given (i,j) position in my board. Checks reqd -
    
    Position Check : whether a Queen exists at that particular position
    Row Check : whether a Queen exists in that row
    Column Check : whether a Queen is present in that column
    Upper Right and Upper Left Diagonal Check : self-explanatory
    Note : Since we're moving in top-down fashion, we just have to look in the upper portion of the board. I could've optimised my checks for that as well, but I was lazy to do it :p
    
    P.S Hope it helps.
     */

    public static boolean placeQueen(int i, int j, char[][] board) {
        int n = board.length;
        //check position
        if (board[i][j] != '.')
            return false;

        //check row
        for (int col = 0; col < n; col++) {
            if (board[i][col] == 'Q')
                return false;
        }

        //check col
        for (int row = 0; row < n; row++) {
            if (board[row][j] == 'Q')
                return false;
        }

        //check right upper Diagonal
        int i1 = i - 1;
        int j1 = j + 1;
        while (i1 >= 0 && j1 < n) {
            if (board[i1][j1] == 'Q')
                return false;
            i1--;
            j1++;
        }

        //check left upper Diagonal
        i1 = i - 1;
        j1 = j - 1;
        while (i1 >= 0 && j1 >= 0) {
            if (board[i1][j1] == 'Q')
                return false;
            i1--;
            j1--;
        }

        return true;

    }

    public static void solveNQueenHelper(int i, int k, char[][] board, List<List<String>> ans) {
        int n = board.length;
        if (k == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : board) {
                String str = String.valueOf(c);
                list.add(str);
            }
            ans.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (placeQueen(i, col, board)) {
                board[i][col] = 'Q';
                solveNQueenHelper(i + 1, k + 1, board, ans);
                board[i][col] = '.'; //imp step - backtracking - as we have to demark the board again for checking further solution
            }
        }
        return; // just return as everything has been done for that row
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solveNQueenHelper(0, 0, board, ans);
        return ans;

    }
}

class Solution {
    char[][] board;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        res = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        solveRec(0);
        return res;
    }

    List<String> construct() {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    void solveRec(int col) {
        int N = board.length;
        if (col == N) {
            res.add(construct());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 'Q';
                solveRec(col + 1);
                board[i][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    class Anothersol {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] row : board) {
                Arrays.fill(row, '.');
            }
            List<List<String>> ans = new ArrayList<>();
            helper(board, 0, 0, 0, 0, ans);
            return ans;
        }

        public void helper(char[][] board, int i, int cols, int diag, int adiag, List<List<String>> ans) {
            if (i == board.length) {
                List<String> rows = new ArrayList<>();
                for (char[] row : board) {
                    rows.add(String.valueOf(row));
                }
                ans.add(rows);
                return;
            }
            int n = board.length, available = ((1 << n) - 1 & (~(cols | diag | adiag)));
            while (available != 0) {
                int lowest = available & (-available);
                available = available & (available - 1);
                int j = Integer.bitCount(lowest - 1);
                board[i][j] = 'Q';
                helper(board, i + 1, cols ^ lowest, (diag | lowest) >> 1, (adiag | lowest) << 1, ans);
                board[i][j] = '.';
            }
        }
    }

}
