package leetcode.matrix.dfs;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null || word.isEmpty()) {
            return false;
        }

        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((word.charAt(0)==board[i][j]) && dfs(board, word, dirs, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(char[][] board, String word, int[][] dirs, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        } else if (!isValid(board, i, j) || board[i][j] == '$') {
            return false;

        }

        char ch = word.charAt(pos);
        if (board[i][j] != ch) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$'; // marking visited

        for (int[] dir : dirs) {
            int nextX = i + dir[0], nextY = j + dir[1];

            if (dfs(board, word, dirs, nextX, nextY, pos + 1)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;

    }

    private boolean isValid(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
    
    
    
    //time : O(m*n*4^l) l is the word's length
    public boolean existOpt(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] array = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == array[0] &&
                        dfsOpt(board, i, j, m, n, 0, array)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsOpt(char[][] board, int i, int j,
                        int m, int n, int cur, char[] word) {
        if (cur == word.length) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word[cur]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        boolean ans = dfsOpt(board, i - 1, j, m, n, cur + 1, word) ||
                dfsOpt(board, i + 1, j, m, n, cur + 1, word) ||
                dfsOpt(board, i, j - 1, m, n, cur + 1, word) ||
                dfsOpt(board, i, j + 1, m, n, cur + 1, word);
        board[i][j] = tmp;
        return ans;


    }

    public static void main(String[] args) {
        WordSearch search = new WordSearch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(search.exist(board, word));

    }

}
