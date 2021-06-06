package leetcode.matrix;

import java.util.HashSet;
import java.util.Set;

public class LC36ValidSuduko {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet[] = new HashSet[9];
        Set<Character> colSet[] = new HashSet[9];
        Set<Character> boxSet[] = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch== '.') {
                    continue;
                }
               
                int idx = (i / 3) * 3 + (j / 3);
                if (rowSet[i].contains(ch) || colSet[j].contains(ch) || boxSet[idx].contains(ch)) {
                    return false;
                }
                rowSet[i].add(ch);
                colSet[j].add(ch);
                boxSet[idx].add(ch);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC36ValidSuduko obj = new LC36ValidSuduko();
    }

}
