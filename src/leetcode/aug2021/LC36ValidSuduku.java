package leetcode.aug2021;

import java.util.HashSet;
import java.util.Set;

public class LC36ValidSuduku {
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
                char curCh = board[i][j];
                if (curCh == '.') {
                    continue;
                }
                if (rowSet[i].contains(curCh)) {
                    return false;
                }
                if (colSet[j].contains(curCh)) {
                    return false;
                }

                int idx = (i / 3) * 3 + (j / 3);
                if (boxSet[idx].contains(curCh)) {
                    return false;
                }

                rowSet[i].add(curCh);
                colSet[j].add(curCh);
                boxSet[idx].add(curCh);

            }
        }

        return true;
    }

}
