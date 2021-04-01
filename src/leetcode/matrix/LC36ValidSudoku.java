package leetcode.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        // Row check
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        // Column Check
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && rowSet.contains(board[j][i])) {
                    return false;
                }
                rowSet.add(board[j][i]);
            }

        }

        // Left Top

        Set<Character> rowSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {

            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();

        for (int i = 0; i < 3; i++) {

            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();

        for (int i = 3; i < 6; i++) {

            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        rowSet = new HashSet<>();
        for (int i = 6; i < 9; i++) {

            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);
            }

        }

        return true;
    }

    public boolean isValidSudokuSol(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

        LC36ValidSudoku obj = new LC36ValidSudoku();
        System.out.println(obj.isValidSudoku(board));

    }

}
