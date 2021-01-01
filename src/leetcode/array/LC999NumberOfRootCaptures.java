package leetcode.array;

public class LC999NumberOfRootCaptures {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }

        int result = 0;

        int x = -1, y = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'p') {
                result++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }

        }

        for (int i = x; i < board[x].length; i++) {

            if (board[i][y] == 'p') {
                result++;
                break;
            }
            if (board[i][y] == 'B') {
                break;
            }

        }

        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 'p') {
                result++;
                break;
            }
            if (board[x][i] == 'B') {
                break;
            }

        }

        for (int i = y; i < board.length; i++) {

            if (board[x][i] == 'p') {
                result++;
                break;
            }
            if (board[x][i] == 'B') {
                break;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        LC999NumberOfRootCaptures obj = new LC999NumberOfRootCaptures();
        char[][] board = { { '.', '.', 'p', '.', '.', '.' }, { '.', 'p', '.', '.', '.', '.' },
                { '.', '.', 'R', '.', '.', '.' }, { '.', '.', 'B', '.', '.', '.' } };
        System.out.println(obj.numRookCaptures(board));

    }

}
